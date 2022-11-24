package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.item.DaggerItem;
import com.finallion.graveyard.item.SarcophagusItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TGItems {
    public static final Item SARCOPHAGUS_LID = new Item(new FabricItemSettings());
    public static final Item SARCOPHAGUS_BASE = new Item(new FabricItemSettings());
    public static final Item DARK_OAK_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item DARK_OAK_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item OAK_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item OAK_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item BIRCH_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item BIRCH_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item JUNGLE_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item JUNGLE_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item ACACIA_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item ACACIA_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item SPRUCE_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item SPRUCE_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item WARPED_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item WARPED_COFFIN_BASE = new Item(new FabricItemSettings());
    public static final Item CRIMSON_COFFIN_LID = new Item(new FabricItemSettings());
    public static final Item CRIMSON_COFFIN_BASE = new Item(new FabricItemSettings());

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_deepslate"), new BlockItem(TGBlocks.TG_DEEPSLATE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_grass_block"), new BlockItem(TGBlocks.TG_GRASS_BLOCK, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_moss_block"), new BlockItem(TGBlocks.TG_MOSS_BLOCK, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_stone"), new BlockItem(TGBlocks.TG_STONE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_andesite"), new BlockItem(TGBlocks.TG_ANDESITE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_granite"), new BlockItem(TGBlocks.TG_GRANITE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_diorite"), new BlockItem(TGBlocks.TG_DIORITE, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_tuff"), new BlockItem(TGBlocks.TG_TUFF, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_dirt"), new BlockItem(TGBlocks.TG_DIRT, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_coarse_dirt"), new BlockItem(TGBlocks.TG_COARSE_DIRT, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_rooted_dirt"), new BlockItem(TGBlocks.TG_ROOTED_DIRT, new FabricItemSettings()));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "tg_podzol"), new BlockItem(TGBlocks.TG_PODZOL, new FabricItemSettings()));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "corruption"), new Item(new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_iron_block"), new BlockItem(TGBlocks.DARK_IRON_BLOCK, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_iron_ingot"), new Item(new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_iron_door"), new BlockItem(TGBlocks.DARK_IRON_DOOR, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_iron_trapdoor"), new BlockItem(TGBlocks.DARK_IRON_TRAPDOOR, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_iron_bars"), new BlockItem(TGBlocks.DARK_IRON_BARS, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "soul_fire_brazier"), new BlockItem(TGBlocks.SOUL_FIRE_BRAZIER, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "fire_brazier"), new BlockItem(TGBlocks.FIRE_BRAZIER, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "pedestal"), new BlockItem(TGBlocks.PEDESTAL, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "candle_holder"), new BlockItem(TGBlocks.CANDLE_HOLDER, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "gravestone"), new BlockItem(TGBlocks.GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "cobblestone_gravestone"), new BlockItem(TGBlocks.COBBLESTONE_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "mossy_cobblestone_gravestone"), new BlockItem(TGBlocks.MOSSY_COBBLESTONE_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "deepslate_gravestone"), new BlockItem(TGBlocks.DEEPSLATE_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "blackstone_gravestone"), new BlockItem(TGBlocks.BLACKSTONE_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "cracked_blackstone_gravestone"), new BlockItem(TGBlocks.CRACKED_BLACKSTONE_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "stone_bricks_gravestone"), new BlockItem(TGBlocks.STONE_BRICKS_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "mossy_stone_bricks_gravestone"), new BlockItem(TGBlocks.MOSSY_STONE_BRICKS_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "bricks_gravestone"), new BlockItem(TGBlocks.BRICKS_GRAVESTONE, new FabricItemSettings().group(TheGraveyard.GROUP)));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "skull_with_rib_cage"), new BlockItem(TGBlocks.SKULL_WITH_RIB_CAGE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "leaning_skeleton"), new BlockItem(TGBlocks.LEANING_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "skull_pile"), new BlockItem(TGBlocks.SKULL_PILE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "lying_skeleton"), new BlockItem(TGBlocks.LYING_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_skull_with_rib_cage"), new BlockItem(TGBlocks.WITHER_SKULL_WITH_RIB_CAGE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "leaning_wither_skeleton"), new BlockItem(TGBlocks.LEANING_WITHER_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_skull_pile"), new BlockItem(TGBlocks.WITHER_SKULL_PILE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "lying_wither_skeleton"), new BlockItem(TGBlocks.LYING_WITHER_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "creeper_skeleton"), new BlockItem(TGBlocks.CREEPER_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "skeleton_hand"), new BlockItem(TGBlocks.SKELETON_HAND, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_skeleton_hand"), new BlockItem(TGBlocks.WITHER_SKELETON_HAND, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "torso_pile"), new BlockItem(TGBlocks.TORSO_PILE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_torso_pile"), new BlockItem(TGBlocks.WITHER_TORSO_PILE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "skull_on_pike"), new BlockItem(TGBlocks.SKULL_ON_PIKE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_skull_on_pike"), new BlockItem(TGBlocks.WITHER_SKULL_ON_PIKE, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "bone_remains"), new BlockItem(TGBlocks.BONE_REMAINS, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wither_bone_remains"), new BlockItem(TGBlocks.WITHER_BONE_REMAINS, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "laterally_lying_skeleton"), new BlockItem(TGBlocks.LATERALLY_LYING_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "laterally_lying_wither_skeleton"), new BlockItem(TGBlocks.LATERALLY_LYING_WITHER_SKELETON, new FabricItemSettings().group(TheGraveyard.GROUP)));


        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "black_urn"), new BlockItem(TGBlocks.BLACK_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "gray_urn"), new BlockItem(TGBlocks.GRAY_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "light_gray_urn"), new BlockItem(TGBlocks.LIGHT_GRAY_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "white_urn"), new BlockItem(TGBlocks.WHITE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "light_blue_urn"), new BlockItem(TGBlocks.LIGHT_BLUE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "blue_urn"), new BlockItem(TGBlocks.BLUE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "cyan_urn"), new BlockItem(TGBlocks.CYAN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "green_urn"), new BlockItem(TGBlocks.GREEN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "lime_urn"), new BlockItem(TGBlocks.LIME_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "pink_urn"), new BlockItem(TGBlocks.PINK_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "magenta_urn"), new BlockItem(TGBlocks.MAGENTA_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "purple_urn"), new BlockItem(TGBlocks.PURPLE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "red_urn"), new BlockItem(TGBlocks.RED_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "orange_urn"), new BlockItem(TGBlocks.ORANGE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "yellow_urn"), new BlockItem(TGBlocks.YELLOW_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "brown_urn"), new BlockItem(TGBlocks.BROWN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));


        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_black_urn"), new BlockItem(TGBlocks.SMALL_BLACK_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_gray_urn"), new BlockItem(TGBlocks.SMALL_GRAY_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_light_gray_urn"), new BlockItem(TGBlocks.SMALL_LIGHT_GRAY_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_white_urn"), new BlockItem(TGBlocks.SMALL_WHITE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_light_blue_urn"), new BlockItem(TGBlocks.SMALL_LIGHT_BLUE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_blue_urn"), new BlockItem(TGBlocks.SMALL_BLUE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_cyan_urn"), new BlockItem(TGBlocks.SMALL_CYAN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_green_urn"), new BlockItem(TGBlocks.SMALL_GREEN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_lime_urn"), new BlockItem(TGBlocks.SMALL_LIME_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_pink_urn"), new BlockItem(TGBlocks.SMALL_PINK_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_magenta_urn"), new BlockItem(TGBlocks.SMALL_MAGENTA_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_purple_urn"), new BlockItem(TGBlocks.SMALL_PURPLE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_red_urn"), new BlockItem(TGBlocks.SMALL_RED_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_orange_urn"), new BlockItem(TGBlocks.SMALL_ORANGE_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_yellow_urn"), new BlockItem(TGBlocks.SMALL_YELLOW_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "small_brown_urn"), new BlockItem(TGBlocks.SMALL_BROWN_URN, new FabricItemSettings().group(TheGraveyard.GROUP)));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "vase_block"), new BlockItem(TGBlocks.VASE_BLOCK, new FabricItemSettings().group(TheGraveyard.GROUP)));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "sarcophagus"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.SARCOPHAGUS));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "oak_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.OAK_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_oak_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.DARK_OAK_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "spruce_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.SPRUCE_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "birch_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.BIRCH_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "jungle_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.JUNGLE_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "acacia_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.ACACIA_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "warped_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.WARPED_COFFIN));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "crimson_coffin"), new SarcophagusItem(new FabricItemSettings().group(TheGraveyard.GROUP), TGBlocks.CRIMSON_COFFIN));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "skeleton_creeper_spawn_egg"), new SpawnEggItem(TGEntities.SKELETON_CREEPER, 7960171, 15263976, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "acolyte_spawn_egg"), new SpawnEggItem(TGEntities.ACOLYTE, 2688830, 5898240, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "ghoul_spawn_egg"), new SpawnEggItem(TGEntities.GHOUL, 6239802, 16487198, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "reaper_spawn_egg"), new SpawnEggItem(TGEntities.REAPER, 1381653, 7456477, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "revenant_spawn_egg"), new SpawnEggItem(TGEntities.REVENANT, 12965589, 9765908, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "nightmare_spawn_egg"), new SpawnEggItem(TGEntities.NIGHTMARE, 592137, 4718849, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "corrupted_vindicator_spawn_egg"), new SpawnEggItem(TGEntities.CORRUPTED_VINDICATOR, 7567737, 2380632, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "corrupted_pillager_spawn_egg"), new SpawnEggItem(TGEntities.CORRUPTED_PILLAGER, 7567737, 4924973, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "wraith_spawn_egg"), new SpawnEggItem(TGEntities.WRAITH, 1644568, 16777215, new FabricItemSettings().group(TheGraveyard.GROUP)));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "bone_dagger"), new DaggerItem(ToolMaterials.STONE, 4.0F, 1.0F, new Item.Settings().group(TheGraveyard.GROUP).maxCount(1)));

        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "sarcophagus_lid"), SARCOPHAGUS_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "sarcophagus_base"), SARCOPHAGUS_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_oak_coffin_lid"), DARK_OAK_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "dark_oak_coffin_base"), DARK_OAK_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "oak_coffin_lid"), OAK_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "oak_coffin_base"), OAK_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "birch_coffin_lid"), BIRCH_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "birch_coffin_base"), BIRCH_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "jungle_coffin_lid"), JUNGLE_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "jungle_coffin_base"), JUNGLE_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "acacia_coffin_lid"), ACACIA_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "acacia_coffin_base"), ACACIA_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "spruce_coffin_lid"), SPRUCE_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "spruce_coffin_base"), SPRUCE_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "warped_coffin_lid"), WARPED_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "warped_coffin_base"), WARPED_COFFIN_BASE);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "crimson_coffin_lid"), CRIMSON_COFFIN_LID);
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "crimson_coffin_base"), CRIMSON_COFFIN_BASE);


        /*
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "rotten_spruce_planks"), new BlockItem(TGBlocks.ROTTEN_SPRUCE_PLANKS, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "rotten_spruce_stairs"), new BlockItem(TGBlocks.ROTTEN_SPRUCE_STAIRS, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "rotten_spruce_slab"), new BlockItem(TGBlocks.ROTTEN_SPRUCE_SLAB, new FabricItemSettings().group(TheGraveyard.GROUP)));
        Registry.register(Registry.ITEM, new Identifier(TheGraveyard.MOD_ID, "rotten_spruce_log"), new BlockItem(TGBlocks.ROTTEN_SPRUCE_LOG, new FabricItemSettings().group(TheGraveyard.GROUP)));
         */
    }


}
