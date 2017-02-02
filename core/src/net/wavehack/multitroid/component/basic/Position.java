package net.wavehack.multitroid.component.basic;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class Position extends Component {

    public Vector2 position;

    public Position(Vector2 position) {
        this.position = position;
    }

    public Position() {
        this(new Vector2(0, 0));
    }

    public Position(float x, float y) {
        this(new Vector2(x, y));
    }

}
