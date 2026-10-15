# Rustic Hearth — Logo de CurseForge

> Prompt para generar el avatar del proyecto en CurseForge (400×400). Misma familia visual que los logos del ecosistema: fondo violeta con nebulosa, marco dorado, pixel-art y un único color de acento por mod (aquí, **rojo vino / borgoña**, distinto del verde té de Steeped, el turquesa de Enchanter's Bench, el naranja brasa de Mobweave Core, el verde lima de Primitive Menagerie y el magenta de Soulbound Summoner).

## Prompt

```
Pixel-art mod icon for a Minecraft NeoForge mod called "Rustic Hearth". 400x400 square, perfectly centered.

SUBJECT: a cosy rustic still life on a small wooden cottage table: a plump oak barrel with iron bands and a tap
in the center, a wooden chair with a round woven cushion to its left, and on the table a glass bottle of deep wine-red
liquid, a bunch of purple grapes on the vine, an olive sprig, a small clay pot with a herb sprouting, and a lit candle in
an iron holder. A small striped beehive sits at the back right with two tiny bees flying around it. Warm candlelight
and a few drifting wine-red sparkles tie everything together.

COMPOSITION: the barrel is the strong central silhouette; the chair, bottle, grapes and pot form a balanced cluster
around it, all readable as simple shapes. They rest on a small rounded patch of grass and cobblestone so nothing
floats except the bees and the sparkles. Slightly raised three-quarter view, like an isometric Minecraft block scene.

FRAME: an ornate golden border with filigree corners, echoing a gilded frame. A few small warm sparkles and
four-pointed star glints drift around the scene.

BACKGROUND: deep near-black violet with a soft purple nebula, darker at the corners so the gold frame, the objects
and the wine-red accents all read clearly.

PALETTE: gold #d4af6a for the frame and iron details, wine red / burgundy #a8324a through #6e1630 for the bottle,
grapes, cushion and sparkles, warm oak #8a5a2b and #b98a55 for the barrel and wood, cream #f1e3c6 for the candle,
olive green #7a8a3a, violet #2a1a3e for the background. One accent colour only: wine red.

STYLE: crisp pixel art, large readable pixels, limited palette, strong contrast, 16-bit and 32-bit pixel art
feel. Readable at 64x64 - silhouette first, detail second.

AVOID: photorealism, 3D render, smooth gradients, anti-aliasing, thin hairlines, text, letters, UI elements,
people, orange, turquoise, tea-green, lime or magenta accents, cluttered background.
```

## Por qué cada elemento está pedido

| Elemento | Razón |
|---|---|
| Barril de roble | Es el bloque más usado del mod (barriles y barriles de elaboración) y de las plantillas de AW2 |
| Silla, mesa, tarro, vela | Decoración: el gancho de «cottage» |
| Uvas, aceituna, hierba | Agricultura: las cosechas del mod |
| Botella de vino y colmena | Bebidas y abejas |
| Rojo vino como único acento | Regla de la familia (un acento por mod); distinto de los demás logos |
| Marco dorado + nebulosa violeta | Anclan el logo a la familia de logos publicados |
| "Readable at 64x64" | CurseForge muestra el avatar en tarjetas de ~100 px |

## Después de generarla

1. Comprobar que es 400×400 y que se lee a 100 px (el barril y la botella reconocibles).
2. Subirla como avatar del proyecto en CurseForge.
3. Opcionalmente subirla a `node-files.skdragons.com/uploads/MINECRAFT/Codex/`.
4. No versionarla en el repo (el `.gitignore` excluye `docs/curseforge/logo_*.png`).
5. Para el icono dentro del juego (`icon.png` 64×64 en la **raíz** de `src/main/resources`, y `logoFile="icon.png"` en `neoforge.mods.toml`), derivar una versión sin marco, como en Soulbound Summoner.
