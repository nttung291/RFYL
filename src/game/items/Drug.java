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
public class Drug extends GameObject implements Physicbody {
    public BoxCollider boxCollider;
    public Drug() {
        this.renderer = new Animation(3,true,
                Utils.loadImage("assets/images/items/drug/drug1.png"),
                Utils.loadImage("assets/images/items/drug/drug2.png"),
                Utils.loadImage("assets/images/items/drug/drug3.png"),
                Utils.loadImage("assets/images/items/drug/drug4.png"),
                Utils.loadImage("assets/images/items/drug/drug5.png")
        );
        this.boxCollider = new BoxCollider(32,32);
        children.add(boxCollider);
    }

    public void getEat(){
        this.isActive = false;
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }
}
