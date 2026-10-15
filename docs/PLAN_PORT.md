# Plan — Rustic Hearth (fork de Rustic Revived)

Copia operativa de `warhost/docs/PLAN_FORK_RUSTIC.md` con las decisiones tomadas. Ninguna fase se ejecuta sin confirmación explícita.

## Identidad (decidido 2026-10-15)

| Campo | Valor |
|---|---|
| Nombre | **Rustic Hearth** |
| Mod id / namespace | `rustic_hearth` (un único mod id; sin el segundo mod `rusticrevived`) |
| Clase principal | `com.skd.rustichearth.Rustic Hearth` |
| Paquete base | `com.skd.rustichearth` (sustituye a `nadiendev.rusticrevived`) |
| Repositorio | https://gitlab.com/stalking-dragons/minecraft/rustic-hearth.git |
| Rama | `minecraft/1.21.1/neoforge-21.1.249/production` |
| Versión inicial | `0.0.0-beta.1` |
| Licencia | MIT (ver `LICENSE`, `NOTICE`, `docs/UPSTREAM.md`) |

## Compat opcional (supuesto, reversible)

Se conservan **JEI y Quark**; se descartan CraftTweaker, KubeJS, Dynamic Trees e InvTweaks. *El usuario aún no ha confirmado este punto: se asumió la propuesta.*

## Fases

| Fase | Contenido | Hito verificable |
|---|---|---|
| R0 | Repo, licencias, instantáneas de origen, docs (esta fase) | Repo con `LICENSE`, `NOTICE`, `docs/` |
| R1 | **Renombrado** a `com.skd.rustichearth` y namespace `rustic_hearth` (código, assets, datos, tags, `trees`, `src/generated`), un solo mod id, NeoForge 21.1.249, cabeceras de licencia | `build` + `runServer` limpios; datagen regenera sin diferencias |
| R2 | **Recorte de compat**: quitar CraftTweaker, KubeJS, Dynamic Trees, InvTweaks; JEI y Quark opcionales | Arranca sin ninguno de los opcionales ✅ (hecho) |
| R3 | **Cotejo con AW2**: script que cruza los 67 ids de las plantillas con el registro real; tabla `docs/IDS_RUSTIC_HEARTH.md` (id 1.12 → id nuevo); añadir lo que falte | 0 ids sin resolver |
| R4 | **Estabilización**: prueba en cliente por el usuario y arreglos | Checklist `docs/PRUEBA_CLIENTE.md` pasada |
| R5 | Publicación: ficha de CurseForge (la crea el usuario), descripción, logo, notas, subida con confirmación | Fichero en CurseForge |

## Riesgos

- Revived no está probado por nosotros y casi no tiene uso (118 descargas): los fallos heredados pasan a ser nuestros.
- El renombrado afecta a ~1.214 ficheros generados + 493 modelos; `datagen` debería regenerarlos.
- Licencia de texturas/modelos del original sin comprobar (el repo de Rustic no trae `LICENSE`).
- Esfuerzo grande para el valor dentro de Warhost (166 plantillas de 1.484); se puede parar tras R3.
