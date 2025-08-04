package ifly.imperialroma.harvestmaster.events;

import com.liba.utils.Debug;
import ifly.imperialroma.harvestmaster.HarvestMaster;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class HarvestEvent implements Listener {

    @EventHandler
    public void click(PlayerInteractEvent e){

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block block = e.getClickedBlock();


            if (block != null && block.getType().name().endsWith("_STEM")) {
                return;
            }
            if (block != null && block.getBlockData() instanceof Ageable ageable) {
                if (ageable.getAge() == ageable.getMaximumAge()) {
                    for(ItemStack itemStack : block.getDrops()){
                        block.getWorld().dropItem(block.getLocation().clone().add(0.5,0.5,0.5), itemStack);
                    }
                    int exp = (int) HarvestMaster.getInstance().getStorage().getInt("expcount");
                    if (exp > 0){
                        ExperienceOrb orb = block.getLocation().getWorld().spawn(block.getLocation().add(0.5, 0.5, 0.5), ExperienceOrb.class);
                        orb.setExperience(new Random().nextInt(exp));
                    }

                    ageable.setAge(0);
                    block.setBlockData(ageable);
                }

            }
        }
    }


}
