package net.wavehack.multitroid.system.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import net.wavehack.multitroid.system.PassiveSystem;

public class CameraSystem extends PassiveSystem {

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

}
