package net.wavehack.multitroid.system.physics;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.component.physics.Movement;

public class MovementSystem extends EntityProcessingSystem {

    private ComponentMapper<Movement> mm;
    private ComponentMapper<Position> pm;

    @SuppressWarnings("unchecked")
    public MovementSystem() {
        super(Aspect.all(Movement.class, Position.class));
    }

    @Override
    protected void process(Entity e) {
        final Movement movement = this.mm.get(e);
        final Position position = this.pm.get(e);

        // todo: map collisions

        position.position.x += (movement.velocity.x * this.world.delta);
        position.position.y += (movement.velocity.y * this.world.delta);
    }

}
