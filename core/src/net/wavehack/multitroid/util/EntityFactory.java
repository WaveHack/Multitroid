package net.wavehack.multitroid.util;

import com.artemis.Entity;
import com.artemis.managers.TagManager;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.component.basic.Bounds;
import net.wavehack.multitroid.component.basic.Position;
import net.wavehack.multitroid.component.graphics.Sprite;

public class EntityFactory {

    public static Entity createPlayer(float x, float y) {
        Entity player = G.world.createEntity();
        player.edit()
            .add(new Position(x, y))
            .add(new Bounds(13, 34))

            /*.add(new Animated()

                .add(new Animation("stand", "sprites", "elisa/stand", 1, 1000))
                .add(new Animation("stand", "sprites", "elisa/stand", 2, 1000))
                .add(new Animation("stand", "sprites", "elisa/stand", 3, 1000, () -> {
                    // pant
                }))
                .add(new Animation("stand", "sprites", "elisa/stand", 2, 1000))

                .add(new Animation("stand", Animation.createLinearAnimation(
                    "sprites",
                    "elisa/stand",
                    new Integer[]{1, 2, 3, 2},
                    1000,
                    Animation.Type.Loop
                )))

                .add(new Animation("stand", Animation.createLinearAnimation(
                    "sprites",
                    "elisa/stand",
                    3,
                    1000,
                    Animation.Type.PingPong
                )))

                .add(new Animation("run", Animation.createLinearAnimation(
                    "sprites",
                    "elisa/run",
                    8,
                    Animation.Type.Loop,
                    true
                )))
            )*/

            .add(new Sprite("elisa", -1.5f, -6))
        ;
        G.world.getSystem(TagManager.class).register("PLAYER", player);
        return player;
    }

}
