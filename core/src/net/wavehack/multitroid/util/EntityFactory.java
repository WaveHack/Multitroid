package net.wavehack.multitroid.util;

import com.artemis.Entity;
import com.artemis.managers.TagManager;
import net.wavehack.multitroid.G;
import net.wavehack.multitroid.component.basic.*;
import net.wavehack.multitroid.component.graphics.Animation;
import net.wavehack.multitroid.component.physics.Physics;

public class EntityFactory {

    public static Entity createPlayer(float x, float y) {
        Entity player = G.world.createEntity();
        player.edit()
            .add(new Player())
            .add(new Position(x, y))
            .add(new Bounds(13, 34))
            .add(new Facing(Facing.Direction.Right))
            .add(new Physics())
            .add(new Controller())
            .add(
                new Animation("sprites.txt", 0, -6f)
                    .add("elisa/stand", Animation.FrameSequence.createLinearSequence(3, 100, Animation.Type.PingPong))
                    .add("elisa/run", Animation.FrameSequence.createLinearSequence(8, 100, Animation.Type.Loop))
            )
        ;
        G.world.getSystem(TagManager.class).register("PLAYER", player);
        return player;
    }

}
