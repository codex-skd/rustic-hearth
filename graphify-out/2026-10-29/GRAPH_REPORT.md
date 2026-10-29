# Graph Report - 1.21.1  (2026-10-16)

## Corpus Check
- 1550 files · ~229,588 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 3894 nodes · 9121 edges · 176 communities (166 shown, 10 thin omitted)
- Extraction: 97% EXTRACTED · 3% INFERRED · 0% AMBIGUOUS · INFERRED: 275 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `dc5f6338`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- HerbBlock
- BrewingBarrelBlockEntity
- EvaporatingBasinBlock.java
- FarmData.java
- GrapeLeavesBlock
- RopeBaseBlock
- RusticBlockStateProvider
- AbstractCondenserBlock
- ModFluids.java
- .init
- HorizontalDirectionalBlock
- StakeCropBlock
- StakeTiedBlock
- CraftingDisplayRecipe
- ModTags.java
- MountedLightBlock
- DoubleCandleBlock.java
- OffsetBushModel.java
- FluidBottleItem
- CandleLeverBlock
- CabinetBlockEntity
- RusticRecipeProvider
- LatticeBlock
- MiscData.java
- ModEffects.java
- BookButtons.java
- ModMenus.java
- AppleLeavesBlock
- RetortBlock.java
- CrushingTubRecipe
- CabinetBlock
- AbstractCondenserBlockEntity
- RusticBlockLoot
- BrewingRecipe
- AlchemyData.java
- StorageData.java
- CondenserRecipe
- ApiaryBlockEntity.java
- GrapeStemBlock
- BrewingBarrelBlock.java
- EvaporatingBasinRecipe
- ModBlocks.java
- LiquidBarrelBlockEntity
- .add
- AlmanacScreen
- TableBlock
- VaseBlock.java
- Block
- ElixirItem
- CabinetBlock.java
- WoodVariant
- ApiaryBlock.java
- Override
- VantaOilRecipe
- AlchemyClientSetup.java
- EntityBlock
- Home.md
- ChairBlock.java
- AlchemySetup.java
- Minecraft
- EffectEvents.java
- ApiaryMenu.java
- BookCategory
- StorageClientSetup
- AbstractCondenserMenu
- EvaporatingBasinBlockEntity
- Crushing-Tub.md
- BoozeItemPredicate
- RusticHearth.java
- BoozeFluidType.java
- .render
- LiquidBarrelItem.java
- ClientSetup.java
- WorldGenOptions
- RusticBarrelBlock.java
- BookEntry
- FirePowerAttackPayload.java
- RusticJeiPlugin.java
- FluidContentSubtypeInterpreter.java
- NoRemainderShapelessRecipe.java
- CrushingTubBlockEntity
- PageView.java
- TexturedRecipeCategory
- RusticConfig.java
- RusticClient.java
- AdvancedCondenserMenu.java
- AbstractContainerScreen
- SyncedBlockEntity
- CraftingDisplays.java
- TomatoEntity.java
- CabinetModel
- StorageBlockEntity
- FertileSoilBlock.java
- ModBlockEntities.java
- FluidRendering.java
- EsEs
- RusticFoodItem.java
- OliveOilRecipe.java
- .addTags
- VaseItem.java
- ChatFormatting
- RusticTagProviders.java
- AdvancedCondenserBlock
- CondenserBlock
- StorageMenu
- ModItems.java
- GrapeSeedsModifier
- IronSkinTextures
- AutomationHandler
- AdvancedCondenserBlockEntity
- CondenserBlockEntity
- CondenserMenu.java
- DecorClientSetup.java
- Translations
- ModDataComponents.java
- ChairSeatEntity
- ModWorldGen.java
- ModRecipes.java
- AlchemyCategory.java
- .addAll
- FullmetalClient.java
- IronTorchBlock
- CabinetRenderer.java
- Almanac
- BrewingCategory.java
- EvaporatingCategory.java
- GrassSeedsModifier
- DrainOnlyFluidHandler
- ConfigChancePlacement
- RusticChainBlock
- ConfigCountPlacement
- RusticBarrelBlockEntity
- DeDe
- PtBr
- ConfigFilterPlacement
- Brewing.md
- Items
- TipsyEffect.java
- Item
- AbstractCondenserScreen
- Provider
- AlmanacItem.java
- .use
- ModConfigFlags
- Mod-Compatibility.md
- Ironberries.md
- BeehiveFeature.java
- ConfigCondition
- ModCreativeTabs.java
- ChairSeatEntity.java
- Alchemy.md
- RusticDamage.java
- Flujo de trabajo — Rustic Hearth (NeoForge)
- CondenserRecipeInput
- RusticSaplingBlock
- RusticAdvancementProvider.java
- RusticWorldGenProvider.java
- Proyecto
- ErisNameFormat.java
- Bees.md
- Plan — Rustic Hearth (fork de Rustic Revived)
- RusticLanguageProvider.java
- ModEntities.java
- Rustic Hearth #
- Rustic Hearth — Logo de CurseForge
- rename_from_revived.py
- rename_to_rustic_hearth.py
- ModBanners.java
- gradlew
- Rustic Hearth
- Changelog
- UPSTREAM.md

## God Nodes (most connected - your core abstractions)
1. `ModBlocks` - 68 edges
2. `AbstractCondenserBlockEntity` - 51 edges
3. `BookEntry` - 43 edges
4. `BrewingBarrelBlockEntity` - 42 edges
5. `RusticBlockStateProvider` - 42 edges
6. `CondenserRecipe` - 39 edges
7. `AbstractCondenserBlock` - 37 edges
8. `StakeCropBlock` - 37 edges
9. `AlmanacScreen` - 37 edges
10. `FarmData` - 37 edges

## Surprising Connections (you probably didn't know these)
- `ModBlocks` --references--> `WoodVariant`  [EXTRACTED]
  src/main/java/com/skd/rustichearth/registry/ModBlocks.java → src/main/java/com/skd/rustichearth/block/WoodVariant.java
