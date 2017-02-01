package net.wavehack.multitroid.screen;

import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Screen;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.system.camera.CameraSystem;
import net.wavehack.multitroid.system.render.ClearScreenSystem;

public class LoadingScreen implements Screen {

    public LoadingScreen() {
        G.screen = this;

        WorldConfiguration config = new WorldConfigurationBuilder()
                .with(

                        // Passive - System
                        new CameraSystem(),

                        // Active - Asset Loader

                        // Render
                        new ClearScreenSystem()

                )
                .build();

        G.world = new World(config);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        G.world.setDelta(delta);
        G.world.process();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        G.world.dispose();
    }

    @Override
    public void dispose() {
    }

}
