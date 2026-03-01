package com.vitaliy.trails;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRenderWorld(RenderWorldLastEvent event) {

        Minecraft mc = Minecraft.getInstance();

        if (mc.player == null || mc.level == null) return;

        for (PlayerEntity player : mc.level.players()) {

            // Только если игрок движется
            if (player.getDeltaMovement().lengthSqr() < 0.001) continue;

            double x = player.getX();
            double y = player.getY() + 0.1;
            double z = player.getZ();

            // Определяем ширину
            boolean isVitaly = player.getName().getString().equalsIgnoreCase("Vitaly_Sokolov");

            double spread = isVitaly ? 0.2 : 0.1;

            // Пурпурные частицы
            mc.level.addParticle(
                    ParticleTypes.PORTAL,
                    x + (mc.level.random.nextDouble() - 0.5) * spread,
                    y,
                    z + (mc.level.random.nextDouble() - 0.5) * spread,
                    0,
                    0.01,
                    0
            );
        }
    }
}
