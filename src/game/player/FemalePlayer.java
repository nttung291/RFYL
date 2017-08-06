package game.player;

import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.items.Heart;
import inputs.InputManager;
import tklibs.Mathx;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class FemalePlayer extends Player implements PlayerMove{
    public Vector2D velocity;
    public static int heart=5;
    public FemalePlayer() {
        super();
        velocity = new Vector2D();
    }

    @Override
    public void move(Player player) {
        this.velocity.set(0,0);
        Vector2D position = player.position;
        if (InputManager.instance.dPressed) {
            this.velocity.x = 10;
        }

        if (InputManager.instance.aPressed) {
            this.velocity.x = -10;
        }

        if (InputManager.instance.wPressed){
            this.velocity.y = -10;
        }

        if (InputManager.instance.sPressed){
           this.velocity.y = 10;
        }
        position.addUp(velocity);
        position.x = Mathx.clamp(position.x, 0,6000);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        Heart eatHeart = Physics.bodyinRed(this.boxCollider, Heart.class);
        if (eatHeart != null && eatHeart.isActive){
            heart--;
            eatHeart.getEat();
        }
    }
}
