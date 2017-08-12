package game.scenes;

import game.GameWindow;
import game.Utils;
import game.bases.GameObject;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/12/2017.
 */
public class EndScene extends Scene {
    @Override
    public void init() {
        GameObject introImage = new GameObject();
        if (GameWindow.endTime1 - GameWindow.currentTime1 > GameWindow.endTime2 - GameWindow.currentTime2){
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/endScene/endgame1.jpg"));
        }else{
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/endScene/endgame1.jpg"));
        }
        introImage.position.set(Settings.windowWidth / 2, Settings.windowHeight / 2);
        GameObject.add(introImage);
    }
}
