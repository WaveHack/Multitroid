package net.wavehack.multitroid;

import com.badlogic.gdx.Game;
import net.wavehack.multitroid.screen.LoadingScreen;

public class MultitroidGame extends Game {

    @Override
    public void create() {
        this.setScreen(new LoadingScreen());
    }

}
