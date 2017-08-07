package game.items;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physicbody;
import game.bases.renderer.ImageRenderer;
import game.cameras.Camera;

import java.awt.*;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class Condom extends GameObject implements Physicbody{
    public BoxCollider boxCollider;

    public Condom() {
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/items/condom.png"));
        boxCollider = new BoxCollider(32,32);
        this.children.add(boxCollider);
    }

    public void getEat() {
        this.isActive = false;
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }
}
