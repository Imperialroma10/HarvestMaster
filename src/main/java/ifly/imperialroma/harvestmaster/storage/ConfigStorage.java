package ifly.imperialroma.harvestmaster.storage;

import com.liba.utils.file.FileChecker;

public class ConfigStorage extends FileChecker {
    public ConfigStorage(String filedir) {
        super(filedir);
    }

    @Override
    public void needle() {
        addParam("expcount", 3, "Experience value that is given to the player (random from 0 to 3), zero to disable give exp");
    }
}
