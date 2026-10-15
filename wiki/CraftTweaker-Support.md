Rustic Hearth includes [CraftTweaker](https://www.curseforge.com/minecraft/mc-mods/crafttweaker) integration so that modpack makers can add and remove recipes for its custom crafting systems.
> CraftTweaker support is only available in the **1.21.1** version. For 26.1.2, use [KubeJS](KubeJS-Support.md) or a datapack.

Every manager is available both as `mods.rustic_hearth.<Name>` and as a recipe type (`<recipetype:rustic_hearth:...>`), so the standard CraftTweaker methods (`remove`, `removeByName`, `removeByModid`, `removeAll`...) also work. The methods that take a `name` create the recipe `crafttweaker:<name>`; the others generate a name automatically.

***

## Crushing Tub Recipes ##
`mods.rustic_hearth.CrushingTub` / `<recipetype:rustic_hearth:crushing_tub>`
```
// name, output fluid, input ingredient, optional item byproduct
mods.rustic_hearth.CrushingTub.addRecipe("melon_water", <fluid:minecraft:water> * 125, <item:minecraft:melon_slice>);
mods.rustic_hearth.CrushingTub.addRecipe("pumpkin_water", <fluid:minecraft:water> * 250, <item:minecraft:pumpkin>, <item:minecraft:pumpkin_seeds>);

// legacy order: output, byproduct (can be null), input
mods.rustic_hearth.CrushingTub.addRecipe(<fluid:minecraft:water> * 125, null, <item:minecraft:melon_slice>);
```
To remove recipes:
```
mods.rustic_hearth.CrushingTub.removeRecipe(<item:rustic_hearth:grapes>);                                 // by input
mods.rustic_hearth.CrushingTub.removeRecipe(<fluid:rustic_hearth:apple_juice>);                           // by output
mods.rustic_hearth.CrushingTub.removeRecipe(<fluid:rustic_hearth:apple_juice>, <item:minecraft:apple>);   // by output and input
```

## Evaporating Basin Recipes ##
`mods.rustic_hearth.EvaporatingBasin` / `<recipetype:rustic_hearth:evaporating_basin>`
```
// name, output item, input fluid, optional time in ticks (0 or left out = the fluid amount, minimum 20)
mods.rustic_hearth.EvaporatingBasin.addRecipe("salt", <item:minecraft:sugar>, <fluid:rustic_hearth:olive_oil> * 750);
mods.rustic_hearth.EvaporatingBasin.addRecipe("quick_salt", <item:minecraft:sugar>, <fluid:rustic_hearth:olive_oil> * 750, 200);

// without a name
mods.rustic_hearth.EvaporatingBasin.addRecipe(<item:minecraft:sugar>, <fluid:rustic_hearth:olive_oil> * 750);
```
To remove recipes:
```
mods.rustic_hearth.EvaporatingBasin.removeRecipe(<item:rustic_hearth:tiny_iron_dust>);   // by output
mods.rustic_hearth.EvaporatingBasin.removeRecipe(<fluid:rustic_hearth:ironberry_juice>); // by input fluid
```

## Alchemy Recipes ##
`mods.rustic_hearth.Condenser` / `<recipetype:rustic_hearth:condenser>`

Elixirs store their effects in the vanilla `minecraft:potion_contents` component, just like potions:
```
val slowness = <item:rustic_hearth:elixir>.withJsonComponent(<componenttype:minecraft:potion_contents>,
    {custom_effects: [{id: "minecraft:slowness", duration: 1800}]});
val longSlowness = <item:rustic_hearth:elixir>.withJsonComponent(<componenttype:minecraft:potion_contents>,
    {custom_effects: [{id: "minecraft:slowness", duration: 4800}]});
```

Alchemy recipes are divided into *simple* recipes, made in the standard condenser, and *advanced* recipes, which require the advanced condenser. A recipe is advanced when it has a modifier, more than two inputs, or when `advanced` is `true`.
> To force a two ingredient recipe without a modifier to be advanced, add `null` as a third input or pass `advanced = true`.

Simple method (two inputs, no modifier):
```
mods.rustic_hearth.Condenser.addRecipe(slowness, <item:minecraft:cobweb>, <item:minecraft:vine>);
```

Full method:
```
mods.rustic_hearth.Condenser.addRecipe(name, output, inputs, modifier, bottle, fluid, time, advanced);
```
where
+ `name` is the recipe name (can be left out, see below)
+ `output` is the recipe output
+ `inputs` is an array of at most 3 ingredients
+ `modifier` is the modifier required, can be `null` or left out
+ `bottle` is the item required in the bottle slot. If `null` or left out, it defaults to a glass bottle. Use `<item:minecraft:air>` for recipes that need no bottle. (*WARNING*: do not use items that can be used as furnace fuel as bottles, otherwise the recipe cannot be automated. See the [Alchemy](Alchemy.md) page for details)
+ `fluid` is the fluid and amount to consume. If `null` or left out, it defaults to 125 mB of water (`<fluid:minecraft:water> * 125`)
+ `time` is the time in ticks the recipe takes. If 0 or left out, it defaults to 400 for simple and 300 for advanced recipes
+ `advanced` forces the recipe to require the advanced condenser (only in the named version)

All optional parameters can be left out, but cannot be skipped: use `null` to keep the default of an optional parameter and still set a later one.
```
mods.rustic_hearth.Condenser.addRecipe("long_slowness", longSlowness, [<item:minecraft:cobweb>, <item:minecraft:vine>], <item:rustic_hearth:horsetail>);
mods.rustic_hearth.Condenser.addRecipe(longSlowness, [<item:minecraft:cobweb>, <item:minecraft:vine>], <item:rustic_hearth:horsetail>);
mods.rustic_hearth.Condenser.addRecipe(longSlowness, [<item:minecraft:cobweb>, <item:minecraft:vine>], null, null, <fluid:minecraft:water> * 250, 600);
```

To remove recipes:
```
mods.rustic_hearth.Condenser.removeRecipe(output);
```

## Brewing Recipes ##
`mods.rustic_hearth.Brewing` / `<recipetype:rustic_hearth:brewing>`

The brewing barrel converts the input fluid into the output fluid. `quality` is `"standard"` (random quality between 5% and 75%) or `"ambrosia"` (between 49% and 74%, and cultures never lower the quality).
```
// name, output fluid, input fluid, optional quality mode
mods.rustic_hearth.Brewing.addRecipe("berry_mead", <fluid:rustic_hearth:mead>, <fluid:rustic_hearth:wildberry_juice>);
mods.rustic_hearth.Brewing.addRecipe("golden_mead", <fluid:rustic_hearth:mead>, <fluid:rustic_hearth:golden_apple_juice>, "ambrosia");

// without a name
mods.rustic_hearth.Brewing.addRecipe(<fluid:rustic_hearth:mead>, <fluid:rustic_hearth:wildberry_juice>);
```
To remove recipes:
```
mods.rustic_hearth.Brewing.removeRecipe(<fluid:rustic_hearth:wine>);                 // by output
mods.rustic_hearth.Brewing.removeByInputFluid(<fluid:rustic_hearth:grape_juice>);    // by input
```