- `AdvancedCondenserBlock` --inherits--> `AbstractCondenserBlock`  [EXTRACTED]
  src/main/java/com/skd/rustichearth/block/alchemy/AdvancedCondenserBlock.java → src/main/java/com/skd/rustichearth/block/alchemy/AbstractCondenserBlock.java
- `CondenserBlock` --inherits--> `AbstractCondenserBlock`  [EXTRACTED]
  src/main/java/com/skd/rustichearth/block/alchemy/CondenserBlock.java → src/main/java/com/skd/rustichearth/block/alchemy/AbstractCondenserBlock.java
- `ModBlocks` --references--> `AdvancedCondenserBlock`  [EXTRACTED]
  src/main/java/com/skd/rustichearth/registry/ModBlocks.java → src/main/java/com/skd/rustichearth/block/alchemy/AdvancedCondenserBlock.java
- `ModBlocks` --references--> `BrewingBarrelBlock`  [EXTRACTED]
  src/main/java/com/skd/rustichearth/registry/ModBlocks.java → src/main/java/com/skd/rustichearth/block/alchemy/BrewingBarrelBlock.java

## Import Cycles
- None detected.

## Communities (176 total, 10 thin omitted)

### Community 0 - "HerbBlock"
Cohesion: 0.05
Nodes (61): BonemealableBlock, BushBlock, AppleSeedsBlock, Block, BlockGetter, BlockPos, BlockState, Builder (+53 more)

### Community 1 - "BrewingBarrelBlockEntity"
Cohesion: 0.05
Nodes (39): IFluidHandlerItem, AutomationHandler, BrewingBarrelBlockEntity, AbstractContainerMenu, BlockPos, BlockState, Component, CompoundTag (+31 more)

### Community 2 - "EvaporatingBasinBlock.java"
Cohesion: 0.17
Nodes (20): EvaporatingBasinBlock, BlockEntity, BlockEntityTicker, BlockEntityType, BlockGetter, BlockHitResult, BlockPos, BlockState (+12 more)

### Community 3 - "FarmData.java"
Cohesion: 0.09
Nodes (33): BiomeModifier, Decoration, Enchantment, HolderGetter, PlacedFeature, PlacementModifier, FarmData, Herb (+25 more)

### Community 4 - "GrapeLeavesBlock"
Cohesion: 0.09
Nodes (34): FarmHelper, Axis, BlockGetter, BlockPos, BlockState, ItemStack, Level, Player (+26 more)

### Community 5 - "RopeBaseBlock"
Cohesion: 0.09
Nodes (35): Axis, BlockGetter, BlockHitResult, BlockPlaceContext, BlockPos, BlockState, BooleanProperty, Builder (+27 more)

### Community 6 - "RusticBlockStateProvider"
Cohesion: 0.08
Nodes (22): BlockStateProvider, MultiPartBlockStateBuilder, DecorData, Block, Blocks, Criterion, DeferredBlock, Direction (+14 more)

### Community 7 - "AbstractCondenserBlock"
Cohesion: 0.17
Nodes (13): AbstractCondenserBlock, BlockHitResult, BlockPos, BlockState, Builder, Direction, InteractionHand, InteractionResult (+5 more)

### Community 8 - "ModFluids.java"
Cohesion: 0.08
Nodes (31): BucketItem, Flowing, FlowingFluid, FluidType, LiquidBlock, Source, DrinkableFluidType, DrinkEffect (+23 more)

### Community 9 - ".init"
Cohesion: 0.06
Nodes (23): BlockSource, DefaultDispenseItemBehavior, FireBlock, FMLCommonSetupEvent, ItemStack, Override, RopeDispenseBehavior, IEventBus (+15 more)

### Community 10 - "HorizontalDirectionalBlock"
Cohesion: 0.08
Nodes (33): HorizontalDirectionalBlock, ClayWallDiagBlock, Block, BlockPlaceContext, BlockState, Builder, MapCodec, Override (+25 more)

### Community 11 - "StakeCropBlock"
Cohesion: 0.12
Nodes (24): BlockGetter, BlockHitResult, BlockPos, BlockState, Builder, CollisionContext, Direction, Explosion (+16 more)

### Community 12 - "StakeTiedBlock"
Cohesion: 0.10
Nodes (32): CropStakeBlock, BlockGetter, BlockHitResult, BlockPos, BlockState, CollisionContext, InteractionHand, ItemInteractionResult (+24 more)

### Community 13 - "CraftingDisplayRecipe"
Cohesion: 0.14
Nodes (14): ICraftingCategoryExtension, ICraftingGridHelper, CraftingDisplayExtension, IFocusGroup, IRecipeLayoutBuilder, Override, RecipeHolder, CraftingDisplayRecipe (+6 more)

### Community 14 - "ModTags.java"
Cohesion: 0.10
Nodes (28): FallingBlock, FallingBlockEntity, ChandelierBlock, BlockGetter, BlockPos, BlockState, CollisionContext, Level (+20 more)

### Community 15 - "MountedLightBlock"
Cohesion: 0.10
Nodes (28): BlockGetter, BlockPlaceContext, BlockPos, BlockState, Builder, CollisionContext, Direction, DirectionProperty (+20 more)

### Community 16 - "DoubleCandleBlock.java"
Cohesion: 0.09
Nodes (31): DoubleCandleBlock, facing(), getSerializedName(), Axis, BlockGetter, BlockPlaceContext, BlockPos, BlockState (+23 more)

### Community 17 - "OffsetBushModel.java"
Cohesion: 0.09
Nodes (27): AddLayers, BakedModel, BakedModelWrapper, BakedQuad, BlockAndTintGetter, LivingEntityRenderer, ModelData, ModelProperty (+19 more)

### Community 18 - "FluidBottleItem"
Cohesion: 0.13
Nodes (17): RightClickItem, FluidBottleItem, FluidHandler, Component, FluidAction, FluidStack, InteractionHand, InteractionResultHolder (+9 more)

