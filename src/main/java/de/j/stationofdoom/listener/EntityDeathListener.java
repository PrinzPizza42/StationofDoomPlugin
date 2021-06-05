package de.j.stationofdoom.listener;

import de.j.stationofdoom.util.ItemBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import java.util.Objects;
import java.util.Random;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent event){
        switch (event.getEntity().getType()){
           case PIG :
               if (drop(100)) {
                   Objects.requireNonNull(event.getEntity().getLocation().getWorld()).dropItem(event.getEntity().getLocation(), Objects.requireNonNull(ItemBuilder.getHead("pig")));
               }
               break;
            case CHICKEN:
                if (drop(101)) {
                    Objects.requireNonNull(event.getEntity().getLocation().getWorld()).dropItem(event.getEntity().getLocation(), Objects.requireNonNull(ItemBuilder.getHead("chicken")));
                }
                break;
            case BEE:
                if (drop(2)) {
                    Objects.requireNonNull(event.getEntity().getLocation().getWorld()).dropItem(event.getEntity().getLocation(), Objects.requireNonNull(ItemBuilder.getHead("bee")));
                }
        }
    }

    private boolean drop(int bound){
        if (new Random().nextInt(bound) == 1){
            return true;
        } else {
            return false;
        }
    }
}
