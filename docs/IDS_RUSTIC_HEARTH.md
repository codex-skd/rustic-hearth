# Tabla de ids para el convertidor de plantillas de Ancient Warfare 2

Esta tabla mapea los **66 ids `rustic:*`** que aparecen en las plantillas `.aws` de
Ancient Warfare 2 (1.12.2) al registro real de **Rustic Hearth** (NeoForge 1.21.1,
namespace `rustic_hearth`). Es la referencia de la que debe tirar el futuro convertidor
de plantillas.

Los datos de partida están en `temp/aw2_rustic_ids.json` (lista de
`{id, count, templates, contexts, samples}`). El script
`docs/tools/check_template_ids.py` verifica toda la tabla automáticamente y falla con
código de salida distinto de cero si algún id queda `UNRESOLVED`.

## Cómo se lee la tabla

- **`tipo`**:
  - `bloque`: el id solo aparece en el contexto `name` (paleta de bloques de la plantilla).
  - `bloque/ítem`: aparece tanto en `name` como en `item_id`.
  - `ítem`: solo aparece en `item_id` (stacks dentro de NBT de cofres, comercios,
    inventarios de NPC, etc.).
  - `efecto`: potion effect en NBT `ElixirEffects` de un elixir (`other`).
  - `tile entity`: nombre de tile entity de 1.12, sin equivalente en el registro nuevo.
- **`usos`**: el `count` de `temp/aw2_rustic_ids.json` (número total de apariciones).
- Los ids que solo aparecen como **stack de ítem** (`item_id`, con `Count`/`Damage`) los
  trata el convertidor de forma distinta a los que van en la **paleta de bloques**
  (`name`, con `blockName`/`properties`). Se indica en la columna `notas`.
- **Contextos**: `name` = paleta de la plantilla; `item_id` = stack `id:"..."`; `other`
  = `Effect:"rustic:..."` dentro de NBT de elixir.

Resumen: **51 `EXACT`**, **10 `MAPPED`**, **5 `DROP`**, **0 `UNRESOLVED`**.

---

## Efectos (poción)

| id 1.12 | tipo | id nuevo | usos | notas |
|---|---|---|---|---|
| `rustic:ironskin` | efecto | `rustic_hearth:iron_skin` | 7 | **MAPPED**. En 1.12 se registra como `rustic:ironskin` (`PotionsRustic.java:9`); el nuevo efecto es `iron_skin` (`ModEffects.java:20`). |
| `rustic:feather` | efecto | `rustic_hearth:feather` | 2 | `EXACT`. Mismo nombre (`ModEffects.java:21`). |

Ambos aparecen únicamente como `Effect:"rustic:..."` dentro del NBT `ElixirEffects`
(véase la sección del elixir más abajo).

---

## Bloques (solo paleta / contexto `name`)

| id 1.12 | tipo | id nuevo | usos | notas |
|---|---|---|---|---|
| `rustic:gargoyle` | bloque | `rustic_hearth:gargoyle` | 41 | |
| `rustic:grape_leaves` | bloque | `rustic_hearth:grape_leaves` | 18 | |
| `rustic:chair_birch` | bloque | `rustic_hearth:chair_birch` | 15 | |
| `rustic:apiary` | bloque | `rustic_hearth:apiary` | 8 | |
| `rustic:rope` | bloque | `rustic_hearth:rope` | 7 | |
| `rustic:tomato_crop` | bloque | `rustic_hearth:tomato_crop` | 4 | |
| `rustic:chili_crop` | bloque | `rustic_hearth:chili_crop` | 4 | |
| `rustic:table_birch` | bloque | `rustic_hearth:table_birch` | 4 | |
| `rustic:beehive` | bloque | `rustic_hearth:beehive` | 2 | |
| `rustic:candle` | bloque | `rustic_hearth:candle` | 2 | |
| `rustic:cabinet` | bloque | `rustic_hearth:cabinet` | 2 | |
| `rustic:iron_lantern` | bloque | `rustic_hearth:iron_lantern` | 2 | |
| `rustic:mooncap_mushroom` | bloque | `rustic_hearth:mooncap_mushroom` | 2 | |
| `rustic:stone_pillar` | bloque | `rustic_hearth:stone_pillar` | 1 | |
| `rustic:chandelier` | bloque | `rustic_hearth:chandelier` | 1 | |
| `rustic:candle_gold` | bloque | `rustic_hearth:candle_gold` | 1 | |
| `rustic:leaves_apple` | bloque | `rustic_hearth:apple_leaves` | 24 | **MAPPED**. El nuevo bloque se llama `apple_leaves`. |
| `rustic:leaves` | bloque | `rustic_hearth:olive_leaves` / `ironwood_leaves` | 6 | **MAPPED**. Bloque con metadatos; ver variantes. |
| `rustic:chair_big_oak` | bloque | `rustic_hearth:chair_dark_oak` | 2 | **MAPPED**. `big_oak` es el nombre antiguo de `dark_oak`. |
| `rustic:table_big_oak` | bloque | `rustic_hearth:table_dark_oak` | 1 | **MAPPED**. Igual que el anterior. |

