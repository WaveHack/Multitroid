package net.wavehack.multitroid.component.graphics;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class Sprite extends Component {

    public String name;
    public Vector2 offset = new Vector2(0, 0);

    public Sprite() {
    }

    public Sprite(String name) {
        this.name = name;
    }

    public Sprite(String name, Vector2 offset) {
        this.name = name;
        this.offset = offset;
    }

    public Sprite(String name, float offsetX, float offsetY) {
        this(name, new Vector2(offsetX, offsetY));
    }

}

