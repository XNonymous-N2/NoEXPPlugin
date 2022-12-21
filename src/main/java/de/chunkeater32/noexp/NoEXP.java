package de.chunkeater32.noexp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoEXP extends JavaPlugin implements Listener {

    private boolean noxp = true;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("exptoggle").setExecutor((sender, command, label, args) -> {
            noxp = !noxp;

            if (noxp)
                sender.sendMessage("EXP drops are now disabled.");
            else
                sender.sendMessage("EXP drops are now enabled.");

            return false;
        });
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (!noxp)
            return;

        LivingEntity entity = event.getEntity();

        if (!(entity instanceof Animals) && !(entity instanceof Monster))
            return;

        event.setDroppedExp(0);
    }

}
