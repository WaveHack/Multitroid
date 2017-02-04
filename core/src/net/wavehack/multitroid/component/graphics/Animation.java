package net.wavehack.multitroid.component.graphics;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import net.wavehack.multitroid.G;

import java.util.ArrayList;
import java.util.HashMap;

public class Animation extends Component {

    public enum Type {
        Loop,
        PingPong
    }

    public static class FrameSequence {

        public static class Frame {

            public int delay;
            public Sprite sprite;

        }

        public Type type = Type.Loop;

        public ArrayList<Frame> frames = new ArrayList<Frame>();

        public FrameSequence() {
        }

        public FrameSequence add(Frame frame) {
            this.frames.add(frame);
            return this;
        }

        public static FrameSequence createLinearSequence(int numFrames, int frameDelay, Type type) {
            FrameSequence sequence = new FrameSequence();

            for (int i = 0; i < numFrames; i++) {
                Frame frame = new Frame();
                frame.delay = frameDelay;
                sequence.add(frame);
            }

            sequence.type = type;
            return sequence;
        }

    }

    protected String textureAtlas;

    protected HashMap<String, FrameSequence> frameSequences = new HashMap<String, FrameSequence>();

    // age (+= delta) etc
    // current animation aka frameSequence->sprite
    // get current anim frame

    public Animation() {
    }

    public Animation(String textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    public Animation add(String name, FrameSequence frameSequence) {
//        TextureAtlas atlas = G.assetManager.get("sprites.txt", TextureAtlas.class);
//        atlas.createSprite()
        // assetmanager
//        Sprite sprite = new Sprite()

        this.frameSequences.put(name, frameSequence);
        return this;
    }

}
