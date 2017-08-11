package game.player;

import game.Utils;
import game.bases.GameObject;
import game.bases.GameObjectPool;
import game.bases.Vector2D;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physicbody;
import game.bases.physics.Physics;
import game.bases.renderer.Animation;
import game.bases.renderer.ImageRenderer;
import game.items.Banana;
import game.items.Lava;
import game.items.PoopExplosion;

/**
 * Created by SNOW on 8/6/2017.
 */
public class ThrowPoop extends GameObject implements Physicbody {
    BoxCollider boxCollider;
    Vector2D velocity;

    public ThrowPoop(Vector2D velocity) {
        super();
        this.velocity = velocity;
        this.renderer = new Animation(5,true,
                Utils.loadImage("assets/images/items/poop/poop1.png"),
                Utils.loadImage("assets/images/items/poop/poop2.png"),
                Utils.loadImage("assets/images/items/poop/poop3.png"),
                Utils.loadImage("assets/images/items/poop/poop4.png"),
                Utils.loadImage("assets/images/items/poop/poop5.png"),
                Utils.loadImage("assets/images/items/poop/poop6.png"),
                Utils.loadImage("assets/images/items/poop/poop7.png"),
                Utils.loadImage("assets/images/items/poop/poop8.png")
        );
        this.boxCollider = new BoxCollider(20,20);
        children.add(boxCollider);
    }

    public void getEat(){
        this.isActive = false;
        PoopExplosion poopExplosion = GameObjectPool.recycle(PoopExplosion.class);
        poopExplosion.position.set(this.position);
    }

    public void collideLava(){
        Lava lava = Physics.bodyInRect(this.boxCollider, Lava.class);
        if (lava != null && lava.isActive){
           this.isActive = false;
            PoopExplosion poopExplosion = GameObjectPool.recycle(PoopExplosion.class);
            poopExplosion.position.set(this.position);
        }
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        collideLava();
        this.position.addUp(velocity);
    }

    @Override
    public BoxCollider getBoxCollier() {
        return boxCollider;
    }
}
