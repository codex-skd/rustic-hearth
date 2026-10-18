# Flujo de trabajo — Rustic Hearth (NeoForge)

> **Versión del workflow**: 1.21.0 (codex-docs)
> Este archivo pertenece al proyecto **Rustic Hearth**. Cambios aquí solo afectan a este proyecto.
> **Trabaja directamente con este archivo**: es el workflow operativo del mod, autocontenido. No leas `codex-docs/WORKFLOW_AGENT.md` ni `WORKFLOW_GENERIC.md` de forma rutinaria.
> On-demand: `codex-docs/reference/CURSEFORGE.md`, `codex-docs/reference/GRAPHIFY.md`.

## Específico del mod

| Campo | Valor |
|---|---|
| **Mod ID** | `rustic_hearth` |
| **Clase principal** | `com.skd.rustichearth.RusticHearth` |
| **Display name** | `Rustic Hearth` |
| **Versión Minecraft** | `1.21.1` |
| **Versión NeoForge** | `21.1.259` (no subir sin pedirlo) |
| **Rama de trabajo** | `minecraft/1.21.1/neoforge-21.1.259/production` |
| **Repositorio GitLab** | `https://gitlab.com/stalking-dragons/minecraft/rustic-hearth.git` |
| **Paquete base** | `com.skd.rustichearth` |
| **Licencia** | **MIT** (fork de Rustic Revived, que porta Rustic). Verificar texturas/modelos del original antes de publicar |
| **CurseForge project id** | `1747262` |

## Qué es

Fork de **Rustic Revived** (NadienDev, MIT, NeoForge 1.21.1), a su vez port de **Rustic** 1.12.2: decoración, agricultura, elaboración de bebidas y alquimia de estilo rural-medieval. Fuente de partida en `temp/original/` (Revived) y `temp/original_rustic_1.12.2/` (original), gitignored y solo lectura. Plan en `docs/PLAN_PORT.md` (fases R0-R3 hechas; R4 = prueba en cliente a cargo del usuario, R5 = publicación), trazabilidad en `docs/UPSTREAM.md`, tabla de ids para el conversor de plantillas AW2 en `docs/IDS_RUSTIC_HEARTH.md` (se comprueba con `python docs/tools/check_template_ids.py`), guía de prueba en `docs/PRUEBA_CLIENTE.md`. Carpeta local `G:\Proyectos\Mods_Minecraft\rustic_hearth\neoforge\1.21.1`. Rustic es el primer punto del bloque 2 de `warhost/docs/PLAN_DE_RUTA.md`.

## Restricciones activas (viajan con cualquier delegación a OpenCode)

- **Nunca subir versiones** de dependencias, mods ni NeoForge.
- **Nunca borrar ficheros** sin que se pida; `temp/` no se toca. **Excepción pedida por el plan:** en la fase R2 se quitan integraciones opcionales (CraftTweaker, KubeJS, Dynamic Trees, InvTweaks) — solo con confirmación expresa del usuario para esa fase.
- OpenCode no hace `git commit/push` ni sube nada a CurseForge. **Nunca usar `cd` ni rutas fuera del proyecto en los prompts a OpenCode**: copiar las referencias dentro de `temp/`; prohibirle inspeccionar jars de `libs/` y `/tmp`; si le rechazan una llamada se rinde.
- **Obligaciones MIT**: conservar los avisos de copyright de Rustic, Rustic Revived y los nuestros en `LICENSE`/`NOTICE`; no implicar respaldo de los autores originales.
- Sin residuos del origen: paquete `nadiendev.rusticrevived`, namespace `rusticrevived`, mod id `rustic`.

## Convenciones, ramas, versionado, commits

Las del grupo (`WORKFLOW_GENERIC`): snake_case `rustic_hearth`, clase `RusticHearth`, Title Case `Rustic Hearth`. Rama única `production`. Versión `0.0.0-beta.X`; JAR `rustic_hearth-1.21.1-neoforge-21.1.259-<version>.jar`. Commits en inglés con `v<version>`. Sin tags.

## Flujo por tarea

1. Desarrollo → `./gradlew.bat build` → commit → push.
2. Verificar con `runServer` puro (debe verse `Rustic Hearth 0.0.0-beta.1 (rustic_hearth)` y `Done`); parar los daemons de Gradle al terminar (`./gradlew.bat --stop`) y matar solo los java del proyecto (`fml.modFolders=rustic_hearth` en la línea de comandos).
3. Render y jugabilidad: solo en cliente (a cargo del usuario).
4. CurseForge solo con confirmación expresa.
5. Graphify tras cada push cuando haya código (`graphify update .`; el `extract` con Ollama `qwen2.5-coder:7b` falla con docs y JSON, no usarlo).
6. `datagen`: `./gradlew.bat runData` regenera `src/generated/resources/`; 31 recetas de `recipe/condenser/**` cambian de orden en cada ejecución (ruido de NeoForge en `neoforge:cures`), no son un cambio real.

## Idioma

Código, logs, commits, README y CurseForge en inglés. docs/ y CHANGELOG en castellano.
