package net.wavehack.multitroid.screen;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Screen;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.component.basic.Bounds;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.system.camera.CameraSystem;
import net.wavehack.multitroid.system.debug.DebugRenderSystem;
import net.wavehack.multitroid.system.physics.MovementSystem;
import net.wavehack.multitroid.system.render.ClearScreenSystem;

public class LoadingScreen implements Screen {

    public LoadingScreen() {
        G.screen = this;
        G.world = new World(new WorldConfigurationBuilder()
            .with(

                // Passive - System
                new CameraSystem(4f),

                // Active - Input
//                new PlayerInputSystem(),

                // Active - Psysics
                new MovementSystem(),

                // Active - Render
                new ClearScreenSystem(),
                new DebugRenderSystem()

            )
            .build()
        );

        Entity e = G.world.createEntity();
        e.edit()
            .add(new Position(24, 24))
            .add(new Bounds(16, 16))
            /*.add(new Movement(16, 0))*/;
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
