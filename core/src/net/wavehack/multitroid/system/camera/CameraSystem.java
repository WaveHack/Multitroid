package net.wavehack.multitroid.system.camera;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraSystem extends BaseSystem {

    public final OrthographicCamera camera;
    public final OrthographicCamera guiCamera;

    public static final float ZOOM = 4f;

    public CameraSystem() {
        this.camera = new OrthographicCamera(
                Gdx.graphics.getWidth() / ZOOM,
                Gdx.graphics.getHeight() / ZOOM
        );
        this.camera.setToOrtho(
                false,
                Gdx.graphics.getWidth() / ZOOM,
                Gdx.graphics.getHeight() / ZOOM
        );
        this.camera.update();

        this.guiCamera = new OrthographicCamera(
                Gdx.graphics.getWidth() / ZOOM,
                Gdx.graphics.getHeight() / ZOOM
        );
        this.guiCamera.setToOrtho(
                false,
                Gdx.graphics.getWidth() / ZOOM,
                Gdx.graphics.getHeight() / ZOOM
        );
        this.guiCamera.update();
    }

    @Override
    protected void processSystem() {
        this.camera.update();
    }

}
