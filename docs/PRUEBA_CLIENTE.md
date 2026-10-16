# Guía de prueba en cliente — Rustic Hearth 0.0.0-beta.1

Nada de esto se ha visto en pantalla todavía. Marca cada punto y anota el fallo exacto (texto del log o captura) si algo no va. Mundo nuevo en **creativo**, con este mod en `mods/` (JEI y Quark opcionales).

## Arranque

- [ ] El log de `run/logs/latest.log` muestra `Rustic Hearth 0.0.0-beta.1 (rustic_hearth)` sin `ERROR` de `rustic_hearth`.
- [ ] Pestañas creativas: bloques decorativos, ingredientes y herramientas aparecen con su textura (nada morado/negro de «textura que falta»).
- [ ] El icono del mod (barril, silla, botella y colmena) se ve en la lista de mods.

## Decoración y almacenaje

- [ ] Sillas y mesas de varias maderas (roble, ironwood, olivo): se colocan, se ven y se puede sentar/usar la silla.
- [ ] Armarios, tarros y jarrones: abren y guardan ítems; el armario doble se junta.
- [ ] Velas, candelabros y linternas de hierro: dan luz; la vela se enciende y apaga.
- [ ] Pizarra, pilares, paredes de arcilla, madera pintada, celosía de hierro, cuerdas, cadenas y gárgolas: bloques, escaleras y losas.

## Agricultura

- [ ] Uvas, aceitunas, tomates, chiles, bayas: se plantan, crecen y se cosechan (palos de cultivo y tierra fértil).
- [ ] Manzano, olivo y ironwood: árbol completo con hojas y brotes.
- [ ] Apiario con abejas: producen miel/panal/cera.
- [ ] Hierbas (aloe, camomila, ginseng, cardo del viento...): se recolectan.

## Elaboración y alquimia

- [ ] Barril y barril de elaboración: fermentan zumo y aceite; el barril líquido guarda fluidos; el grifo funciona.
- [ ] Cuba de aplastado, cuenco de evaporación, condensador y alambique avanzado: producen elixires.
- [ ] Beber un elixir da su efecto; el efecto **iron_skin** y el **feather** funcionan.
- [ ] El **Almanaque** abre y sus páginas se leen.

## Compatibilidad

- [ ] Con **JEI**: aparecen las categorías de recetas de las máquinas. Sin JEI: el juego arranca igual.
- [ ] Con **Quark**: la pantalla de almacenaje se integra. Sin Quark: arranca igual.

## Si algo falla

Manda la acción exacta, el mensaje del log (`run/logs/latest.log`) y, si es visual, una captura. Fallos esperables: texturas o modelos de bloques con estados (sillas, mesas, cultivos), renderers de las máquinas (condensador, cuba), almanaque y efectos de los elixires.
