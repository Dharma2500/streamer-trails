package com.vitaliy.trails;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigHolder {

    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Double> RED;
    public static final ForgeConfigSpec.ConfigValue<Double> GREEN;
    public static final ForgeConfigSpec.ConfigValue<Double> BLUE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("Trail Color");

        RED = builder.define("red", 0.8D);
        GREEN = builder.define("green", 0.0D);
        BLUE = builder.define("blue", 1.0D);

        builder.pop();

        SPEC = builder.build();
    }
}