### Community 19 - "CandleLeverBlock"
Cohesion: 0.11
Nodes (25): CandleLeverBlock, Block, BlockGetter, BlockHitResult, BlockPos, BlockState, BooleanProperty, Builder (+17 more)

### Community 20 - "CabinetBlockEntity"
Cohesion: 0.10
Nodes (21): ChestLidController, ContainerOpenersCounter, SoundEvent, CabinetBlockEntity, AbstractContainerMenu, BlockPos, BlockState, Builder (+13 more)

### Community 21 - "RusticRecipeProvider"
Cohesion: 0.14
Nodes (15): RecipeProvider, Item, ItemLike, RecipeOutput, TagKey, Criterion, Item, ItemLike (+7 more)

### Community 22 - "LatticeBlock"
Cohesion: 0.14
Nodes (22): BlockGetter, BlockHitResult, BlockPlaceContext, BlockPos, BlockState, BooleanProperty, Builder, CollisionContext (+14 more)

### Community 23 - "MiscData.java"
Cohesion: 0.15
Nodes (13): AdvancementHolder, BannerPattern, BootstrapContext, Component, DamageType, Direction, ExistingFileHelper, ItemModelBuilder (+5 more)

### Community 24 - "ModEffects.java"
Cohesion: 0.06
Nodes (25): EffectCure, MobEffect, MobEffectCategory, BlazingTrailEffect, LivingEntity, Override, FeatherEffect, LivingEntity (+17 more)

### Community 25 - "BookButtons.java"
Cohesion: 0.12
Nodes (14): AbstractButton, NarrationElementOutput, BackButton, BookButton, BookButtons, CategoryButton, EntryLinkButton, Component (+6 more)

### Community 26 - "ModMenus.java"
Cohesion: 0.18
Nodes (13): IContainerFactory, Container, Inventory, RegistryFriendlyByteBuf, RusticBarrelMenu, Container, Inventory, RegistryFriendlyByteBuf (+5 more)

### Community 27 - "AppleLeavesBlock"
Cohesion: 0.13
Nodes (20): LeavesBlock, AppleLeavesBlock, Block, BlockGetter, BlockHitResult, BlockPos, BlockState, Builder (+12 more)

### Community 28 - "RetortBlock.java"
Cohesion: 0.16
Nodes (20): BlockGetter, BlockHitResult, BlockPlaceContext, BlockPos, BlockState, Builder, CollisionContext, DirectionProperty (+12 more)

### Community 29 - "CrushingTubRecipe"
Cohesion: 0.12
Nodes (19): SingleRecipeInput, CrushingTubCategory, IFocusGroup, IGuiHelper, IRecipeLayoutBuilder, Override, RecipeHolder, CrushingTubRecipe (+11 more)

### Community 30 - "CabinetBlock"
Cohesion: 0.18
Nodes (11): CabinetBlock, Block, BlockPlaceContext, BlockPos, BlockState, Builder, Direction, Level (+3 more)

### Community 31 - "AbstractCondenserBlockEntity"
Cohesion: 0.12
Nodes (14): MenuProvider, AbstractCondenserBlockEntity, BlockEntityType, BlockPos, BlockState, ContainerData, Direction, FluidTank (+6 more)

### Community 32 - "RusticBlockLoot"
Cohesion: 0.15
Nodes (9): BlockLootSubProvider, NumberProvider, Block, Builder, Item, ItemLike, Override, Provider (+1 more)

### Community 33 - "BrewingRecipe"
Cohesion: 0.11
Nodes (22): Recipe, RecipeHolder, RecipeType, JeiRecipeTypes, BrewingRecipe, getSerializedName(), FluidIngredient, FluidStack (+14 more)

### Community 34 - "AlchemyData.java"
Cohesion: 0.17
Nodes (13): AlchemyData, Block, Fluid, FluidIngredient, Fluids, Holder, ItemLike, ItemStack (+5 more)

### Community 35 - "StorageData.java"
Cohesion: 0.10
Nodes (15): DataMapProvider, DataMapType, RecipeCategory, Block, Blocks, Builder, Items, ModelFile (+7 more)

### Community 36 - "CondenserRecipe"
Cohesion: 0.13
Nodes (14): DataResult, CondenserRecipe, Ingredient, ItemStack, Level, MapCodec, NonNullList, Override (+6 more)

### Community 37 - "ApiaryBlockEntity.java"
Cohesion: 0.13
Nodes (17): ApiaryBlockEntity, FilteredHandler, AbstractContainerMenu, BlockPos, BlockState, Component, CompoundTag, Direction (+9 more)

### Community 38 - "GrapeStemBlock"
Cohesion: 0.18
Nodes (17): GrapeStemBlock, Axis, BlockGetter, BlockPos, BlockState, Builder, CollisionContext, Direction (+9 more)

### Community 39 - "BrewingBarrelBlock.java"
Cohesion: 0.15
Nodes (19): BrewingBarrelBlock, BlockEntity, BlockEntityTicker, BlockEntityType, BlockHitResult, BlockPlaceContext, BlockPos, BlockState (+11 more)

### Community 40 - "EvaporatingBasinRecipe"
Cohesion: 0.12
Nodes (16): RecipeInput, EvaporatingBasinRecipe, ItemStack, Level, MapCodec, Override, Provider, RecipeSerializer (+8 more)

### Community 41 - "ModBlocks.java"
Cohesion: 0.13
Nodes (11): MapColor, Block, DeferredBlock, DoorBlock, DyeColor, FenceBlock, FenceGateBlock, RotatedPillarBlock (+3 more)

### Community 42 - "LiquidBarrelBlockEntity"
Cohesion: 0.15
Nodes (13): Builder, CompoundTag, DataComponentInput, FluidTank, Override, Provider, LiquidBarrelBlockEntity, Context (+5 more)

### Community 43 - ".add"
Cohesion: 0.13
Nodes (3): EnUs, FrFr, SafeVarargs

