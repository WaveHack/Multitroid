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

        if (frame.sprite == null) {
            TextureAtlas atlas = this.assetSystem.getTextureAtlas(animation.textureAtlas);
            frame.sprite = atlas.createSprite(animation.currentAnimation, frame.index);
        }

        frame.sprite.setColor(animation.color);
        frame.sprite.setScale(animation.scale.x, animation.scale.y);

        frame.sprite.setPosition(
            position.position.x - frame.sprite.getWidth() / 2 - animation.offset.x,
            position.position.y - frame.sprite.getHeight() / 2 - animation.offset.y
        );

        frame.sprite.draw(this.spriteBatch);
    }

    @Override
    protected void end() {
        this.spriteBatch.end();
    }

}
