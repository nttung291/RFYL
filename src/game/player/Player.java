package game.player;

import game.Utils;
import game.bases.Contraints;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.BoxCollider;
import game.bases.physics.Physics;
import game.bases.physics.Physicbody;
import game.bases.renderer.ImageRenderer;
import game.items.Banana;
import game.items.Drug;
import game.items.Lava;
import game.items.Poop;

import static game.player.MalePlayer.condom;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class Player extends GameObject implements Physicbody {

    public BoxCollider boxCollider;
    public int v;
    public int bullet;
    public Vector2D velocity;
    public float gravity = 2f;

    FrameCounter slowPoopBullet;
    FrameCounter frameCounterBanana;
    FrameCounter frameCounterDrug;
    public boolean  bananaStand;
    boolean buffSpeedDrug;

    public Contraints constraints;

    public static BoxCollider maleColider;
    public static BoxCollider femaleColider;

    public Player() {
        super();
        v=10;
        constraints = new Contraints(0,670,0,6400);
        boxCollider = new BoxCollider(30,60);
        maleColider = new BoxCollider(30,60);
        femaleColider = new BoxCollider(30,60);
        slowPoopBullet = new FrameCounter(60);
        frameCounterBanana = new FrameCounter(30);
        frameCounterDrug = new FrameCounter(30);
        velocity = new Vector2D();
        children.add(boxCollider);
    }

    public Player createMalePlayer() {
        Player player = new MalePlayer();
        return player;
    }

    public static Player createFemalePlayer() {
        Player player = new FemalePlayer();
        return player;
    }

    private void eatPoop() {
        Poop eatPoop = Physics.bodyInRect(this.boxCollider, Poop.class);
        if (eatPoop != null && eatPoop.isActive){
            bullet += 3;
            eatPoop.getEat();
        }
    }

    private void eatPoopBullet() {
        ThrowPoop eatPoopBullet = Physics.bodyInRect(this.boxCollider, ThrowPoop.class);
        if (eatPoopBullet != null && eatPoopBullet.isActive){
            eatPoopBullet.getEat();
            v = 5;
        }
        if (v == 5){
            if (slowPoopBullet.run()){
                slowPoopBullet.reset();
                v = 10;
            }
        }
    }

    public void eatBanana() {
        Banana eatBanana = Physics.bodyInRect(this.boxCollider, Banana.class);
        if (eatBanana != null && eatBanana.isActive){
            eatBanana.getEat();
            bananaStand = true;
        }
        if (bananaStand){
            if (frameCounterBanana.run()){
                frameCounterBanana.reset();
                bananaStand = false;
            }
        }
    }

    public void eatDrug() {
        Drug eatDrug = Physics.bodyInRect(this.boxCollider,Drug.class);
        if (eatDrug != null && eatDrug.isActive ){
            eatDrug.getEat();
            v=15;
            buffSpeedDrug = true;
        }
        if (buffSpeedDrug){
            if (frameCounterDrug.run()){
                v= 10;
                frameCounterDrug.reset();
                buffSpeedDrug = false;
            }
        }
    }

    public void moveHorizontal() {
        float deltaX = velocity.x > 0 ? 1: -1;
        Physicbody body = Physics.bodyInRect(position.add(velocity.x, 0), boxCollider.width, boxCollider.height, Lava.class);
        if (body != null) {
            if (Physics.bodyInRect(position.add(deltaX, 0), boxCollider.width, boxCollider.height, Lava.class)==null) {
                position.addUp(deltaX, 0);
            }
            this.velocity.x = 0;
        }
    }

    public void moveVertical(){
        float deltaY = velocity.y > 0 ? 1: -1;
        Physicbody body = Physics.bodyInRect(this.position.add(0, velocity.y), boxCollider.width, boxCollider.height, Lava.class);
        if (body != null) {
            if (Physics.bodyInRect(position.add(0, deltaY), boxCollider.width, boxCollider.height, Lava.class) == null) {
                position.addUp(0, deltaY);
            }
            this.velocity.y = 0;
        }
    }

    @Override
    public void run(Vector2D parentPosition) {
        moveVertical();
        moveHorizontal();
        eatBanana();
        eatDrug();
        eatPoop();
        eatPoopBullet();
        if ( !bananaStand){
            move();
        }
        super.run(parentPosition);
    }

    public void move() {
    }

    public void setConstraints(Contraints constraints) {
        this.constraints = constraints;
    }

    @Override
    public BoxCollider getBoxCollier() {
        return this.boxCollider;
    }
}
