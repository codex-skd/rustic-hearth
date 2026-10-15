# CurseForge — Variables del proyecto

> Leídas por `codex-docs/scripts/curseforge-upload.ps1`. IDs verificados con la API: 9638 Client, 9639 Server, 11779 1.21.1, 10150 NeoForge. **No se guarda el token en este fichero**: la subida se hace con curl leyendo `codex-docs/secrets.md`.

project_id = 1747262
game_versions = 9638, 9639, 11779, 10150
release_type = beta
relations = jei:optionalDependency, quark:optionalDependency

## Proyecto

| Variable | Valor |
|----------|-------|
| `mod_id` | `rustic_hearth` |
| `display_name` | `Rustic Hearth` |
| `slug esperado` | `rustic-hearth` (la API de búsqueda no devuelve nada parecido a «Rustic Hearth», 2026-10-16; **la API no vio el proyecto «Cottagecraft» que el usuario dice que ya existía, así que la web es la que manda**) |
| `classId` | `6` (Mods) |
| `category` | Farming (principal). Secundarias, como Rustic y Rustic Revived: Cosmetic, Food, Storage. Verificar los nombres exactos del desplegable |
| `license` | MIT |
| `source_url` | `https://gitlab.com/stalking-dragons/minecraft/rustic-hearth` |

### Summary (campo *Summary*, editable en la web; límite 200)

```
Cozy rural decoration, farming, brewing and alchemy: barrels, vineyards, beehives, herbs, elixirs and furniture. A NeoForge 1.21.1 fork of Rustic Revived.
```

(152 caracteres.)

### Alternativas de summary

- `A rustic cottage-core mod: furniture, vineyards, olive groves, bees, brewing barrels and an alchemy lab with herbs and elixirs. Fork of Rustic Revived for NeoForge 1.21.1.`
- `Decorate and farm in a medieval countryside style, brew booze and craft elixirs from herbs. Unofficial NeoForge 1.21.1 fork of Rustic Revived (Rustic).`

### Dependencias opcionales

JEI (slug `jei`, ID 238222) y Quark (slug `quark`, ID 243121), ambos verificados con la API. **Ninguna es requerida.**

### Pendiente antes de subir

- Proyecto creado en CurseForge (ID 1747262).
- **Licencia del origen**: el repo de Rustic (cadaverous-eris) no trae `LICENSE` en GitHub; MIT según la ficha 256141 (confirmado por el usuario). Verificar también que **texturas y modelos** caen bajo esa licencia antes de publicar.
- **Avisar** (cortesía) a NadienDev, autor de Rustic Revived.
- **Wiki del repo** (`wiki/`): viene de Revived y la portada dice «Rustic Hearth is an unofficial port of Rustic…» y habla de id `rustic` — está sin corregir; no enlazarla desde CurseForge hasta revisarla.
- Logo: generar con `logo_prompt.md`; derivar `logo_400.png` (solo local) e `icon.png` 64×64 en la **raíz** de `src/main/resources`, con `logoFile="icon.png"` en `neoforge.mods.toml` (ahora el toml usa `logo.png`, comprobar cuál es el definitivo).
- **Rewards**: al ser MIT, el proyecto sí podría inscribirse en el programa de recompensas de CurseForge (decisión del usuario; no lo hago yo).
- Descripción y release notes son **borrador**: revisar tras R3/R4 (ids confirmados y prueba en cliente).
- Fase R4 (prueba en cliente) pendiente: no publicar antes sin avisar de que es beta sin jugar.
