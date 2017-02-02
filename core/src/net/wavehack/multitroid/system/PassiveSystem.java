package net.wavehack.multitroid.system;

import com.artemis.BaseSystem;

public class PassiveSystem extends BaseSystem {

    @Override
    protected boolean checkProcessing() {
        return false;
    }

    @Override
    protected void processSystem() {
    }

}
