package thund.learningbtw;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import thund.learningbtw.listeners.PlayerEvents;

public final class LearningBtw extends JavaPlugin {
    private static LearningBtw instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);

    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}