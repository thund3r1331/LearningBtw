package thund.learningbtw.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class PlayerEvents implements Listener {
    public static HashMap<Player, Integer> playerMap = new HashMap<>(); //integer - шанс спавна тени

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerMap.put(player, 0);
    }

    @EventHandler
    public void onDMGOtherEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player && playerMap.containsKey(player)) {
            playerMap.compute(player, (k, spawnChance) -> spawnChance + 1);
        }
    }
}