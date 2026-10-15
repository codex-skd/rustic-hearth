"""Renames the project in place from Cottagecraft to Rustic Hearth (text content, then files and directories).

Usage: python rename_to_rustic_hearth.py <project dir>

Rules (ordered): package `com.skd.cottagecraft` -> `com.skd.rustichearth`; class `Cottagecraft` -> `RusticHearth` in .java,
display name `Cottagecraft` -> `Rustic Hearth` in every other text file; repo path `/cottagecraft` -> `/rustic-hearth`;
every remaining `cottagecraft` (mod id, namespace, assets/data dirs, jar name, lang keys) -> `rustic_hearth`.
Skips temp/, build/, .gradle/, run/, run-data/, .git/, graphify-out/ and the historic script docs/tools/rename_from_revived.py.
Never deletes anything: files and directories are only renamed (os.rename keeps git history rename-detectable).
Original: Rustic Revived (MIT, NadienDev / Modern Mods); Rustic (MIT).
"""
import os, sys

TEXT_EXT = {'.java', '.json', '.toml', '.properties', '.gradle', '.md', '.mcmeta', '.txt', '.py', '.yml', '.yaml', '.cfg'}
SKIP_DIRS = {'temp', 'build', '.gradle', 'run', 'run-data', '.git', 'graphify-out', '.github'}
SKIP_FILES = {os.path.join('docs', 'tools', 'rename_from_revived.py'), os.path.join('docs', 'tools', 'rename_to_rustic_hearth.py')}


def convert_text(text, is_java):
    text = text.replace('com.skd.cottagecraft', 'com.skd.rustichearth').replace('com/skd/cottagecraft', 'com/skd/rustichearth')
    text = text.replace('Cottagecraft', 'RusticHearth' if is_java else 'Rustic Hearth')
    text = text.replace('COTTAGECRAFT', 'RUSTIC_HEARTH')
    text = text.replace('minecraft/cottagecraft', 'minecraft/rustic-hearth')
    text = text.replace("rootProject.name = 'cottagecraft'", "rootProject.name = 'rustic-hearth'")
    return text.replace('cottagecraft', 'rustic_hearth')


def new_name(name, in_package_dir):
    if in_package_dir and name == 'cottagecraft':
        return 'rustichearth'
    name = name.replace('Cottagecraft', 'RusticHearth').replace('COTTAGECRAFT', 'RUSTIC_HEARTH')
    return name.replace('cottagecraft', 'rustic_hearth')


def main(root):
    changed = 0
    for cur, dirs, files in os.walk(root):
        dirs[:] = [d for d in dirs if d not in SKIP_DIRS]
        for f in files:
            full = os.path.join(cur, f)
            rel = os.path.relpath(full, root)
            if rel in SKIP_FILES or os.path.splitext(f)[1].lower() not in TEXT_EXT:
                continue
            text = open(full, 'rb').read().decode('utf-8')
            out = convert_text(text, f.endswith('.java'))
            if out != text:
                open(full, 'wb').write(out.encode('utf-8'))
                changed += 1
    renamed = 0
    for cur, dirs, files in os.walk(root, topdown=False):
        parts = os.path.relpath(cur, root).split(os.sep)
        if any(p in SKIP_DIRS for p in parts):
            continue
        for name in files + dirs:
            if 'cottagecraft' not in name.lower():
                continue
            rel = os.path.relpath(os.path.join(cur, name), root)
            if rel in SKIP_FILES:
                continue
            in_pkg = cur.replace('\\', '/').endswith('/java/com/skd')
            os.rename(os.path.join(cur, name), os.path.join(cur, new_name(name, in_pkg)))
            renamed += 1
    print({'text files changed': changed, 'paths renamed': renamed})


if __name__ == '__main__':
    main(sys.argv[1])
