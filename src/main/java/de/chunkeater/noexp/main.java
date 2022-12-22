package de.chunkeater.noexp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import de.chunkeater.noexp.events.entityDeathEvent;

public final class main extends JavaPlugin  {


    public static boolean noxp = true;
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new entityDeathEvent(), this);

        getCommand("exptoggle").setExecutor((sender, command, label, args) -> {
            noxp = !noxp;

            if (noxp)
                sender.sendMessage("EXP drops are now disabled.");
            else
                sender.sendMessage("EXP drops are now enabled.");

            return false;
        });
    }



}