---

## Bloques e ítems (contextos `name` + `item_id`)

| id 1.12 | tipo | id nuevo | usos | notas |
|---|---|---|---|---|
| `rustic:brewing_barrel` | bloque/ítem | `rustic_hearth:brewing_barrel` | 91 | |
| `rustic:barrel` | bloque/ítem | `rustic_hearth:barrel` | 78 | |
| `rustic:grape_stem` | bloque/ítem | `rustic_hearth:grape_stem` | 36 | |
| `rustic:liquid_barrel` | bloque/ítem | `rustic_hearth:liquid_barrel` | 34 | |
| `rustic:deathstalk_mushroom` | bloque/ítem | `rustic_hearth:deathstalk_mushroom` | 34 | |
| `rustic:aloe_vera` | bloque/ítem | `rustic_hearth:aloe_vera` | 28 | |
| `rustic:table_spruce` | bloque/ítem | `rustic_hearth:table_spruce` | 23 | |
| `rustic:vase` | bloque/ítem | `rustic_hearth:vase` | 20 | En 1.12 la paleta usa `properties:{variant:"0"}`; el `vase` nuevo no tiene variantes, se ignora la propiedad. |
| `rustic:slate` | bloque/ítem | `rustic_hearth:slate` | 8 | |
| `rustic:chain` | bloque/ítem | `rustic_hearth:chain` | 2 | |
| `rustic:log` | bloque/ítem | `rustic_hearth:olive_log` / `ironwood_log` | 19 | **MAPPED**. Bloque con metadatos; ver variantes. |
| `rustic:planks` | bloque/ítem | `rustic_hearth:olive_planks` / `ironwood_planks` | 4 | **MAPPED**. Bloque con metadatos; ver variantes. |

---

## Ítems (solo contexto `item_id`, stacks en NBT)