### Community 44 - "AlmanacScreen"
Cohesion: 0.17
Nodes (6): Screen, AlmanacScreen, BookLocation, GuiGraphics, Override, ResourceLocation

### Community 45 - "TableBlock"
Cohesion: 0.19
Nodes (15): BlockGetter, BlockPlaceContext, BlockPos, BlockState, BooleanProperty, Builder, CollisionContext, Direction (+7 more)

### Community 46 - "VaseBlock.java"
Cohesion: 0.08
Nodes (34): RandomizableContainerBlockEntity, BlockEntity, BlockGetter, BlockHitResult, BlockPos, BlockState, Builder, CollisionContext (+26 more)

### Community 47 - "Block"
Cohesion: 0.18
Nodes (15): BlockGetter, BlockPlaceContext, BlockPos, BlockState, Builder, CollisionContext, DirectionProperty, Level (+7 more)

### Community 48 - "ElixirItem"
Cohesion: 0.05
Nodes (48): BannerPatternItem, Item, ItemNameBlockItem, PotionContents, AlmanacItem, InteractionHand, InteractionResultHolder, ItemStack (+40 more)

### Community 49 - "CabinetBlock.java"
Cohesion: 0.10
Nodes (23): RenderShape, DoubleCabinetProvider, AbstractContainerMenu, BlockEntity, BlockEntityTicker, BlockEntityType, BlockHitResult, BooleanProperty (+15 more)

### Community 50 - "WoodVariant"
Cohesion: 0.10
Nodes (22): SoundType, getSerializedName(), Block, Override, ResourceLocation, planks(), planksTexture(), sound() (+14 more)

### Community 51 - "ApiaryBlock.java"
Cohesion: 0.17
Nodes (16): ApiaryBlock, Block, BlockEntity, BlockEntityTicker, BlockEntityType, BlockHitResult, BlockPlaceContext, BlockPos (+8 more)

### Community 52 - "Override"
Cohesion: 0.15
Nodes (3): Override, RuRu, ZhCn

### Community 53 - "VantaOilRecipe"
Cohesion: 0.20
Nodes (11): CraftingBookCategory, CraftingInput, ItemStack, Level, MobEffectInstance, NonNullList, Nullable, Override (+3 more)

### Community 54 - "AlchemyClientSetup.java"
Cohesion: 0.16
Nodes (10): ItemTooltipEvent, AlchemyClientSetup, Component, FMLClientSetupEvent, IEventBus, ItemStack, MobEffectInstance, RegisterClientExtensionsEvent (+2 more)

### Community 55 - "EntityBlock"
Cohesion: 0.19
Nodes (16): Precipitation, BlockEntity, BlockGetter, BlockHitResult, BlockPos, BlockState, CollisionContext, InteractionHand (+8 more)

### Community 56 - "Home.md"
Cohesion: 0.12
Nodes (5): Ghost Peppers ##, Grape Juice ##, Grape Vines ##, Grapes ##, Variants ##

### Community 57 - "ChairBlock.java"
Cohesion: 0.18
Nodes (16): AABB, ChairBlock, Block, BlockGetter, BlockHitResult, BlockPlaceContext, BlockPos, BlockState (+8 more)

### Community 58 - "AlchemySetup.java"
Cohesion: 0.10
Nodes (17): AttackEntityEvent, CreativeModeTab, DisplayItemsGenerator, RightClickBlock, RusticCreativeContents, AlchemySetup, BlockPos, BlockState (+9 more)

### Community 59 - "Minecraft"
Cohesion: 0.18
Nodes (14): BlockEntityWithoutLevelRenderer, Minecraft, ItemDisplayContext, ItemStack, MultiBufferSource, Override, PoseStack, LiquidBarrelItemRenderer (+6 more)

### Community 60 - "EffectEvents.java"
Cohesion: 0.15
Nodes (12): CanPlayerSleepEvent, EntityMountEvent, LivingDeathEvent, LivingFallEvent, LivingIncomingDamageEvent, LivingJumpEvent, EffectEvents, EventBusSubscriber (+4 more)

### Community 61 - "ApiaryMenu.java"
Cohesion: 0.28
Nodes (9): AbstractContainerMenu, ContainerLevelAccess, ApiaryMenu, IItemHandler, Inventory, ItemStack, Override, Player (+1 more)

### Community 62 - "BookCategory"
Cohesion: 0.14
Nodes (5): BookCategory, ResourceLocation, BookEntryCategory, Override, CategoriesPage

### Community 63 - "StorageClientSetup"
Cohesion: 0.19
Nodes (6): FMLClientSetupEvent, RegisterClientExtensionsEvent, RegisterClientReloadListenersEvent, RegisterMenuScreensEvent, RegisterRenderers, StorageClientSetup

### Community 64 - "AbstractCondenserMenu"
Cohesion: 0.15
Nodes (10): AbstractCondenserMenu, BlockPos, ContainerData, FluidTank, IItemHandler, Inventory, ItemStack, MenuType (+2 more)

### Community 65 - "EvaporatingBasinBlockEntity"
Cohesion: 0.12
Nodes (18): BlockEntityRenderer, EvaporatingBasinBlockEntity, BlockPos, BlockState, CompoundTag, FluidStack, FluidTank, IItemHandler (+10 more)

### Community 66 - "Crushing-Tub.md"
Cohesion: 0.12
Nodes (15): Alchemy Recipes ##, Brewing Recipes ##, Crushing Tub Recipes ##, Evaporating Basin Recipes ##, Recipes ##, Usage ##, Recipes ##, Usage ## (+7 more)

### Community 67 - "BoozeItemPredicate"
Cohesion: 0.16
Nodes (15): CriterionTrigger, Doubles, ItemSubPredicate, RegisterEvent, BoozeItemPredicate, Codec, Fluid, Holder (+7 more)

### Community 68 - "RusticHearth.java"
Cohesion: 0.21
Nodes (8): Logger, Mod, ModContainer, RegisterPayloadHandlersEvent, RusticNetwork, IEventBus, ResourceLocation, RusticHearth

