package net.wavehack.multitroid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.wavehack.multitroid.MultitroidGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Multitroid";

        config.width = 1280;
        config.height = 720;

        new LwjglApplication(new MultitroidGame(), config);
    }

}
