"""Copies the Rustic Revived snapshot (temp/original) into a target project and renames it to Cottagecraft.

Usage: python rename_from_revived.py <snapshot dir> <target dir>

Renames paths and text content (java, json, toml, properties, gradle, md, mcmeta, txt) with ordered rules and
copies binary files (png) as they are. Does NOT touch an existing target file other than overwriting the ones it
copies. Never deletes anything. Original: Rustic Revived (MIT, NadienDev / Modern Mods); Rustic (MIT).
"""
import os, sys

TEXT_EXT = {'.java', '.json', '.toml', '.properties', '.gradle', '.md', '.mcmeta', '.txt'}
# Order matters: the longest/most specific rules first.
RULES = [
    ('nadiendev.rusticrevived', 'com.skd.cottagecraft'),
    ('nadiendev/rusticrevived', 'com/skd/cottagecraft'),
    ('RusticRevived', 'Cottagecraft'),
    ('Rustic Revived', 'Cottagecraft'),
    ('rusticrevived', 'cottagecraft'),
]
SKIP_DIRS = {'.git', '.gradle', 'build', 'run'}


def rename_path(rel):
    rel = rel.replace('\\', '/')
    for old, new in RULES:
        rel = rel.replace(old, new)
    return rel


def convert_text(text):
    for old, new in RULES:
        text = text.replace(old, new)
    return text


def main(src, dst):
    count = {'text': 0, 'binary': 0}
    for root, dirs, files in os.walk(src):
        dirs[:] = [d for d in dirs if d not in SKIP_DIRS]
        for name in files:
            full = os.path.join(root, name)
            rel = os.path.relpath(full, src)
            if rel == 'LICENSE':  # the fork keeps its own LICENSE with all copyright lines
                continue
            out = os.path.join(dst, rename_path(rel))
            os.makedirs(os.path.dirname(out), exist_ok=True)
            if os.path.splitext(name)[1].lower() in TEXT_EXT or name in ('gradlew',):
                raw = open(full, 'rb').read()
                text = convert_text(raw.decode('utf-8'))
                open(out, 'wb').write(text.encode('utf-8'))
                count['text'] += 1
            else:
                open(out, 'wb').write(open(full, 'rb').read())
                count['binary'] += 1
    print(count)


if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2])
