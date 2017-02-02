package net.wavehack.multitroid.component.basic;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class Bounds extends Component {

    public Vector2 size = new Vector2(0, 0);
    public Vector2 pivot = new Vector2(0.5f, 0.5f);

    public Bounds() {
    }

    public Bounds(Vector2 size) {
        this.size = size;
    }

    public Bounds(float x, float y) {
        this(new Vector2(x, y));
    }

    public Bounds(Vector2 size, Vector2 pivot) {
        this.size = size;
        this.pivot = pivot;
    }

    public Bounds(float x, float y, float pivotX, float pivotY) {
        this(new Vector2(x, y), new Vector2(pivotX, pivotY));
    }

}
