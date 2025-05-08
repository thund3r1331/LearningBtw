package thund.learningbtw.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import thund.learningbtw.LearningBtw;
import thund.learningbtw.ShadowCenter;



public class PlayerEvents implements Listener {
    public static HashMap<Player, Integer> playerMap = new HashMap<>(); //integer - шанс спавна тени
    public final int cooldownTime = 600 * 20;
    private final int maxChance = 100;

    Random random = new Random();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        playerMap.put(player, 0);
    }

    @EventHandler
    public void onDMGOtherEntity(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player player && playerMap.containsKey(player)) {
            playerMap.compute(player, (k, spawnChance) ->
                    Math.min((spawnChance == null ? 0 : spawnChance) + 1, maxChance));

            int currentChance = playerMap.get(player);
            if (shouldSpawnShadow(currentChance)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {

                        new ShadowCenter().spawnBehindPlayer(player);
                        playerMap.put(player, 0);

                    }
                }.runTaskLater(LearningBtw.getInstance(), cooldownTime);
            }
        }
    }
    private boolean shouldSpawnShadow(int chance) {
        return random.nextInt(100) < chance;
    }
}