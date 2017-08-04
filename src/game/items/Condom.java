package game.items;

import game.Utils;
import game.bases.GameObject;
import game.bases.renderer.ImageRenderer;
import game.cameras.Camera;

import java.awt.*;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class Condom extends GameObject {
    public Condom() {
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/items/condom.png"));
    }
}
