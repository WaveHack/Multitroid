package net.wavehack.multitroid.screen;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.system.asset.AssetLoaderSystem;
import net.wavehack.multitroid.system.asset.AssetSystem;
import net.wavehack.multitroid.system.camera.CameraSystem;
import net.wavehack.multitroid.system.debug.DebugRenderSystem;
import net.wavehack.multitroid.system.input.LocalControllerSystem;
import net.wavehack.multitroid.system.physics.MovementSystem;
import net.wavehack.multitroid.system.physics.PhysicsSystem;
import net.wavehack.multitroid.system.render.ClearScreenSystem;
import net.wavehack.multitroid.system.render.SpriteRenderSystem;
import net.wavehack.multitroid.util.EntityFactory;

public class LoadingScreen extends ScreenAdapter {

    public LoadingScreen() {
        G.screen = this;
        G.world = new World(new WorldConfigurationBuilder()
            .with(

                new TagManager(),

                // Passive - System
                new AssetSystem(),
                new CameraSystem(4f),

                // Initialize
                new AssetLoaderSystem(),
//                new DirectorSystem(),

                // Active - Input
                new LocalControllerSystem(),

                // Active - Psysics
                new MovementSystem(),
                new PhysicsSystem(),

                // Active - Render
                new ClearScreenSystem(),
//                new MapRenderSystem(),
//                new AnimationRenderSystem(new SpriteBatch()),
                new SpriteRenderSystem(new SpriteBatch()),
//                new GUIRenderSystem(),
                new DebugRenderSystem(new ShapeRenderer())

            )
            .build()
        );

        EntityFactory.createPlayer(50, 50);
    }

    @Override
    public void render(float delta) {
        G.world.setDelta(delta);
        G.world.process();
    }

}
