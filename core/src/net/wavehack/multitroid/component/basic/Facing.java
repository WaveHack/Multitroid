package net.wavehack.multitroid.component.basic;

import com.artemis.Component;

public class Facing extends Component {

    public enum Direction {
        Left,
        Right
    }

    public Direction direction = Direction.Left;

    public Facing() {
    }

    public Facing(Direction direction) {
        this.direction = direction;
    }

}
