package net.wavehack.multitroid.system.physics;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.wavehack.multitroid.component.basic.Controller;
import net.wavehack.multitroid.component.physics.Physics;

public class MovementSystem extends EntityProcessingSystem {

    private ComponentMapper<Controller> controllerMapper;
    private ComponentMapper<Physics> physicsMapper;

    @SuppressWarnings("unchecked")
    public MovementSystem() {
        super(Aspect.all(Controller.class, Physics.class));
    }

    @Override
    protected void process(Entity e) {
        final Controller controller = this.controllerMapper.get(e);
        final Physics physics = this.physicsMapper.get(e);

        if (controller.moveLeft) {
            physics.velocity.x = -64;
        } else if (controller.moveRight) {
            physics.velocity.x = 64;
        } else {
            physics.velocity.x = 0;
        }
    }

}
