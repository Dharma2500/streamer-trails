import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;

        for (PlayerEntity player : mc.level.players()) {

            if (!player.isAlive()) continue;

            float size = 1.0F; // обычный размер

            // Проверка на твой ник
            if (player.getName().getString().equals("Vitaly_Sokolov")) {
                size = 1.6F; // твой след больше
            }

            mc.level.addParticle(
                    new RedstoneParticleData(0.8F, 0.0F, 1.0F, size), // пурпур
                    player.getX(),
                    player.getY() + 0.1,
                    player.getZ(),
                    0, 0, 0
            );
        }
    }
}
