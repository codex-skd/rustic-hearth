#!/usr/bin/env python3
"""Check every `rustic:*` id used by the Ancient Warfare 2 templates against the
current Rustic Hearth registry.

Reads `temp/aw2_rustic_ids.json`, builds the set of names registered by the new mod
(from generated assets, lang keys and the Java registration code), applies an explicit
mapping dictionary for the ids that do not match by name, and prints one line per id
with status EXACT / MAPPED / DROP / UNRESOLVED plus a final summary.

Exits with a non-zero status if any id is UNRESOLVED.
Standard library only; run from the project directory:
    python docs/tools/check_template_ids.py
"""

import json
import os
import re
import sys

# --------------------------------------------------------------------------- config

# Old 1.12 name -> list of new registered names. Only ids whose name changed (or that
# are flattened into several blocks) need an entry here.
MAPPING = {
    "leaves_apple": ["apple_leaves"],
    "sapling_apple": ["apple_sapling"],
    # 1.12 almanac item was registered as "book"
    "book": ["almanac"],
    # 1.12 "big_oak" is the old name of dark oak
    "chair_big_oak": ["chair_dark_oak"],
    "table_big_oak": ["table_dark_oak"],
    # potion effects
    "ironskin": ["iron_skin"],
    # metadata-flattened wood: meta 0 = olive, meta 1 = ironwood
    "log": ["olive_log", "ironwood_log"],
    "planks": ["olive_planks", "ironwood_planks"],
    "leaves": ["olive_leaves", "ironwood_leaves"],
    "sapling": ["olive_sapling", "ironwood_sapling"],
}

# Ids to drop: 1.12 tile-entity names that have no registry equivalent.
DROP_PREFIXES = ("tileentity",)

NAMESPACE = "rustic_hearth"
ASSETS = os.path.join("src", "generated", "resources", "assets", NAMESPACE)
JAVA_ROOT = os.path.join("src", "main", "java", "com", "skd", "rustichearth")
LANG_FILE = os.path.join(ASSETS, "lang", "en_us.json")
BLOCKSTATES_DIR = os.path.join(ASSETS, "blockstates")
ITEM_MODELS_DIR = os.path.join(ASSETS, "models", "item")

# Matches the Java registration calls that take a literal name:
#   BLOCKS.register("name", ...), .registerBlock("name", ...), .registerSimpleBlock("name", ...)
#   ITEMS.registerItem("name", ...), .registerSimpleItem("name", ...), .register("name", ...)
#   EFFECTS.register("name", ...)   juice("name", ...)   booze("name", ...)
REGISTER_RE = re.compile(
    r'(?:registerSimpleBlock|registerBlock|registerSimpleItem|registerItem|register'
    r'|juice|booze)\s*\(\s*"([a-z0-9_]+)"'
)


def find_root():
    """Project root = two levels above this file (docs/tools/check_template_ids.py)."""
    here = os.path.dirname(os.path.abspath(__file__))
    return os.path.dirname(os.path.dirname(here))


def collect_registered_names(root):
    """Every name the new mod registers, from assets, lang keys and Java code."""
    names = set()

    for directory in (BLOCKSTATES_DIR, ITEM_MODELS_DIR):
        path = os.path.join(root, directory)
        if os.path.isdir(path):
            for entry in os.listdir(path):
                if entry.endswith(".json"):
                    names.add(entry[: -len(".json")])

    lang_path = os.path.join(root, LANG_FILE)
    if os.path.isfile(lang_path):
        with open(lang_path, encoding="utf-8") as handle:
            lang = json.load(handle)
        for key in lang:
            for prefix in ("block.", "item.", "fluid.", "effect.", "entity."):
                full = prefix + NAMESPACE + "."
                if key.startswith(full):
                    names.add(key[len(full):].split(".")[0])

    java_root = os.path.join(root, JAVA_ROOT)
    for base, _dirs, files in os.walk(java_root):
        for filename in files:
            if not filename.endswith(".java"):
                continue
            with open(os.path.join(base, filename), encoding="utf-8") as handle:
                text = handle.read()
            for match in REGISTER_RE.finditer(text):
                names.add(match.group(1))

    return names


def resolve(old_id, registered):
    """Return (status, targets) for one `rustic:<name>` id."""
    name = old_id.split(":", 1)[1]

    if name.startswith(DROP_PREFIXES):
        return "DROP", []

    if name in registered:
        return "EXACT", [name]

    if name in MAPPING:
        targets = MAPPING[name]
        missing = [target for target in targets if target not in registered]
        if missing:
            return "UNRESOLVED", targets
        return "MAPPED", targets

    return "UNRESOLVED", []


def main():
    root = find_root()
    json_path = os.path.join(root, "temp", "aw2_rustic_ids.json")
    if not os.path.isfile(json_path):
        print("ERROR: missing %s" % json_path, file=sys.stderr)
        return 2

    with open(json_path, encoding="utf-8") as handle:
        entries = json.load(handle)

    registered = collect_registered_names(root)

    counts = {"EXACT": 0, "MAPPED": 0, "DROP": 0, "UNRESOLVED": 0}
    mapped = []
    unresolved = []

    print("%-36s %-9s %-10s %-4s %s" % ("ID 1.12", "STATUS", "TARGET", "USES", "CONTEXTS"))
    print("-" * 100)
    for entry in entries:
        old_id = entry["id"]
        status, targets = resolve(old_id, registered)
        counts[status] += 1
        target = ", ".join(targets) if targets else "-"
        contexts = ",".join(sorted(entry.get("contexts", {})))
        print("%-36s %-9s %-30s %-4d %s" % (old_id, status, target, entry["count"], contexts))
        if status == "MAPPED":
            mapped.append((old_id, targets))
        elif status == "UNRESOLVED":
            unresolved.append(old_id)

    print("-" * 100)
    print("Total ids: %d" % len(entries))
    print("EXACT: %d  MAPPED: %d  DROP: %d  UNRESOLVED: %d" % (
        counts["EXACT"], counts["MAPPED"], counts["DROP"], counts["UNRESOLVED"]))

    print("\nRegistered names found in the new mod: %d" % len(registered))

    if mapped:
        print("\nMAPPED ids:")
        for old_id, targets in mapped:
            print("  %-24s -> %s" % (old_id, ", ".join(targets)))

    if unresolved:
        print("\nUNRESOLVED ids:")
        for old_id in unresolved:
            print("  %s" % old_id)

    if counts["UNRESOLVED"]:
        print("\nRESULT: FAIL (%d unresolved id(s))" % counts["UNRESOLVED"])
        return 1

    print("\nRESULT: OK")
    return 0


if __name__ == "__main__":
    sys.exit(main())
