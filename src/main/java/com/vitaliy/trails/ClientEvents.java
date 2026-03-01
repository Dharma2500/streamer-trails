package com.vitaliy.trails;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "streamertrails", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;

        for (PlayerEntity player : mc.level.players()) {

    if (!PlayerTracker.hasMod(player.getUUID())) continue; {

            if (!player.isAlive()) continue;
if (player.getUUID().equals(mc.player.getUUID())) {
    // ты всегда видишь себя
}
            // Проверяем горизонтальное движение
            double motionX = player.getDeltaMovement().x;
            double motionZ = player.getDeltaMovement().z;

            double horizontalSpeed = motionX * motionX + motionZ * motionZ;

            // Если почти не движется — пропускаем
            if (horizontalSpeed < 0.0005) continue;

            float size = 1.0F;
            double spread = 0.2; // В 2 раза уже (было 0.4)

            // Твой ник — шире и больше
            if (player.getName().getString().equals("Vitaly_Sokolov")) {
                size = 1.8F;
                spread = 0.35; // шире остальных
            }

            float r = ModConfigHolder.RED.get().floatValue();
            float g = ModConfigHolder.GREEN.get().floatValue();
            float b = ModConfigHolder.BLUE.get().floatValue();

            for (int i = 0; i < 3; i++) {

                double offsetX = (mc.level.random.nextDouble() - 0.5) * spread;
                double offsetZ = (mc.level.random.nextDouble() - 0.5) * spread;

                mc.level.addParticle(
                        new RedstoneParticleData(r, g, b, size),
                        player.getX() + offsetX,
                        player.getY() + 0.05,
                        player.getZ() + offsetZ,
                        0, 0, 0
                );
            }
        }
    }
}

