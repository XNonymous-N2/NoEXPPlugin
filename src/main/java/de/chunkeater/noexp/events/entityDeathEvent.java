package de.chunkeater.noexp.events;

import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static de.chunkeater.noexp.main.noxp;

public class entityDeathEvent implements Listener {


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