### Community 69 - "BoozeFluidType.java"
Cohesion: 0.20
Nodes (9): Item, BoozeFluidType, FluidStack, FunctionalInterface, ItemStack, Level, Override, Player (+1 more)

### Community 70 - ".render"
Cohesion: 0.19
Nodes (17): CrushingTubBlock, BlockEntity, BlockGetter, BlockHitResult, BlockPos, BlockState, CollisionContext, Entity (+9 more)

### Community 71 - "LiquidBarrelItem.java"
Cohesion: 0.18
Nodes (11): FluidHandlerItemStack, FluidStack, FluidHandler, Block, Component, FluidStack, ItemStack, Override (+3 more)

### Community 72 - "ClientSetup.java"
Cohesion: 0.11
Nodes (10): ModifyBakingResult, ClientSetup, IEventBus, RegisterClientExtensionsEvent, RegisterRenderers, FarmClientSetup, Block, IEventBus (+2 more)

### Community 73 - "WorldGenOptions"
Cohesion: 0.22
Nodes (6): BooleanSupplier, Codec, ConfigValue, DoubleValue, IntValue, WorldGenOptions

### Community 74 - "RusticBarrelBlock.java"
Cohesion: 0.20
Nodes (15): Block, EntityBlock, BlockEntity, BlockGetter, BlockHitResult, BlockPos, BlockState, CollisionContext (+7 more)

### Community 75 - "BookEntry"
Cohesion: 0.18
Nodes (6): BookEntry, ItemStack, Nullable, BookPage, CategoryPage, TextPage

### Community 76 - "FirePowerAttackPayload.java"
Cohesion: 0.16
Nodes (10): InteractionKeyMappingTriggered, RegisterGuiLayersEvent, IEventBus, RusticClient, FirePowerAttackPayload, IPayloadContext, Override, RegistryFriendlyByteBuf (+2 more)

### Community 77 - "RusticJeiPlugin.java"
Cohesion: 0.07
Nodes (29): IGuiHandlerRegistration, IModPlugin, IRecipeCatalystRegistration, IRecipeCategoryRegistration, IRecipeRegistration, ISubtypeRegistration, IVanillaCategoryExtensionRegistration, JeiPlugin (+21 more)

### Community 78 - "FluidContentSubtypeInterpreter.java"
Cohesion: 0.20
Nodes (11): ISubtypeInterpreter, FluidContentSubtypeInterpreter, ItemStack, Nullable, Override, UidContext, ItemStack, Nullable (+3 more)

### Community 79 - "NoRemainderShapelessRecipe.java"
Cohesion: 0.23
Nodes (13): ShapelessRecipe, CraftingBookCategory, CraftingInput, Ingredient, ItemStack, MapCodec, NonNullList, Override (+5 more)

### Community 80 - "CrushingTubBlockEntity"
Cohesion: 0.12
Nodes (17): CrushingTubBlockEntity, BlockPos, BlockState, CompoundTag, FluidTank, IFluidHandler, ItemStack, ItemStackHandler (+9 more)

### Community 81 - "PageView.java"
Cohesion: 0.27
Nodes (7): Font, Categories, Category, GuiGraphics, Override, PageView, Text

### Community 82 - "TexturedRecipeCategory"
Cohesion: 0.07
Nodes (38): AbstractRecipeCategory, AlchemyCategory, GuiGraphics, IDrawableAnimated, IDrawableStatic, IFocusGroup, IGuiHelper, IRecipeLayoutBuilder (+30 more)

### Community 83 - "RusticConfig.java"
Cohesion: 0.17
Nodes (10): BooleanValue, ModConfigSpec, Client, Common, Builder, ConfigValue, DoubleValue, IntValue (+2 more)

### Community 84 - "RusticClient.java"
Cohesion: 0.31
Nodes (5): ArmorHud, DeltaTracker, GuiGraphics, Pre, ResourceLocation

### Community 85 - "AdvancedCondenserMenu.java"
Cohesion: 0.17
Nodes (13): SlotItemHandler, AdvancedCondenserScreen, Component, GuiGraphics, Inventory, Override, ResourceLocation, AdvancedCondenserMenu (+5 more)

### Community 86 - "AbstractContainerScreen"
Cohesion: 0.21
Nodes (10): IQuarkButtonAllowed, Component, GuiGraphics, Inventory, Override, ResourceLocation, StorageScreen, Component (+2 more)

### Community 87 - "SyncedBlockEntity"
Cohesion: 0.18
Nodes (11): BlockEntity, BlockEntityType, BlockPos, BlockState, ClientGamePacketListener, CompoundTag, IItemHandler, Override (+3 more)

### Community 88 - "CraftingDisplays.java"
Cohesion: 0.33
Nodes (7): CraftingRecipe, CraftingDisplays, Fluid, Item, ItemStack, RecipeHolder, TagKey

### Community 89 - "TomatoEntity.java"
Cohesion: 0.21
Nodes (10): EntityHitResult, HitResult, ParticleOptions, EntityType, Item, Level, LivingEntity, Override (+2 more)

### Community 90 - "CabinetModel"
Cohesion: 0.18
Nodes (9): LayerDefinition, ModelLayerLocation, ModelPart, PartDefinition, RegisterLayerDefinitions, CabinetModel, PoseStack, VertexConsumer (+1 more)

### Community 91 - "StorageBlockEntity"
Cohesion: 0.12
Nodes (16): PushReaction, BlockEntity, BlockEntityTicker, BlockEntityType, BlockGetter, BlockPlaceContext, BooleanProperty, CollisionContext (+8 more)

### Community 92 - "FertileSoilBlock.java"
Cohesion: 0.25
Nodes (11): FertileSoilBlock, BlockGetter, BlockPos, BlockState, Direction, LevelReader, MapCodec, Override (+3 more)

