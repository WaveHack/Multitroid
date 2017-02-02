package net.wavehack.multitroid.component.physics;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class Movement extends Component {

    public Vector2 velocity = new Vector2(0, 0);

    public Movement() {
    }

    public Movement(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Movement(float x, float y) {
        this(new Vector2(x, y));
    }

}
