package unkw301.ClientCrashPacket;

import org.bukkit.event.*;
import org.bukkit.plugin.java.*;
import unkw301.ClientCrashPacket.commands.*;

/**
 * Leaked by FlatiCommunity (https://t.me/flaticommunity)
 */

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("crash").setExecutor(new CrashCommand());
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