### Community 93 - "ModBlockEntities.java"
Cohesion: 0.26
Nodes (10): AlchemyInteractions, BlockPos, IFluidHandler, IItemHandlerModifiable, InteractionHand, InteractionResult, ItemInteractionResult, ItemStack (+2 more)

### Community 94 - "FluidRendering.java"
Cohesion: 0.24
Nodes (9): FluidRendering, Component, FluidStack, GuiGraphics, MultiBufferSource, Pose, PoseStack, VertexConsumer (+1 more)

### Community 96 - "RusticFoodItem.java"
Cohesion: 0.24
Nodes (8): CabinetRecipe, CraftingBookCategory, CraftingInput, ItemStack, Level, Override, Provider, RecipeSerializer

### Community 97 - "OliveOilRecipe.java"
Cohesion: 0.22
Nodes (9): CustomRecipe, CraftingBookCategory, CraftingInput, ItemStack, Level, Override, Provider, RecipeSerializer (+1 more)

### Community 98 - ".addTags"
Cohesion: 0.12
Nodes (10): BannerPatterns, Biomes, EntityTypes, Items, Fluids, ExistingFileHelper, Override, PackOutput (+2 more)

### Community 99 - "VaseItem.java"
Cohesion: 0.13
Nodes (13): BlockItem, CustomPacketPayload, MouseScrollingEvent, VaseScrollHandler, Block, ItemStack, VaseItem, IPayloadContext (+5 more)

### Community 100 - "ChatFormatting"
Cohesion: 0.16
Nodes (11): ChatFormatting, BoozeQuality, Component, of(), Tier, HIGH, HIGHEST, HIGHISH (+3 more)

### Community 101 - "RusticTagProviders.java"
Cohesion: 0.14
Nodes (20): BlockTagsProvider, IntrinsicHolderTagsProvider, IntrinsicTagAppender, ItemTagsProvider, BannerPatterns, Biomes, Blocks, EntityTypes (+12 more)

### Community 102 - "AdvancedCondenserBlock"
Cohesion: 0.23
Nodes (8): AdvancedCondenserBlock, Block, BlockEntityType, BlockPos, BlockState, MapCodec, Override, VoxelShape

### Community 103 - "CondenserBlock"
Cohesion: 0.23
Nodes (8): CondenserBlock, Block, BlockEntityType, BlockPos, BlockState, MapCodec, Override, VoxelShape

### Community 104 - "StorageMenu"
Cohesion: 0.26
Nodes (7): Container, Inventory, ItemStack, MenuType, Override, Player, StorageMenu

### Community 105 - "ModItems.java"
Cohesion: 0.17
Nodes (11): Bloques e ítems (contextos `name` + `item_id`), Bloques (solo paleta / contexto `name`), Chairs y tables, Cómo se lee la tabla, Efectos de elixir (`ElixirEffects`), Efectos (poción), Pendiente / no verificado, Tabla de ids para el convertidor de plantillas de Ancient Warfare 2 (+3 more)

### Community 106 - "GrapeSeedsModifier"
Cohesion: 0.26
Nodes (10): LootModifier, GrapeSeedsModifier, IGlobalLootModifier, Item, ItemStack, LootContext, LootItemCondition, MapCodec (+2 more)

### Community 107 - "IronSkinTextures"
Cohesion: 0.27
Nodes (7): NativeImage, ResourceManager, ResourceManagerReloadListener, IronSkinTextures, Nullable, Override, ResourceLocation

### Community 108 - "AutomationHandler"
Cohesion: 0.27
Nodes (5): AutomationHandler, CompoundTag, ItemStack, Override, Provider

### Community 109 - "AdvancedCondenserBlockEntity"
Cohesion: 0.23
Nodes (8): AdvancedCondenserBlockEntity, AbstractContainerMenu, BlockPos, BlockState, Component, Inventory, Override, Player

### Community 110 - "CondenserBlockEntity"
Cohesion: 0.31
Nodes (7): AbstractContainerScreen, ApiaryScreen, Component, GuiGraphics, Inventory, Override, ResourceLocation

### Community 111 - "CondenserMenu.java"
Cohesion: 0.27
Nodes (5): GlobalLootModifierProvider, Override, PackOutput, Provider, RusticLootModifierProvider

### Community 112 - "DecorClientSetup.java"
Cohesion: 0.20
Nodes (7): DecorClientSetup, Block, IEventBus, ItemStack, Pose, RegisterRenderers, VertexConsumer

### Community 114 - "ModDataComponents.java"
Cohesion: 0.18
Nodes (14): DataComponents, DataComponentType, SimpleFluidContent, BlockPos, BlockState, Codec, DeferredHolder, Item (+6 more)

### Community 115 - "ChairSeatEntity"
Cohesion: 0.27
Nodes (6): Entity, MoveFunction, ChairSeatEntity, Builder, CompoundTag, Override

### Community 116 - "ModWorldGen.java"
Cohesion: 0.25
Nodes (11): FoliagePlacerType, DeferredHolder, DeferredRegister, Feature, IEventBus, IGlobalLootModifier, MapCodec, PlacementModifierType (+3 more)

### Community 117 - "ModRecipes.java"
Cohesion: 0.30
Nodes (10): SimpleCraftingRecipeSerializer, DeferredHolder, DeferredRegister, ICondition, MapCodec, RecipeSerializer, RecipeType, RegistryFriendlyByteBuf (+2 more)

### Community 118 - "AlchemyCategory.java"
Cohesion: 0.25
Nodes (6): RegisterMenuScreensEvent, QuarkCompat, DoubleCabinetMenu, Container, Inventory, RegistryFriendlyByteBuf

### Community 120 - "FullmetalClient.java"
Cohesion: 0.24
Nodes (7): ComputeFovModifierEvent, MovementInputUpdateEvent, FullmetalClient, DeltaTracker, GuiGraphics, MobEffectInstance, ResourceLocation

### Community 121 - "IronTorchBlock"
Cohesion: 0.27
Nodes (9): IronTorchBlock, BlockPos, BlockState, Direction, Level, MapCodec, Override, RandomSource (+1 more)

