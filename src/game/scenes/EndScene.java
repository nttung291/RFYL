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
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/startScene/startscene.png"));
        }else{
            introImage.renderer = new ImageRenderer(Utils.loadImage("assets/startScene/startscene.png"));
        }
        introImage.position.set(Settings.windowWidth, Settings.windowHeight / 2);
        GameObject.add(introImage);
    }
}
