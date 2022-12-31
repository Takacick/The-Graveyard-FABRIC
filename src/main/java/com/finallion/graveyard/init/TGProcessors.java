package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.world.processors.RemoveWaterloggedCryptProcessor;
import com.finallion.graveyard.world.processors.RemoveWaterloggedProcessor;
import com.finallion.graveyard.world.processors.SwitchSpawnerProcessor;
import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;

public class TGProcessors {

    // Processor uses:
    // Haunted House
    // Small Crypt
    // Wither Skeleton Mill

    public static StructureProcessorType<RemoveWaterloggedProcessor> REMOVE_WATERLOGGED = () -> RemoveWaterloggedProcessor.CODEC;
    public static StructureProcessorType<RemoveWaterloggedCryptProcessor> REMOVE_WATERLOGGED_CRYPT = () -> RemoveWaterloggedCryptProcessor.CODEC;
    public static StructureProcessorType<SwitchSpawnerProcessor> SWITCH_SPAWNER = () -> SwitchSpawnerProcessor.CODEC;

    /*
    public static final RegistryEntry<StructureProcessorList> WATERLOGGED_LIST = BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST,
            new Identifier(TheGraveyard.MOD_ID, "waterlogged_processor_list"),
            new StructureProcessorList(ImmutableList.of(new RemoveWaterloggedProcessor())));

    public static final RegistryEntry<StructureProcessorList> WATERLOGGED_CRYPT_LIST = BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST,
            new Identifier(TheGraveyard.MOD_ID, "waterlogged_crypt_processor_list"),
            new StructureProcessorList(ImmutableList.of(new RemoveWaterloggedCryptProcessor())));

    public static final RegistryEntry<StructureProcessorList> SWITCH_SPAWNER_LIST = BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST,
            new Identifier(TheGraveyard.MOD_ID, "switch_spawner_list"),
            new StructureProcessorList(ImmutableList.of(new SwitchSpawnerProcessor())));

     */


    public static void registerProcessors() {
        Registry.register(Registries.STRUCTURE_PROCESSOR, new Identifier(TheGraveyard.MOD_ID, "remove_waterlogged_processor"), REMOVE_WATERLOGGED);
        Registry.register(Registries.STRUCTURE_PROCESSOR, new Identifier(TheGraveyard.MOD_ID, "switch_spawner_processor"), SWITCH_SPAWNER);
        Registry.register(Registries.STRUCTURE_PROCESSOR, new Identifier(TheGraveyard.MOD_ID, "waterlogged_crypt_processor"), REMOVE_WATERLOGGED_CRYPT);
    }
}
