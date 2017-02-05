package net.wavehack.multitroid.component.graphics;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class Sprite extends Component {

    public String textureAtlas;
    public String regionName;
    public int index = 1;

    public Vector2 offset = new Vector2(0, 0);

    public Sprite() {
    }

    public Sprite(String textureAtlas, String regionName) {
        this.textureAtlas = textureAtlas;
        this.regionName = regionName;
    }

    public Sprite(String textureAtlas, String regionName, Vector2 offset) {
        this(textureAtlas, regionName);
        this.offset = offset;
    }

    public Sprite(String textureAtlas, String regionName, float offsetX, float offsetY) {
        this(textureAtlas, regionName, new Vector2(offsetX, offsetY));
    }

}

