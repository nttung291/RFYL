package game.items;

import game.Utils;
import game.bases.GameObject;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physicbody;
import game.bases.renderer.Animation;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class Banana extends GameObject implements Physicbody {
    public BoxCollider boxCollider;
    public Banana() {
        this.renderer = new Animation(4,true,
                Utils.loadImage("assets/images/items/banana/banana1.png"),
                Utils.loadImage("assets/images/items/banana/banana2.png"),
                Utils.loadImage("assets/images/items/banana/banana3.png"),
                Utils.loadImage("assets/images/items/banana/banana4.png")
        );
        this.boxCollider = new BoxCollider(5,5);
        children.add(boxCollider);
    }

    public void getEat(){
        this.isActive = false;
    }

    @Override
    public BoxCollider getBoxCollier() {
        return boxCollider;
    }
}
