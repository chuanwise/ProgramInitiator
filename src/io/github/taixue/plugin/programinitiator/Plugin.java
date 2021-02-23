package io.github.taixue.plugin.programinitiator;

import io.github.taixue.plugin.programinitiator.commandexecutor.ProgramInitiator;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("ProgramInitiator");
        if (!getDataFolder().exists() && !getDataFolder().mkdirs()) {
            getLogger().severe("Can not create " + getDataFolder().getAbsolutePath());
        }
        getCommand("programinitiator").setExecutor(new ProgramInitiator(getDataFolder(), getLogger()));
    }
}
