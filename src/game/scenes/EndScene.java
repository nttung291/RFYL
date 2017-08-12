package game.scenes;

import game.GameWindow;
import game.Utils;
import game.bases.GameObject;
import game.bases.renderer.ImageRenderer;
import game.cameras.Camera;
import game.player.FemalePlayer;
import game.player.MalePlayer;
import game.viewports.ViewPort;
import inputs.InputListener;
import inputs.InputManager;

import java.awt.*;

/**
 * Created by Nttung PC on 8/12/2017.
 */
public class EndScene extends Scene{

    GameObject introImage = new GameObject();
    @Override
    public void init() {
        if (GameWindow.endTime1 - GameWindow.currentTime1 > GameWindow.endTime2 - GameWindow.currentTime2){
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/endScene/femalewin.png"));
        }else{
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/startScene/malewin.png"));
        }
        introImage.position.set(Settings.windowWidth/2, Settings.windowHeight/2);
        ViewPort.followingDisabled = true;
        GameObject.add(introImage);
    }

}
