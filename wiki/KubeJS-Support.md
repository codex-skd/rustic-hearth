Rustic Hearth includes [KubeJS](https://www.curseforge.com/minecraft/mc-mods/kubejs) integration (1.21.1 and 26.1.2) so that modpack makers can add and remove recipes for its custom crafting systems. All recipes go in a `server_scripts` file inside the `ServerEvents.recipes` event.

The recipe types are `rustic_hearth:crushing_tub`, `rustic_hearth:evaporating_basin`, `rustic_hearth:condenser` and `rustic_hearth:brewing`. Arguments are given in the order shown below; optional arguments can be left out or set with the method of the same name.

***

## Crushing Tub ##
`event.recipes.rustic_hearth.crushing_tub(result, ingredient, byproduct?)`
+ `result`: the fluid produced
+ `ingredient`: the item crushed
+ `byproduct` (optional): an item dropped above the tub

```js
ServerEvents.recipes(event => {
  event.recipes.rustic_hearth.crushing_tub(Fluid.of('minecraft:water', 125), 'minecraft:melon_slice')
  event.recipes.rustic_hearth.crushing_tub(Fluid.of('minecraft:water', 250), 'minecraft:pumpkin', 'minecraft:pumpkin_seeds')
})
```

## Evaporating Basin ##
`event.recipes.rustic_hearth.evaporating_basin(result, fluid, time?)`
+ `result`: the item produced
+ `fluid`: the fluid and amount evaporated
+ `time` (optional): ticks the recipe takes; if left out it takes one tick per mB

```js
ServerEvents.recipes(event => {
  event.recipes.rustic_hearth.evaporating_basin('minecraft:sugar', Fluid.of('rustic_hearth:olive_oil', 750))
  event.recipes.rustic_hearth.evaporating_basin('minecraft:clay_ball', Fluid.of('minecraft:water', 1000)).time(400)
})
```

## Condenser (Alchemy) ##
`event.recipes.rustic_hearth.condenser(result, ingredients, modifier?, bottle?, fluid?, time?, advanced?)`
+ `result`: the item produced, usually an elixir
+ `ingredients`: a list of 1 to 3 ingredients
+ `modifier` (optional): the modifier ingredient; recipes with a modifier or 3 ingredients need the advanced condenser
+ `bottle` (optional): defaults to a glass bottle
+ `fluid` (optional): defaults to 125 mB of water
+ `time` (optional): ticks the recipe takes, defaults to 400 (simple) or 300 (advanced)
+ `advanced` (optional): `true` forces the recipe to need the advanced condenser

Elixirs store their effects in the vanilla `minecraft:potion_contents` component:
```js
ServerEvents.recipes(event => {
  const slowness = Item.of('rustic_hearth:elixir', '[potion_contents={custom_effects:[{id:"minecraft:slowness",duration:1800}]}]')
  const longSlowness = Item.of('rustic_hearth:elixir', '[potion_contents={custom_effects:[{id:"minecraft:slowness",duration:4800}]}]')

  event.recipes.rustic_hearth.condenser(slowness, ['minecraft:cobweb', 'minecraft:vine'])
  event.recipes.rustic_hearth.condenser(longSlowness, ['minecraft:cobweb', 'minecraft:vine'], 'rustic_hearth:horsetail')
  event.recipes.rustic_hearth.condenser(slowness, ['minecraft:cobweb', 'minecraft:vine']).advanced(true).time(600)
})
```

## Brewing Barrel ##
`event.recipes.rustic_hearth.brewing(result, input, quality?)`
+ `result`: the booze produced (the amount is ignored, the barrel converts the input 1 mB at a time)
+ `input`: the fluid brewed
+ `quality` (optional): `'standard'` (random quality between 5% and 75%) or `'ambrosia'` (between 49% and 74%, cultures never lower the quality)

```js
ServerEvents.recipes(event => {
  event.recipes.rustic_hearth.brewing(Fluid.of('rustic_hearth:mead', 1000), 'rustic_hearth:wildberry_juice')
  event.recipes.rustic_hearth.brewing(Fluid.of('rustic_hearth:mead', 1000), 'rustic_hearth:golden_apple_juice', 'ambrosia')
})
```

## Removing Recipes ##
Every built-in recipe has an id like `rustic_hearth:<type>/<name>` (for example `rustic_hearth:crushing_tub/grapes` or `rustic_hearth:brewing/wine`). They are all listed in JEI with advanced tooltips enabled (F3 + H).
```js
ServerEvents.recipes(event => {
  event.remove({ id: 'rustic_hearth:brewing/wine' })
  event.remove({ type: 'rustic_hearth:crushing_tub', input: 'minecraft:apple' })
  event.remove({ type: 'rustic_hearth:condenser', output: 'rustic_hearth:elixir' })
})
```
