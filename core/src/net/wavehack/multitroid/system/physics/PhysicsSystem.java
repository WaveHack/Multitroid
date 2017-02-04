package net.wavehack.multitroid.system.physics;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.component.physics.Physics;

public class PhysicsSystem extends EntityProcessingSystem {

    private ComponentMapper<Physics> physicsMapper;
    private ComponentMapper<Position> positionMapper;

    @SuppressWarnings("unchecked")
    public PhysicsSystem() {
        super(Aspect.all(Physics.class, Position.class));
    }

    @Override
    protected void process(Entity e) {
        final Physics physics = this.physicsMapper.get(e);
        final Position position = this.positionMapper.get(e);

        // todo: map collisions

        position.position.x += (physics.velocity.x * this.world.delta);
        position.position.y += (physics.velocity.y * this.world.delta);
    }

}
