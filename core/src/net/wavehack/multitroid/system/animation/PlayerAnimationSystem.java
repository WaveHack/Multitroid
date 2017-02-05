package net.wavehack.multitroid.system.animation;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.wavehack.multitroid.component.basic.Facing;
import net.wavehack.multitroid.component.basic.Player;
import net.wavehack.multitroid.component.graphics.Animation;
import net.wavehack.multitroid.component.physics.Physics;

public class PlayerAnimationSystem extends EntityProcessingSystem {

    private ComponentMapper<Animation> animationMapper;
    private ComponentMapper<Facing> facingMapper;
    private ComponentMapper<Physics> physicsMapper;

    @SuppressWarnings("unchecked")
    public PlayerAnimationSystem() {
        super(Aspect.all(Player.class, Animation.class, Facing.class, Physics.class));
    }

    @Override
    protected void process(Entity e) {
        final Animation animation = this.animationMapper.get(e);
        final Facing facing = this.facingMapper.get(e);
        final Physics physics = this.physicsMapper.get(e);

        // Set facing direction
        if (facing.direction == Facing.Direction.Left && physics.velocity.x > 0) {
            facing.direction = Facing.Direction.Right;

        } else if (facing.direction == Facing.Direction.Right && physics.velocity.x < 0) {
            facing.direction = Facing.Direction.Left;
        }

        // Flip sprite based on direction
        if ((facing.direction == Facing.Direction.Left) && (animation.scale.x != -1)) {
            animation.scale.x = -1;
        } else if ((facing.direction == Facing.Direction.Right) && (animation.scale.x != 1)) {
            animation.scale.x = 1;
        }

        // Stand -> Move
        if (Math.abs(physics.velocity.x) > 0) {
            animation.change("elisa/run");
        }

        // Move -> Stand
        else if (physics.velocity.x == 0) {
            animation.change("elisa/stand");
        }
    }

}
