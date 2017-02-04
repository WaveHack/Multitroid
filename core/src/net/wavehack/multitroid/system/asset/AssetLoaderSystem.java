package net.wavehack.multitroid.system.asset;

import net.wavehack.multitroid.system.InitSystem;

public class AssetLoaderSystem extends InitSystem {

    private AssetSystem assetSystem;

    @Override
    protected void init() {
        this.assetSystem
            .loadTextureAtlas("sprites.txt")
//            .sprite("elisa", "temp/elisa-spritesheet1.png", 4, 4, 54, 54, 0x57542b)
        ;

        this.assetSystem.assetManager.finishLoading();
    }

}
