package ifly.imperialroma.harvestmaster;

import com.liba.Liba;
import com.liba.utils.Debug;
import ifly.imperialroma.harvestmaster.events.HarvestEvent;
import ifly.imperialroma.harvestmaster.storage.ConfigStorage;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class HarvestMaster extends JavaPlugin {

    static HarvestMaster plugin;
    ConfigStorage storage;

    @Override
    public void onEnable() {
        plugin = this;
        Liba liba = new Liba(this);
        storage = new ConfigStorage(this.getDataFolder()+ File.separator+"config.yml");
        storage.checkStorage();

        liba.registerMetrica(24123);
        Debug.setDebug(false);

        getServer().getPluginManager().registerEvents(new HarvestEvent(), this);
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
}
