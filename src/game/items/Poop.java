package game.items;

import game.Utils;
import game.bases.GameObject;
import game.bases.GameObjectPool;
import game.bases.Vector2D;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physicbody;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class Poop extends GameObject implements Physicbody {
    BoxCollider boxCollider;

    public Poop() {
        super();
        this.renderer = new ImageRenderer(Utils.loadImage("assets/images/items/poop/poop1.png"));
        this.boxCollider = new BoxCollider(32,32);
        children.add(boxCollider);
    }

    public void getEat(){
        this.isActive = false;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
    }

    @Override
    public BoxCollider getBoxCollier() {
        return boxCollider;
    }
}
