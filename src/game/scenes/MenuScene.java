package game.scenes;

import game.GameWindow;
import game.Utils;
import game.bases.GameObject;
import game.bases.renderer.ImageRenderer;
import inputs.InputListener;
import inputs.InputManager;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Set;

/**
 * Created by SNOW on 8/12/2017.
 */
public class MenuScene extends Scene implements InputListener{

    @Override
    public void init() {
        GameObject introImage = new GameObject();
        introImage.renderer = new ImageRenderer(Utils.loadImage("assets/startScene/rfyl.jpg"));
        introImage.position.set(Settings.windowWidth / 2, Settings.windowHeight / 2);
        GameObject.add(introImage);
        InputManager.instance.register(this);
    }

    @Override
    public boolean onKeyPressed(int keyCode) {
        return false;
    }

    @Override
    public boolean onKeyReleased(int keyCode) {
        GameWindow.currentTime1 = System.currentTimeMillis();
        SceneManager.instance.requestChangeScene(new Level1Scene());
        return true;
    }
}
