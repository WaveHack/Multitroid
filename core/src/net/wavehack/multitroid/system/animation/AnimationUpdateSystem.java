package net.wavehack.multitroid.system.animation;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.wavehack.multitroid.component.graphics.Animation;

public class AnimationUpdateSystem extends EntityProcessingSystem {

    private ComponentMapper<Animation> animationMapper;

    @SuppressWarnings("unchecked")
    public AnimationUpdateSystem() {
        super(Aspect.all(Animation.class));
    }

    @Override
    protected void process(Entity e) {
        final Animation animation = this.animationMapper.get(e);

        animation.update(this.world.delta);
    }

}
