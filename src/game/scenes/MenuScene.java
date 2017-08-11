package game.scenes;

import game.Utils;
import game.bases.GameObject;
import game.bases.renderer.ImageRenderer;
import inputs.InputListener;
import inputs.InputManager;

/**
 * Created by SNOW on 8/12/2017.
 */
public class MenuScene extends Scene implements InputListener{

    @Override
    public void init() {
        GameObject introImage = new GameObject();
        introImage.renderer = new ImageRenderer(Utils.loadImage("assets/images/startScene/_run_for_your_life__by_yoshiman1118-d2xti9b.png"));
        introImage.position.set(1600,800);
        GameObject.add(introImage);

        InputManager.instance.register(this);
    }

    @Override
    public boolean onKeyPressed(int keyCode) {
        return false;
    }

    @Override
    public boolean onKeyReleased(int keyCode) {
        return false;
    }
}
