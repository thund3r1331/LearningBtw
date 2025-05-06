package thund.learningbtw;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class SummonShadow implements Listener {
    public void spawnBehindPlayer(Player player) {
        Vector vector = player.getLocation().getDirection().normalize().multiply(-5);
        Location locationBehind = player.getLocation().add(vector);

        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(locationBehind, EntityType.ARMOR_STAND);

        armorStand.setGravity(false);
        armorStand.setCustomName("Shadow");

    }
}