### Community 122 - "CabinetRenderer.java"
Cohesion: 0.29
Nodes (7): CabinetRenderer, Direction, Item, MultiBufferSource, Override, PoseStack, ResourceLocation

### Community 123 - "Almanac"
Cohesion: 0.29
Nodes (4): Almanac, ItemLike, ItemStack, ResourceLocation

### Community 124 - "BrewingCategory.java"
Cohesion: 0.31
Nodes (6): OreConfiguration, OreFeature, Codec, FeaturePlaceContext, Override, SlateVeinFeature

### Community 125 - "EvaporatingCategory.java"
Cohesion: 0.25
Nodes (7): Agricultura, Arranque, Compatibilidad, Decoración y almacenaje, Elaboración y alquimia, Guía de prueba en cliente — Rustic Hearth 0.0.0-beta.1, Si algo falla

### Community 126 - "GrassSeedsModifier"
Cohesion: 0.28
Nodes (9): GrassSeedsModifier, IGlobalLootModifier, Item, ItemStack, LootContext, LootItemCondition, MapCodec, ObjectArrayList (+1 more)

### Community 127 - "DrainOnlyFluidHandler"
Cohesion: 0.33
Nodes (5): IFluidHandler, DrainOnlyFluidHandler, FluidAction, FluidStack, Override

### Community 128 - "ConfigChancePlacement"
Cohesion: 0.27
Nodes (8): PlacementFilter, ConfigChancePlacement, BlockPos, MapCodec, Override, PlacementContext, PlacementModifierType, RandomSource

### Community 129 - "RusticChainBlock"
Cohesion: 0.24
Nodes (8): Axis, BlockPos, BlockState, Direction, LevelReader, MapCodec, Override, RusticChainBlock

### Community 130 - "ConfigCountPlacement"
Cohesion: 0.29
Nodes (7): RepeatingPlacement, ConfigCountPlacement, BlockPos, MapCodec, Override, PlacementModifierType, RandomSource

### Community 131 - "RusticBarrelBlockEntity"
Cohesion: 0.20
Nodes (11): AbstractContainerMenu, BlockPos, BlockState, Component, Inventory, Override, RusticBarrelBlockEntity, BlockEntityType (+3 more)

### Community 134 - "ConfigFilterPlacement"
Cohesion: 0.29
Nodes (7): ConfigFilterPlacement, BlockPos, MapCodec, Override, PlacementContext, PlacementModifierType, RandomSource

### Community 135 - "Brewing.md"
Cohesion: 0.18
Nodes (9): Booze ##, Brewing Barrel ##, Inebriation ###, Special Effects ###, Types ###, Usage ##, Wildberries ##, Wildberry bushes ## (+1 more)

### Community 136 - "Items"
Cohesion: 0.36
Nodes (7): collect_registered_names(), find_root(), main(), Return (status, targets) for one `rustic:<name>` id., Project root = two levels above this file (docs/tools/check_template_ids.py)., Every name the new mod registers, from assets, lang keys and Java code., resolve()

### Community 137 - "TipsyEffect.java"
Cohesion: 0.52
Nodes (4): ConfiguredFeature, ResourceKey, TreeGrower, ModTreeGrowers

### Community 139 - "AbstractCondenserScreen"
Cohesion: 0.36
Nodes (6): AbstractCondenserScreen, Component, GuiGraphics, Inventory, Override, ResourceLocation

### Community 140 - "Provider"
Cohesion: 0.53
Nodes (4): CabinetMenu, Container, Inventory, RegistryFriendlyByteBuf

### Community 142 - ".use"
Cohesion: 0.39
Nodes (6): InteractionHand, InteractionResultHolder, ItemStack, Level, Override, Player

### Community 144 - "Mod-Compatibility.md"
Cohesion: 0.20
Nodes (6): CraftTweaker and KubeJS ##, Dynamic Trees ##, Inventory Tweaks Refoxed ##, JEI ##, Other Stone Types ##, Quark ##

### Community 145 - "Ironberries.md"
Cohesion: 0.22
Nodes (6): Ironberries ##, Ironberry Juice ##, Ironwood Trees ##, Olive Oil ##, Olive Trees ##, Olives ##

### Community 146 - "BeehiveFeature.java"
Cohesion: 0.39
Nodes (6): Feature, NoneFeatureConfiguration, BeehiveFeature, Codec, FeaturePlaceContext, Override

### Community 147 - "ConfigCondition"
Cohesion: 0.39
Nodes (6): ICondition, IContext, ConfigCondition, BooleanSupplier, MapCodec, Override

### Community 148 - "ModCreativeTabs.java"
Cohesion: 0.28
Nodes (6): ItemDisplayParameters, BooleanSupplier, DeferredHolder, DeferredRegister, ModCreativeTabs, Output

### Community 149 - "ChairSeatEntity.java"
Cohesion: 0.33
Nodes (6): BlockPos, Direction, EntityType, Level, LivingEntity, Vec3

### Community 150 - "Alchemy.md"
Cohesion: 0.22
Nodes (7): Advanced Alchemy ##, Automating Condensers ##, Basic Alchemy ##, Elixirs ##, Special Effects ##, Types ###, Herb Types ##

### Community 151 - "RusticDamage.java"
Cohesion: 0.39
Nodes (5): DamageSource, DamageType, Level, ResourceKey, RusticDamage

### Community 152 - "Flujo de trabajo — Rustic Hearth (NeoForge)"
Cohesion: 0.25
Nodes (7): Convenciones, ramas, versionado, commits, Específico del mod, Flujo de trabajo — Rustic Hearth (NeoForge), Flujo por tarea, Idioma, Qué es, Restricciones activas (viajan con cualquier delegación a OpenCode)

### Community 153 - "CondenserRecipeInput"
Cohesion: 0.48
Nodes (4): CondenserRecipeInput, FluidStack, ItemStack, Override

