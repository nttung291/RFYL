package game.items;

import game.Utils;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.renderer.Animation;

/**
 * Created by Nttung PC on 7/30/2017.
 */
public class PoopExplosion extends GameObject {

    private Animation animation;
    public PoopExplosion() {
        super();
        animation = new Animation(3,false,
                Utils.loadImage("assets/images/items/poop/poopexplosion/0.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/1.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/2.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/3.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/4.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/5.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/6.png"),
                Utils.loadImage("assets/images/items/poop/poopexplosion/7.png")
        );
        this.renderer = animation;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (this.animation.isFinished()){
            this.isActive = false;
        }
    }

    @Override
    public void refresh() {
        super.refresh();
        animation.reset();
    }
}
