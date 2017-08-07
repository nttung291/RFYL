package game.player;

import game.Utils;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physics;
import game.bases.physics.Physicbody;
import game.bases.renderer.ImageRenderer;
import game.items.Banana;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class Player extends GameObject implements Physicbody {

    PlayerMove playerMove;
    BoxCollider boxCollider;

    Vector2D velocity;

    FrameCounter slowPoopBullet;
    FrameCounter cooldownBanana;
    boolean bananaStand = false;

    FrameCounter frameCounter = new FrameCounter(10);


    public Player() {
        super();
        frameCounter = new FrameCounter(50);
        boxCollider = new BoxCollider(80,80);
        slowPoopBullet = new FrameCounter(5);
        cooldownBanana = new FrameCounter(30);
        velocity = new Vector2D();
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

    public void eatBanana() {
        Banana eatBanana = Physics.bodyInRect(this.boxCollider, Banana.class);
        if (eatBanana != null && eatBanana.isActive){
            eatBanana.getEat();
            bananaStand = true;
        }
        if (bananaStand){
            if (cooldownBanana.run()){
                cooldownBanana.reset();
                bananaStand = false;
            }
        }
    }

    @Override
    public void run(Vector2D parentPosition) {
        if (playerMove != null && !bananaStand)
            playerMove.move(this);
        eatBanana();
        super.run(parentPosition);
    }


    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }
}