| id 1.12 | tipo | id nuevo | usos | notas |
|---|---|---|---|---|
| `rustic:fluid_bottle` | ítem | `rustic_hearth:fluid_bottle` | 310 | Stack con NBT `Fluid:{FluidName:...}` (el formato de fluido cambia a componentes; ver "Pendiente"). |
| `rustic:elixir` | ítem | `rustic_hearth:elixir` | 27 | Stack con NBT `ElixirEffects` (ver "Efectos de elixir"). |
| `rustic:grapes` | ítem | `rustic_hearth:grapes` | 21 | |
| `rustic:bee` | ítem | `rustic_hearth:bee` | 17 | |
| `rustic:olives` | ítem | `rustic_hearth:olives` | 14 | |
| `rustic:ironberries` | ítem | `rustic_hearth:ironberries` | 12 | |
| `rustic:apple_seeds` | ítem | `rustic_hearth:apple_seeds` | 9 | |
| `rustic:honeycomb` | ítem | `rustic_hearth:honeycomb` | 9 | |
| `rustic:blood_orchid` | ítem | `rustic_hearth:blood_orchid` | 8 | |
| `rustic:chili_pepper_seeds` | ítem | `rustic_hearth:chili_pepper_seeds` | 5 | |
| `rustic:tomato_seeds` | ítem | `rustic_hearth:tomato_seeds` | 4 | |
| `rustic:tomato` | ítem | `rustic_hearth:tomato` | 3 | |
| `rustic:chamomile` | ítem | `rustic_hearth:chamomile` | 3 | |
| `rustic:cohosh` | ítem | `rustic_hearth:cohosh` | 3 | |
| `rustic:cloudsbluff` | ítem | `rustic_hearth:cloudsbluff` | 3 | |
| `rustic:wind_thistle` | ítem | `rustic_hearth:wind_thistle` | 3 | |
| `rustic:ginseng` | ítem | `rustic_hearth:ginseng` | 2 | |
| `rustic:wildberries` | ítem | `rustic_hearth:wildberries` | 2 | |
| `rustic:chain_gold` | ítem | `rustic_hearth:chain_gold` | 1 | |
| `rustic:beeswax` | ítem | `rustic_hearth:beeswax` | 1 | |
| `rustic:wildberry_bush` | ítem | `rustic_hearth:wildberry_bush` | 1 | |
| `rustic:table_oak` | ítem | `rustic_hearth:table_oak` | 1 | |
| `rustic:chair_oak` | ítem | `rustic_hearth:chair_oak` | 1 | |
| `rustic:chair_spruce` | ítem | `rustic_hearth:chair_spruce` | 1 | |
| `rustic:sapling_apple` | ítem | `rustic_hearth:apple_sapling` | 3 | **MAPPED**. El nuevo ítem/bloque es `apple_sapling`. |
| `rustic:sapling` | ítem | `rustic_hearth:olive_sapling` / `ironwood_sapling` | 1 | **MAPPED**. Metadatos; ver variantes. |
| `rustic:book` | ítem | `rustic_hearth:almanac` | 1 | **MAPPED**. El ítem almanac de 1.12 se registraba como `book` (`ItemBook.java:16`). |

---

## Tile entities (descartar)

Estos ids son **nombres de tile entity** de 1.12 que aparecen dentro de NBT
(`id:"rustic:tileentity..."`). No son bloques ni ítems y no tienen equivalente en el
registro: el convertidor debe **eliminarlos / ignorarlos**.

| id 1.12 | tipo | id nuevo | usos | notas |
|---|---|---|---|---|
| `rustic:tileentitybrewingbarrel` | tile entity | — (descartar) | 90 | NBT de tile entity. |
| `rustic:tileentityvase` | tile entity | — (descartar) | 17 | NBT de tile entity. |
| `rustic:tileentityliquidbarrel` | tile entity | — (descartar) | 3 | NBT de tile entity. |
| `rustic:tileentitycabinet` | tile entity | — (descartar) | 2 | NBT de tile entity. |
| `rustic:tileentitybarrel` | tile entity | — (descartar) | 1 | NBT de tile entity. |

> Nota: el usuario indicó "6 nombres `tileentity*`", pero en
> `temp/aw2_rustic_ids.json` solo hay **5**. El script confirma 5. El recuento real es
> 51 `EXACT` + 10 `MAPPED` + 5 `DROP` = 66.

---

## Variantes por metadatos (`Damage`)

En 1.12 los bloques `log`, `planks`, `leaves` y `sapling` comparten un único id con
variantes por `Damage`. El enum de variantes es `BlockPlanksRustic.EnumType`:

| valor | nombre | `Damage` |
|---|---|---|
| `OLIVE` | `olive` | 0 |
| `IRONWOOD` | `ironwood` | 1 |

(`temp/original_rustic_1.12.2/.../BlockPlanksRustic.java`, enum `EnumType`.)

Mapeo por id:

| id 1.12 | bits de `Damage` | valor | id nuevo |
|---|---|---|---|
| `rustic:log` | `meta & 3` | 0 | `rustic_hearth:olive_log` |
| `rustic:log` | `meta & 3` | 1 | `rustic_hearth:ironwood_log` |
| `rustic:planks` | `meta` | 0 | `rustic_hearth:olive_planks` |
| `rustic:planks` | `meta` | 1 | `rustic_hearth:ironwood_planks` |
| `rustic:leaves` | `meta & 3` | 0 | `rustic_hearth:olive_leaves` |
| `rustic:leaves` | `meta & 3` | 1 | `rustic_hearth:ironwood_leaves` |
| `rustic:sapling` | `meta & 7` | 0 | `rustic_hearth:olive_sapling` |
| `rustic:sapling` | `meta & 7` | 1 | `rustic_hearth:ironwood_sapling` |

