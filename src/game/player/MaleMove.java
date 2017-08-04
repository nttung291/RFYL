package game.player;

import game.bases.Vector2D;
import inputs.InputManager;
import tklibs.Mathx;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class MaleMove implements PlayerMove{
    @Override
    public void move(Player player) {
        Vector2D position = player.position;

        if (InputManager.instance.rightPressed) {
            position.addUp(10, 0);
        }

        if (InputManager.instance.leftPressed) {
            position.addUp(-10, 0);
        }

        if (InputManager.instance.upPressed){
            position.addUp(0,-10);
        }

        if (InputManager.instance.downPressed){
            position.addUp(0,10);
        }

        position.x = Mathx.clamp(position.x, 0,3296);
    }
}
