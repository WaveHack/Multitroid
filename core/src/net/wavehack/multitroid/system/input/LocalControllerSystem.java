package net.wavehack.multitroid.system.input;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import net.wavehack.multitroid.component.basic.Controller;

public class LocalControllerSystem extends EntityProcessingSystem implements InputProcessor {

    private ComponentMapper<Controller> controllerMapper;

    private boolean left = false;
    private boolean right = false;
//    private boolean jump = false;

    @SuppressWarnings("unchecked")
    public LocalControllerSystem() {
        super(Aspect.all(Controller.class));
    }

    @Override
    protected void initialize() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    protected void process(Entity e) {
        final Controller controller = this.controllerMapper.get(e);

        controller.moveLeft = this.left;
        controller.moveRight = this.right;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                this.left = true;
                break;

            case Input.Keys.RIGHT:
                this.right = true;
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                this.left = false;
                break;

            case Input.Keys.RIGHT:
                this.right = false;
                break;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
