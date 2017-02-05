package net.wavehack.multitroid.component.graphics;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.HashMap;

public class Animation extends Component {

    public enum Type {
        OneOff,
        Loop,
        PingPong
    }

    public static class FrameSequence {

        public static class Frame {

            public int index = -1;
            public int delay;

        }

        public Type type = Type.Loop;
        public ArrayList<Frame> frames = new ArrayList<Frame>();
        public int currentFrame;
        public boolean reversed = false;

        public FrameSequence() {
        }

        public FrameSequence add(Frame frame) {
            this.frames.add(frame);
            return this;
        }

        public boolean advanceFrame() {
            if (this.reversed) {
                this.currentFrame--;
            } else {
                this.currentFrame++;
            }

            switch (this.type) {
                case OneOff:
                    if (this.currentFrame > this.frames.size() - 1) {
                        this.currentFrame = (this.frames.size() - 1);
                        return false;
                    }
                    break;

                case Loop:
                    if (this.currentFrame > this.frames.size() - 1) {
                        this.currentFrame = 0;
                    }
                    break;

                case PingPong:
                    if (this.currentFrame > this.frames.size() - 1) {
                        this.currentFrame = (this.frames.size() - 2);
                        this.reversed = true;
                    }

                    if (this.currentFrame < 0) {
                        this.currentFrame = 1;
                        this.reversed = false;
                    }
                    break;
            }

            return true;
        }

        public Frame getCurrentFrame() {
            return this.frames.get(this.currentFrame);
        }

        public static FrameSequence createLinearSequence(int numFrames, int frameDelay, Type type) {
            FrameSequence sequence = new FrameSequence();

            for (int i = 0; i < numFrames; i++) {
                Frame frame = new Frame();
                frame.index = (i + 1);
                frame.delay = frameDelay;
                sequence.add(frame);
            }

            sequence.type = type;
            return sequence;
        }

    }

    public String textureAtlas;
    public String currentAnimation = "";
    public boolean done = false;
    public float age = 0;
    public float prev = 0;
    public float next = 0;

    public Color color = new Color(Color.WHITE);
    public Vector2 scale = new Vector2(1, 1);

    protected HashMap<String, FrameSequence> frameSequences = new HashMap<String, FrameSequence>();

    public Animation() {
    }

    public Animation(String textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    public Animation add(String name, FrameSequence frameSequence) {
        this.frameSequences.put(name, frameSequence);

        if (this.currentAnimation.equals("")) {
            this.change(name);
        }

        return this;
    }

    public void update(float delta) {
        this.age += delta;

        if (this.done) {
            return;
        }

        this.prev += delta;
        this.next -= delta;

        if (this.next <= 0) {
            if (!this.getCurrentFrameSequence().advanceFrame()) {
                this.done = true;
            }

            this.prev = 0;
            this.next = this.getCurrentFrame().delay / 1000f;
        }
    }

    public Animation change(String name) {
        if (this.currentAnimation.equals(name)) {
            return this;
        }

        if (!this.frameSequences.containsKey(name)) {
            throw new RuntimeException("Frame sequence " + name + " does not exist");
        }

        this.currentAnimation = name;
        this.age = 0;
        this.prev = 0;
        this.next = this.getCurrentFrame().delay / 1000f;

        return this;
    }

    public FrameSequence getCurrentFrameSequence() {
        return this.frameSequences.get(this.currentAnimation);
    }

    public FrameSequence.Frame getCurrentFrame() {
        return this.getCurrentFrameSequence().getCurrentFrame();
    }

}
