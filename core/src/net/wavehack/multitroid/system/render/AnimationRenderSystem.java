package net.wavehack.multitroid.system.render;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.component.graphics.Animation;
import net.wavehack.multitroid.system.asset.AssetSystem;
import net.wavehack.multitroid.system.camera.CameraSystem;
import sun.rmi.runtime.Log;

import java.io.Console;

public class AnimationRenderSystem extends EntityProcessingSystem {

    private AssetSystem assetSystem;
    private CameraSystem cameraSystem;

    private ComponentMapper<Animation> animationMapper;
    private ComponentMapper<Position> positionMapper;

    private SpriteBatch spriteBatch;

    @SuppressWarnings("unchecked")
    public AnimationRenderSystem(SpriteBatch spriteBatch) {
        super(Aspect.all(Animation.class, Position.class));
        this.spriteBatch = spriteBatch;
    }

    @Override
    protected void begin() {
        this.spriteBatch.setProjectionMatrix(this.cameraSystem.camera.combined);
        this.spriteBatch.begin();
    }

    @Override
    protected void process(Entity e) {
        final Animation animation = this.animationMapper.get(e);
        final Position position = this.positionMapper.get(e);

        Animation.FrameSequence.Frame frame = animation.getCurrentFrame();
        TextureAtlas atlas = this.assetSystem.getTextureAtlas(animation.textureAtlas);
        Sprite sprite = atlas.createSprite(animation.currentAnimation, frame.index);

        sprite.setPosition(
            position.position.x - sprite.getWidth() / 2,// - sprite.offset.x,
            position.position.y - sprite.getHeight() / 2// - sprite.offset.y
        );

        sprite.draw(this.spriteBatch);
    }

    @Override
    protected void end() {
        this.spriteBatch.end();
    }

}
