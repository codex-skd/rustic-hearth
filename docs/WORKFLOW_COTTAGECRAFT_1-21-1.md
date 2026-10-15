# Flujo de trabajo — Cottagecraft (NeoForge)

> **Versión del workflow**: 1.21.0 (codex-docs)
> Este archivo pertenece al proyecto **Cottagecraft**. Cambios aquí solo afectan a este proyecto.
> **Trabaja directamente con este archivo**: es el workflow operativo del mod, autocontenido. No leas `codex-docs/WORKFLOW_AGENT.md` ni `WORKFLOW_GENERIC.md` de forma rutinaria.
> On-demand: `codex-docs/reference/CURSEFORGE.md`, `codex-docs/reference/GRAPHIFY.md`.

## Específico del mod

| Campo | Valor |
|---|---|
| **Mod ID** | `cottagecraft` |
| **Clase principal** | `com.skd.cottagecraft.Cottagecraft` |
| **Display name** | `Cottagecraft` |
| **Versión Minecraft** | `1.21.1` |
| **Versión NeoForge** | `21.1.249` (no subir sin pedirlo) |
| **Rama de trabajo** | `minecraft/1.21.1/neoforge-21.1.249/production` |
| **Repositorio GitLab** | `https://gitlab.com/stalking-dragons/minecraft/cottagecraft.git` |
| **Paquete base** | `com.skd.cottagecraft` |
| **Licencia** | **MIT** (fork de Rustic Revived, que porta Rustic). Verificar texturas/modelos del original antes de publicar |
| **CurseForge project id** | pendiente |

## Qué es

Fork de **Rustic Revived** (NadienDev, MIT, NeoForge 1.21.1), a su vez port de **Rustic** 1.12.2: decoración, agricultura, elaboración de bebidas y alquimia de estilo rural-medieval. Fuente de partida en `temp/original/` (Revived) y `temp/original_rustic_1.12.2/` (original), gitignored y solo lectura. Plan en `docs/PLAN_PORT.md`, trazabilidad en `docs/UPSTREAM.md`. Rustic es el primer punto del bloque 2 de `warhost/docs/PLAN_DE_RUTA.md`.

## Restricciones activas (viajan con cualquier delegación a OpenCode)

- **Nunca subir versiones** de dependencias, mods ni NeoForge.
- **Nunca borrar ficheros** sin que se pida; `temp/` no se toca. **Excepción pedida por el plan:** en la fase R2 se quitan integraciones opcionales (CraftTweaker, KubeJS, Dynamic Trees, InvTweaks) — solo con confirmación expresa del usuario para esa fase.
- OpenCode no hace `git commit/push` ni sube nada a CurseForge. **Nunca usar `cd` ni rutas fuera del proyecto en los prompts a OpenCode**: copiar las referencias dentro de `temp/`; prohibirle inspeccionar jars de `libs/` y `/tmp`; si le rechazan una llamada se rinde.
- **Obligaciones MIT**: conservar los avisos de copyright de Rustic, Rustic Revived y los nuestros en `LICENSE`/`NOTICE`; no implicar respaldo de los autores originales.
- Sin residuos del origen: paquete `nadiendev.rusticrevived`, namespace `rusticrevived`, mod id `rustic`.

## Convenciones, ramas, versionado, commits

Las del grupo (`WORKFLOW_GENERIC`): snake_case `cottagecraft`, clase `Cottagecraft`, Title Case `Cottagecraft`. Rama única `production`. Versión `0.0.0-beta.X`; JAR `cottagecraft-1.21.1-neoforge-21.1.249-<version>.jar`. Commits en inglés con `v<version>`. Sin tags.

## Flujo por tarea

1. Desarrollo → `./gradlew.bat build` → commit → push.
2. Verificar con `runServer` puro; parar los daemons de Gradle al terminar (`./gradlew.bat --stop`) y matar solo los java del proyecto (`fml.modFolders=cottagecraft` en la línea de comandos).
3. Render y jugabilidad: solo en cliente (a cargo del usuario).
4. CurseForge solo con confirmación expresa.
5. Graphify tras cada push cuando haya código (`graphify update .`).

## Idioma

Código, logs, commits, README y CurseForge en inglés. docs/ y CHANGELOG en castellano.
