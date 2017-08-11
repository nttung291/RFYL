package game.player;

import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.items.Condom;
import game.items.Lava;
import inputs.InputManager;

import static game.player.FemalePlayer.heart;


/**
 * Created by Nttung PC on 8/3/2017.
 */
public class MalePlayer extends Player{

    boolean bulletDisable;
    FrameCounter cooldownBullet;
    public static int condom=0;
    public static Player instanceMale;
    MaleAnimator maleAnimator;


    public MalePlayer() {
        super();
        this.cooldownBullet = new FrameCounter(5);
        instanceMale = this;
        maleAnimator = new MaleAnimator();
        this.renderer = maleAnimator;
    }

    @Override
    public void move() {
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
//        this.constraints.make(position);
    }

    private void animate() {
        maleAnimator.run(this);
    }

    private void castPoop() {
        if (InputManager.instance.mPressed){
            if (!bulletDisable && bullet > 0){
                if (this.position.x - FemalePlayer.instanceFemale.position.x > 0){
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

    public static boolean hitFemale(){
        FemalePlayer femalePlayer = Physics.bodyInRect(Player.maleColider,FemalePlayer.class);
        if (femalePlayer != null && femalePlayer.isActive && heart < 5){
            return true;
        }
        return false;
    }

    public void eatCondom(){
        Condom eatCondom = Physics.bodyInRect(this.boxCollider,Condom.class);
        if (eatCondom != null && eatCondom.isActive){
            condom++;
            eatCondom.getEat();
        }
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        eatCondom();
        castPoop();
        animate();
        instanceMale = this;
        Player.maleColider = this.boxCollider;
    }
}
