package game.player;

import game.Utils;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physicbody;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class Player extends GameObject implements Physicbody{
    PlayerMove playerMove;
    BoxCollider boxCollider;
    FrameCounter frameCounter = new FrameCounter(10);

    public Player() {
        super();
        frameCounter = new FrameCounter(50);
        boxCollider = new BoxCollider(40,40);
        children.add(boxCollider);
    }

    public static Player createMalePlayer() {
        Player player = new MalePlayer();
        player.renderer = new ImageRenderer(Utils.loadImage("assets/images/playerboy/shape229.png"));
        return player;
    }

    public void setPlayerMove(PlayerMove playerMove) {
        this.playerMove = playerMove;
    }

    public static Player createFemalePlayer() {
        Player player = new FemalePlayer();
        player.renderer = new ImageRenderer(Utils.loadImage("assets/images/playerboy/shape235.png"));
        return player;
    }

    @Override
    public void run(Vector2D parentPosition) {
        if (playerMove != null)
            playerMove.move(this);
        super.run(parentPosition);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
