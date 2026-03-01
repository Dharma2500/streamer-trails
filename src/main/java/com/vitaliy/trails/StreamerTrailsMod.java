package com.vitaliy.trails;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.ModLoadingContext;

ModLoadingContext.get().registerConfig(
        net.minecraftforge.fml.config.ModConfig.Type.CLIENT,
        твой_пакет.ModConfig.SPEC
);
@Mod("streamertrails")
public class StreamerTrailsMod {

}
