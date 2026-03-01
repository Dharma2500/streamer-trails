import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SubscribeEvent
public static void onClientTick(TickEvent.ClientTickEvent event) {

    if (event.phase != TickEvent.Phase.END) return;

    Minecraft mc = Minecraft.getInstance();
    if (mc.level == null) return;

    for (PlayerEntity player : mc.level.players()) {

        if (!player.isAlive()) continue;

        // Проверяем движение
        if (player.getDeltaMovement().lengthSqr() < 0.001) continue;

        float size = 1.0F;

        if (player.getName().getString().equals("Vitaly_Sokolov")) {
            size = 1.8F;
        }

        float r = ModConfig.RED.get().floatValue();
        float g = ModConfig.GREEN.get().floatValue();
        float b = ModConfig.BLUE.get().floatValue();

        // Создаем красивый шлейф из нескольких частиц
        for (int i = 0; i < 4; i++) {

            double offsetX = (mc.level.random.nextDouble() - 0.5) * 0.4;
            double offsetZ = (mc.level.random.nextDouble() - 0.5) * 0.4;

            mc.level.addParticle(
                    new RedstoneParticleData(r, g, b, size),
                    player.getX() + offsetX,
                    player.getY() + 0.1,
                    player.getZ() + offsetZ,
                    0, 0, 0
            );
        }
    }
}

