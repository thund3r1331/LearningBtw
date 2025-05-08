package thund.learningbtw;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;

public class CheckShadowPos {
    public void checkOnGround(ArmorStand armorStand) {
        if (!armorStand.isOnGround()) return;
    }
}