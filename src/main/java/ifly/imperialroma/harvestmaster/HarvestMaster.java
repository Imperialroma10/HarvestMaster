package ifly.imperialroma.harvestmaster;

import com.liba.Liba;
import com.liba.inject.InjectPlugin;
import com.liba.utils.Debug;
import ifly.imperialroma.harvestmaster.commands.HarvestCommands;
import ifly.imperialroma.harvestmaster.events.HarvestEvent;
import ifly.imperialroma.harvestmaster.storage.ConfigStorage;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class HarvestMaster extends JavaPlugin {

    static HarvestMaster plugin;
    ConfigStorage storage;
    List<String> block_type = new ArrayList<>();
    @Override
    public void onEnable() {
        plugin = this;
        Liba liba = new Liba(this);
        storage = new ConfigStorage(this.getDataFolder()+ File.separator+"config.yml");
        storage.checkStorage();
        block_type = storage.getStringOrList("block_list");
        liba.registerMetrica(24123);
        liba.registerVersionChecker(11, "https://www.curseforge.com/minecraft/bukkit-plugins/harvestmaster");
        Debug.setDebug(false);

        getServer().getPluginManager().registerEvents(new HarvestEvent(), this);
        getServer().getPluginCommand("harvestmaster").setExecutor(new HarvestCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static HarvestMaster getInstance() {
        return plugin;
    }

    public ConfigStorage getStorage() {
        return storage;
    }

    public void reload(){
        storage.reload();
        block_type = storage.getStringOrList("block_list");

    }

    public List<String> getBlock_type() {
        return block_type;
    }
}