### Community 154 - "RusticSaplingBlock"
Cohesion: 0.39
Nodes (5): SaplingBlock, MapCodec, Override, TreeGrower, RusticSaplingBlock

### Community 155 - "RusticAdvancementProvider.java"
Cohesion: 0.43
Nodes (5): AdvancementProvider, ExistingFileHelper, PackOutput, Provider, RusticAdvancementProvider

### Community 156 - "RusticWorldGenProvider.java"
Cohesion: 0.21
Nodes (9): DatapackBuiltinEntriesProvider, GatherDataEvent, RegistrySetBuilder, DataGenerators, EventBusSubscriber, SubscribeEvent, PackOutput, Provider (+1 more)

### Community 157 - "Proyecto"
Cohesion: 0.29
Nodes (6): Alternativas de summary, CurseForge — Variables del proyecto, Dependencias opcionales, Pendiente antes de subir, Proyecto, Summary (campo *Summary*, editable en la web; límite 200)

### Community 159 - "ErisNameFormat.java"
Cohesion: 0.38
Nodes (4): NameFormat, ErisNameFormat, EventBusSubscriber, SubscribeEvent

### Community 161 - "Bees.md"
Cohesion: 0.29
Nodes (4): Apiaries ##, Beehives ##, Variants ##, Items ##

### Community 162 - "Plan — Rustic Hearth (fork de Rustic Revived)"
Cohesion: 0.33
Nodes (5): Compat opcional (supuesto, reversible), Fases, Identidad (decidido 2026-10-15), Plan — Rustic Hearth (fork de Rustic Revived), Riesgos

### Community 164 - "RusticLanguageProvider.java"
Cohesion: 0.47
Nodes (3): LanguageProvider, PackOutput, RusticLanguageProvider

### Community 165 - "ModEntities.java"
Cohesion: 0.53
Nodes (4): DeferredHolder, DeferredRegister, EntityType, ModEntities

### Community 166 - "Rustic Hearth #"
Cohesion: 0.33
Nodes (6): Bug Reporting ##, Credits ##, Downloads ##, Features ##, Mod Compatibility ##, Rustic Hearth #

### Community 167 - "Rustic Hearth — Logo de CurseForge"
Cohesion: 0.40
Nodes (4): Después de generarla, Por qué cada elemento está pedido, Prompt, Rustic Hearth — Logo de CurseForge

### Community 168 - "rename_from_revived.py"
Cohesion: 0.60
Nodes (4): convert_text(), main(), Copies the Rustic Revived snapshot (temp/original) into a target project and ren, rename_path()

### Community 169 - "rename_to_rustic_hearth.py"
Cohesion: 0.60
Nodes (4): convert_text(), main(), new_name(), Renames the project in place from Cottagecraft to Rustic Hearth (text content, t

### Community 170 - "ModBanners.java"
Cohesion: 0.60
Nodes (3): BannerPattern, ResourceKey, ModBanners

### Community 171 - "gradlew"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 172 - "Rustic Hearth"
Cohesion: 0.50
Nodes (3): Origin, Requirements, Rustic Hearth

## Knowledge Gaps
- **122 isolated node(s):** `OAK`, `SPRUCE`, `BIRCH`, `JUNGLE`, `ACACIA` (+117 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **10 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `ModBlocks` connect `ModBlocks.java` to `HerbBlock`, `RusticChainBlock`, `EvaporatingBasinBlock.java`, `GrapeLeavesBlock`, `RopeBaseBlock`, `HorizontalDirectionalBlock`, `StakeCropBlock`, `StakeTiedBlock`, `ModTags.java`, `MountedLightBlock`, `DoubleCandleBlock.java`, `CandleLeverBlock`, `LatticeBlock`, `RusticSaplingBlock`, `AppleLeavesBlock`, `RetortBlock.java`, `CabinetBlock`, `GrapeStemBlock`, `BrewingBarrelBlock.java`, `TableBlock`, `VaseBlock.java`, `Block`, `WoodVariant`, `ApiaryBlock.java`, `EntityBlock`, `ChairBlock.java`, `.render`, `RusticBarrelBlock.java`, `FertileSoilBlock.java`, `AdvancedCondenserBlock`, `CondenserBlock`, `IronTorchBlock`?**
  _High betweenness centrality (0.043) - this node is a cross-community bridge._
- **Why does `CabinetBlock` connect `CabinetBlock` to `ModBlocks.java`, `RusticBarrelBlock.java`, `HorizontalDirectionalBlock`, `.init`, `CabinetBlock.java`, `CabinetBlockEntity`, `CabinetRenderer.java`?**
  _High betweenness centrality (0.039) - this node is a cross-community bridge._
- **Why does `AbstractCondenserBlockEntity` connect `AbstractCondenserBlockEntity` to `AbstractCondenserMenu`, `CondenserRecipe`, `AdvancedCondenserBlock`, `CondenserBlock`, `AbstractCondenserBlock`, `AutomationHandler`, `AdvancedCondenserBlockEntity`, `RusticJeiPlugin.java`, `AdvancedCondenserMenu.java`, `SyncedBlockEntity`, `AlchemySetup.java`, `StorageBlockEntity`?**
  _High betweenness centrality (0.034) - this node is a cross-community bridge._
- **What connects `Project root = two levels above this file (docs/tools/check_template_ids.py).`, `Every name the new mod registers, from assets, lang keys and Java code.`, `Return (status, targets) for one `rustic:<name>` id.` to the rest of the system?**
  _127 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `HerbBlock` be split into smaller, more focused modules?**
  _Cohesion score 0.052360338074623786 - nodes in this community are weakly interconnected._
- **Should `BrewingBarrelBlockEntity` be split into smaller, more focused modules?**
  _Cohesion score 0.05030525030525031 - nodes in this community are weakly interconnected._
- **Should `FarmData.java` be split into smaller, more focused modules?**
  _Cohesion score 0.08635703918722787 - nodes in this community are weakly interconnected._