Bits extra (no afectan a la variante, son estado del bloque en 1.12):
`log`: `meta & 12` = eje (`0`=Y, `4`=X, `8`=Z, `12`=ninguno)`; `leaves`: `meta & 4`
= `decayable`, `meta & 8` = `check_decay`; `sapling`: `meta & 8` = `stage`.

En la **paleta de bloques** (contexto `name`) la variante no va en `Damage`, sino como
propiedad de estado, p. ej. `rustic:log` con `properties:{variant:"olive",axis:"y"}`
y `rustic:leaves` con `properties:{variant:"ironwood"}`. El convertidor debe leer la
propiedad `variant` y resolver a `olive_*`/`ironwood_*`; en los stacks `item_id` con
`Damage` debe usar la tabla de arriba.

### Chairs y tables

En 1.12.2 **no** hay metadatos: cada madera es un bloque propio registrado como
`chair_<madera>` / `table_<madera>` (`BlockChair`: `super(Material.WOOD, "chair_" + type)`,
`BlockTable`: `super(Material.WOOD, "table_" + type)`; registro en
`rustic/common/blocks/ModBlocks.java`). Por eso no hay tabla `Damage` para ellos; el
único cambio de nombre es `big_oak` → `dark_oak`:

| id 1.12 | id nuevo |
|---|---|
| `rustic:chair_big_oak` | `rustic_hearth:chair_dark_oak` |
| `rustic:table_big_oak` | `rustic_hearth:table_dark_oak` |

(Confirmado en el enum nuevo `WoodVariant.DARK_OAK("dark_oak", ...)` en
`src/main/java/com/skd/rustichearth/block/WoodVariant.java:21`.)

---

## Efectos de elixir (`ElixirEffects`)

Formato 1.12 (`rustic/common/util/ElixirUtils.java`, comentario del encabezado):

```
{ElixirEffects:[{Effect:"rustic:ironskin", Duration:<ticks>, Amplifier:<n>}]}
```

Formato nuevo: el elixir **ya no usa NBT**; guarda los efectos en el componente de
datos `minecraft:potion_contents` (`src/main/java/com/skd/rustichearth/item/ElixirItem.java`,
`withEffects`/`getContents`):

```java
stack.set(DataComponents.POTION_CONTENTS, new PotionContents(Optional.empty(), Optional.empty(), effects));
```

Por tanto, para cada entrada de `ElixirEffects` el convertidor debe emitir un efecto
`{id:"rustic_hearth:<effect>", duration:<ticks>, amplifier:<n>}` dentro de
`potion_contents.custom_effects` del stack `rustic_hearth:elixir`. Los ids de efecto
que aparecen en las plantillas son:

| `Effect` 1.12 | `id` nuevo |
|---|---|
| `rustic:ironskin` | `rustic_hearth:iron_skin` |
| `rustic:feather` | `rustic_hearth:feather` |

---

## Pendiente / no verificado

- El elixir se guarda ahora con el componente `potion_contents`; **no** se ha probado en
  juego el resultado serializado exacto (nombres de claves del NBT/SNBT final del
  componente). Se ha leído `ElixirItem.java` para deducir la estructura, pero no se ha
  ejecutado ni verificado contra un guardado real.
- `rustic:fluid_bottle` lleva en 1.12 NBT `Fluid:{FluidName:..., Amount:...}`. No se ha
  analizado en profundidad cómo el `fluid_bottle` nuevo (`FluidBottleItem`) empaqueta el
  fluido; habrá que comprobarlo antes de escribir el convertidor de ese ítem.
- Los 5 nombres de tile entity se descartan por nombre; no se ha revisado si el NBT de
  las plantillas (`teData`, inventarios) necesita transformaciones adicionales más allá
  de eliminar el `id`.
- No se ha comprobado si algún id de la lista pudiera necesitar traducción adicional de
  propiedades de estado (p. ej. `properties` de `vase`, `candle`, `barrel`) más allá de
  lo indicado.
