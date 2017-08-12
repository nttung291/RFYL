package game.player;

import game.bases.Contraints;
import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.items.Heart;
import game.items.Lava;
import inputs.InputManager;
import tklibs.AudioUtils;
import tklibs.Mathx;

import static game.GameWindow.checkLevel;
import static game.player.MalePlayer.condom;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class FemalePlayer extends Player{

    public static int heart=0;
    boolean bulletDisable;
    FrameCounter cooldownBullet;
    public static Player instanceFemale;
    FemaleAnimator femaleAnimator;
    GirlAnimator girlAnimator;
    FrameCounter waitting;



    public FemalePlayer() {
        super();
        this.cooldownBullet = new FrameCounter(5);
        instanceFemale = this;
        femaleAnimator = new FemaleAnimator();
        girlAnimator = new GirlAnimator();
        femaleAnimator = new FemaleAnimator();
        waitting = new FrameCounter(80);
        this.renderer = girlAnimator;
    }

    public void femalemove(){
        this.velocity.y += gravity;
        this.velocity.x = 0;
        if (InputManager.instance.leftPressed){
            this.velocity.x = -v;
        }
        if (InputManager.instance.rightPressed)
            this.velocity.x = v;
        if (InputManager.instance.upPressed) {
            if (Physics.bodyInRect(position.add(0, 1), boxCollider.width, boxCollider.height, Lava.class) != null) {
                this.velocity.y -= 28;
            }
        }
        moveHorizontal();
        position.x += velocity.x;
        moveVertical();
        position.y += velocity.y;
        position.x = Mathx.clamp(position.x,10,6300);
    }

    @Override
    public void move() {
        if (checkLevel == 2){
            if (waitting.run()){
                femalemove();
            }
        }else{
            femalemove();
        }
    }

    public void eatHeart(){
        Heart eatHeart = Physics.bodyInRect(this.boxCollider, Heart.class);
        if (eatHeart != null && eatHeart.isActive){
            AudioUtils.playMedia("assets/music/Pickup_Item.wav");
            heart++;
            eatHeart.getEat();
        }
    }

    public static boolean hitMale(){
        MalePlayer malePlayer = Physics.bodyInRect(Player.femaleColider,MalePlayer.class);
        if (malePlayer != null && malePlayer.isActive && condom < 5){
            return true;
        }
        return false;
    }

    private void castPoop() {
        if (InputManager.instance.mPressed){
            if (!bulletDisable && bullet > 0){
                if (this.position.x - MalePlayer.instanceMale.position.x > 0){
                    ThrowPoop PoopBullet = new ThrowPoop(new Vector2D(-20,0));
                    PoopBullet.position.set(this.position.x - 70, this.position.y - 20);
                    GameObject.add(PoopBullet);
                    bullet--;
                }else{
                    ThrowPoop PoopBullet = new ThrowPoop(new Vector2D(20,0));
                    PoopBullet.position.set(this.position.x + 70, this.position.y - 20);
                    GameObject.add(PoopBullet);
                    bullet--;
                }
                AudioUtils.playMedia("assets/music/hit.wav");
                bulletDisable = true;
            }
        }
        cooldown();
    }

    private void cooldown() {
        if (bulletDisable){
            if (cooldownBullet.run()){
                cooldownBullet.reset();
                bulletDisable = false;
            }
        }
    }

    private void animate() {
       if (checkLevel == 1){
           girlAnimator.run(this);
       }else {
           this.renderer = femaleAnimator;
           femaleAnimator.run(this);
       }
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        instanceFemale = this;
        eatHeart();
        castPoop();
        animate();
        Player.femaleColider = this.boxCollider;
    }
}
