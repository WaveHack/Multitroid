package net.wavehack.multitroid.system.asset;

import net.wavehack.multitroid.system.InitSystem;

public class AssetLoaderSystem extends InitSystem {

    private AssetSystem assetSystem;

    @Override
    protected void init() {
        this.assetSystem
            .loadTextureAtlas("sprites.txt")
        ;

        this.assetSystem.assetManager.finishLoading();
    }

}
