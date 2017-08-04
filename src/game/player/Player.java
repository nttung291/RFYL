package game.player;

import game.Utils;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class Player extends GameObject{
    PlayerMove playerMove;
    public Player() {
        super();
    }

    public static Player createMalePlayer() {
        Player player = new Player();
        player.renderer = new ImageRenderer(Utils.loadImage("assets/images/playerboy/shape229.png"));
        return player;
    }

    public void setPlayerMove(PlayerMove playerMove) {
        this.playerMove = playerMove;
    }

    public static Player createFemalePlayer() {
        Player player = new Player();
        player.renderer = new ImageRenderer(Utils.loadImage("assets/images/playerboy/shape235.png"));
        return player;
    }

    @Override
    public void run(Vector2D parentPosition) {
        if (playerMove != null)
            playerMove.move(this);
        super.run(parentPosition);
    }
}
