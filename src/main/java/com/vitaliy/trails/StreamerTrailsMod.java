package com.vitaliy.trails;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

@Mod("streamertrails")
public class StreamerTrailsMod {

    public StreamerTrailsMod() {

        ModLoadingContext.get().registerConfig(
                ModConfig.Type.CLIENT,
                ModConfigHolder.SPEC
        );
    }
}
