package thund.learningbtw.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import thund.learningbtw.LearningBtw;
import thund.learningbtw.ShadowCenter;



public class PlayerEvents implements Listener {
    public static HashMap<Player, Integer> playerMap = new HashMap<>(); //integer - шанс спавна тени
    public final Set<Player> cooldownPlayer = new HashSet<>();
    public final int cooldownTime = 100;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerMap.put(player, 0);
    }

    @EventHandler
    public void onDMGOtherEntity(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player player && playerMap.containsKey(player)) {
            if (cooldownPlayer.contains(player)) return;

            playerMap.compute(player, (k, spawnChance) -> spawnChance + 1);

            new ShadowCenter().spawnBehindPlayer(player);

            cooldownPlayer.add(player);

            new BukkitRunnable(){
                @Override
                public void run(){

                    cooldownPlayer.remove(player);

                }
            }.runTaskLater(LearningBtw.getInstance(),cooldownTime);

        }
    }
}