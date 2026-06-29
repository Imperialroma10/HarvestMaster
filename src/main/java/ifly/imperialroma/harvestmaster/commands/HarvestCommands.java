package ifly.imperialroma.harvestmaster.commands;

import com.liba.utils.player.PlayerUtils;
import ifly.imperialroma.harvestmaster.HarvestMaster;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HarvestCommands implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("harvestmaster")) {
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("reload")){
                    HarvestMaster.getInstance().reload();
                    if (cs instanceof Player player){
                        PlayerUtils.sendMessage(player.getUniqueId(), HarvestMaster.getInstance().getStorage().getString("message.reload"));
                    }else{
                        cs.sendMessage(HarvestMaster.getInstance().getStorage().getString("message.reload"));
                    }

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmd, String s, String[] args) {
        List<String> completions = new ArrayList<>();

        if (cmd.getName().equalsIgnoreCase("harvestmaster")) {
            if (args.length == 1) {
                    completions.add("reload");

            }
        }

        return completions;
    }
}
