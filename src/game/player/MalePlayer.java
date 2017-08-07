package game.player;

import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.items.Condom;
import inputs.InputManager;
import tklibs.Mathx;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class MalePlayer extends Player implements PlayerMove{


    public int condom=10;

    public MalePlayer() {
        super();
    }

    @Override
    public void move(Player player) {
        Vector2D position = player.position;
        velocity.set(0,0);
        if (InputManager.instance.rightPressed) {
            velocity.x=10;
        }

        if (InputManager.instance.leftPressed) {
           velocity.x=-10;
        }

        if (InputManager.instance.upPressed){
            velocity.y=-10;
        }

        if (InputManager.instance.downPressed){
           velocity.y=10;
        }
        position.addUp(velocity);
        position.x = Mathx.clamp(position.x, 0,6000);
    }

    public void eatCondom(){
        Condom eatCondom = Physics.bodyInRect(this.boxCollider,Condom.class);
        if (eatCondom != null && eatCondom.isActive){
            condom--;
            eatCondom.getEat();
        }
    }
    @Override
    public void run(Vector2D parentPosition) {
        eatCondom();
        super.run(parentPosition);
    }
}
