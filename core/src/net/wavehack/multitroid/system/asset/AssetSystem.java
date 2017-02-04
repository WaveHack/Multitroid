package net.wavehack.multitroid.system.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import net.wavehack.multitroid.system.PassiveSystem;

public class AssetSystem extends PassiveSystem {

    public AssetManager assetManager = new AssetManager();

    public AssetSystem loadTextureAtlas(String name) {
        this.assetManager.load(name, TextureAtlas.class);
        return this;
    }

    public TextureAtlas getTextureAtlas(String name) {
        return this.assetManager.get(name, TextureAtlas.class);
    }

}
