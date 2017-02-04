package net.wavehack.multitroid.system.render;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.component.graphics.Sprite;
import net.wavehack.multitroid.system.asset.AssetSystem;
import net.wavehack.multitroid.system.camera.CameraSystem;

public class SpriteRenderSystem extends EntityProcessingSystem {

    private AssetSystem assetSystem;
    private CameraSystem cameraSystem;

    private ComponentMapper<Position> pm;
    private ComponentMapper<Sprite> sm;

    private SpriteBatch spriteBatch;

    @SuppressWarnings("unchecked")
    public SpriteRenderSystem(SpriteBatch spriteBatch) {
        super(Aspect.all(Position.class, Sprite.class));
        this.spriteBatch = spriteBatch;
    }

    @Override
    protected void begin() {
        this.spriteBatch.setProjectionMatrix(this.cameraSystem.camera.combined);
        this.spriteBatch.begin();
    }

    @Override
    protected void process(Entity e) {
        final Position position = this.pm.get(e);
        final Sprite sprite = this.sm.get(e);

        TextureAtlas atlas = this.assetSystem.getTextureAtlas("sprites.txt");
        com.badlogic.gdx.graphics.g2d.Sprite gdxSprite = atlas.createSprite("elisa/stand", 1);

        gdxSprite.setPosition(
            position.position.x - gdxSprite.getWidth() / 2 - sprite.offset.x,
            position.position.y - gdxSprite.getHeight() / 2 - sprite.offset.y
        );

        gdxSprite.draw(this.spriteBatch);
    }

    @Override
    protected void end() {
        this.spriteBatch.end();
    }
}
