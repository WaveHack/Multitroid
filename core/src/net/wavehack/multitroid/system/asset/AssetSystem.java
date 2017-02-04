package net.wavehack.multitroid.system.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import net.wavehack.multitroid.system.PassiveSystem;

import java.util.HashMap;

public class AssetSystem extends PassiveSystem {

    public AssetManager assetManager = new AssetManager();

//    private HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();

//    public Sprite sprite(String name) {
//        return this.sprites.get(name);
//    }

//    public AssetSystem sprite(String name, String path, int x, int y, int width, int height) {
//        return this.sprite(name, path, x, y, width, height, 0);
//    }

//    public AssetSystem sprite(String name, String path, int x, int y, int width, int height, int backgroundColor) {
//        Texture texture = new Texture(Gdx.files.internal(path));
//        Sprite sprite = new Sprite(texture, x, y, width, height);
//
//        this.sprites.put(name, sprite);
//        return this;
//    }

    public AssetSystem loadTextureAtlas(String name) {
        this.assetManager.load(name, TextureAtlas.class);
        return this;
    }

    public TextureAtlas getTextureAtlas(String name) {
        return this.assetManager.get(name, TextureAtlas.class);
    }

}
