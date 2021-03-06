package net.wavehack.multitroid.screen;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.system.animation.AnimationUpdateSystem;
import net.wavehack.multitroid.system.animation.PlayerAnimationSystem;
import net.wavehack.multitroid.system.asset.AssetLoaderSystem;
import net.wavehack.multitroid.system.asset.AssetSystem;
import net.wavehack.multitroid.system.camera.CameraSystem;
import net.wavehack.multitroid.system.debug.DebugRenderSystem;
import net.wavehack.multitroid.system.input.LocalControllerSystem;
import net.wavehack.multitroid.system.physics.MovementSystem;
import net.wavehack.multitroid.system.physics.PhysicsSystem;
import net.wavehack.multitroid.system.render.AnimationRenderSystem;
import net.wavehack.multitroid.system.render.ClearScreenSystem;
import net.wavehack.multitroid.system.render.SpriteRenderSystem;
import net.wavehack.multitroid.util.EntityFactory;

public class LoadingScreen extends ScreenAdapter {

    public LoadingScreen() {
        SpriteBatch spriteBatch = new SpriteBatch();
        ShapeRenderer shapeRenderer = new ShapeRenderer();

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

                // Active - Update
                new AnimationUpdateSystem(),
                new PlayerAnimationSystem(),

                // Active - Render
                new ClearScreenSystem(),
//                new MapRenderSystem(),
                new AnimationRenderSystem(spriteBatch),
                new SpriteRenderSystem(spriteBatch),
//                new GUIRenderSystem(),

                new DebugRenderSystem(shapeRenderer)

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
