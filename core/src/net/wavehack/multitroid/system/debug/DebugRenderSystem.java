package net.wavehack.multitroid.system.debug;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.wavehack.multitroid.component.basic.Bounds;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.system.camera.CameraSystem;

public class DebugRenderSystem extends EntityProcessingSystem {

    private ComponentMapper<Bounds> bm;
    private ComponentMapper<Position> pm;

    private CameraSystem cameraSystem;
    private ShapeRenderer shapeRenderer;

    @SuppressWarnings("unchecked")
    public DebugRenderSystem() {
        super(Aspect.all(Bounds.class, Position.class));

        this.shapeRenderer = new ShapeRenderer();
    }

    @Override
    protected void begin() {
        this.shapeRenderer.setProjectionMatrix(this.cameraSystem.camera.combined);
        this.shapeRenderer.identity();

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override
    protected void process(Entity e) {
        final Bounds bounds = this.bm.get(e);
        final Position position = this.pm.get(e);

        // Background
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setColor(0f, 1f, 0f, 0.25f);
        this.shapeRenderer.rect(
            position.position.x - bounds.size.x * bounds.pivot.x,
            position.position.y - bounds.size.y * bounds.pivot.y,
            bounds.size.x,
            bounds.size.y
        );
        this.shapeRenderer.end();

        // Outline
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        this.shapeRenderer.setColor(0f, 1f, 0f, 0.75f);
        this.shapeRenderer.rect(
            position.position.x - bounds.size.x * bounds.pivot.x,
            position.position.y - bounds.size.y * bounds.pivot.y,
            bounds.size.x,
            bounds.size.y
        );
        this.shapeRenderer.end();

        // Pivot
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setColor(1f, 0f, 0f, 0.75f);
        this.shapeRenderer.rect(
            position.position.x - 0.5f,
            position.position.y - 0.5f,
            1,
            1
        );
        this.shapeRenderer.end();
    }

    @Override
    protected void end() {
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

}
