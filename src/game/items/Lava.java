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
public class Lava extends GameObject implements Physicbody {

    private BoxCollider boxCollider;
    public Lava() {
        super();
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/items/lava.png"));
        this.boxCollider = new BoxCollider(32, 32);
        this.children.add(boxCollider);
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }
}
