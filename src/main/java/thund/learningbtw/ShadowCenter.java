package thund.learningbtw;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
public class ShadowCenter implements Listener {
    public void spawnBehindPlayer(Player player) {
        Vector vector = player.getLocation().getDirection().normalize().multiply(-5);
        Location locationBehind = player.getLocation().add(vector);

        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(locationBehind, EntityType.ARMOR_STAND);

        //        armorStand.setGravity(true);
        armorStand.setCustomName("Shadow");

    }
}



