package ifly.imperialroma.harvestmaster.storage;

import com.liba.utils.file.FileChecker;

import java.util.ArrayList;
import java.util.List;

public class ConfigStorage extends FileChecker {
    public ConfigStorage(String filedir) {
        super(filedir);
    }

    @Override
    public void needle() {
        addParam("expcount", 3, "Experience value that is given to the player (random from 0 to 3), zero to disable give exp");

        addParam("block_list", new ArrayList<>(List.of("wildflowers")), "Here you need to enter the name of the type (NOT SEED) and the plant. You can view it by pressing F3.");

        addParam("message.reload", "&aPlugin reloaded");

    }
}
