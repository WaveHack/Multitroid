package net.wavehack.multitroid.screen;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.system.asset.AssetLoaderSystem;
import net.wavehack.multitroid.system.asset.AssetSystem;
import net.wavehack.multitroid.system.camera.CameraSystem;
import net.wavehack.multitroid.system.debug.DebugRenderSystem;
import net.wavehack.multitroid.system.physics.MovementSystem;
import net.wavehack.multitroid.system.render.ClearScreenSystem;
import net.wavehack.multitroid.system.render.SpriteRenderSystem;
import net.wavehack.multitroid.util.EntityFactory;

public class LoadingScreen extends ScreenAdapter {

    public LoadingScreen() {
        G.screen = this;
        G.world = new World(new WorldConfigurationBuilder()
            .with(

                // Passive - System
                new AssetSystem(),
                new CameraSystem(4f),

                // Initialize
                new AssetLoaderSystem(),
//                new DirectorSystem(),

                // Active - Input
//                new PlayerInputSystem(),

                // Active - Psysics
                new MovementSystem(),

                // Active - Render
                new ClearScreenSystem(),
//                new MapRenderSystem(),
                new SpriteRenderSystem(new SpriteBatch()),
//                new GUIRenderSystem(),
                new DebugRenderSystem()

            )
            .build()
        );

        EntityFactory.createPlayer(100, 100);
    }

    @Override
    public void render(float delta) {
        G.world.setDelta(delta);
        G.world.process();
    }

}
