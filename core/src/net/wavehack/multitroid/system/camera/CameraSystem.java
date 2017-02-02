package net.wavehack.multitroid.system.camera;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraSystem extends BaseSystem {

    public OrthographicCamera camera;
    public OrthographicCamera guiCamera;
    public final float zoom;

    public CameraSystem(float zoom) {
        this.zoom = zoom;
        this.setupViewport(
            Gdx.graphics.getWidth() / this.zoom,
            Gdx.graphics.getHeight() / this.zoom
        );
    }

    protected void setupViewport(float width, float height) {
        this.camera = new OrthographicCamera(width, height);
        this.camera.setToOrtho(false, width, height);
        this.camera.update();

        this.guiCamera = new OrthographicCamera(width, height);
        this.guiCamera.setToOrtho(false, width, height);
        this.guiCamera.update();
    }

    @Override
    protected void processSystem() {
    }

}
