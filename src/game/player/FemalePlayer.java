package game.player;

import game.bases.FrameCounter;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.physics.Physics;
import game.items.Heart;
import game.items.Lava;
import inputs.InputManager;
import tklibs.Mathx;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class FemalePlayer extends Player{

    public static int heart=5;
    boolean bulletDisable;
    FrameCounter cooldownBullet;
    public static Player instanceFemale;

    public FemalePlayer() {
        super();
        this.cooldownBullet = new FrameCounter(5);
        instanceFemale = this;
    }

    @Override
    public void move() {
        this.velocity.y += gravity;
        this.velocity.x = 0;
        if (InputManager.instance.aPressed){
            this.velocity.x = -v;
        }

        if (InputManager.instance.dPressed)
            this.velocity.x = v;
        if (InputManager.instance.wPressed) {
            if (Physics.bodyInRect(position.add(0, 1), boxCollider.width, boxCollider.height, Lava.class) != null) {
                this.velocity.y -= 3*v;
            }
        }
        moveHorizontal();
        position.x += velocity.x;

        moveVertical();
        position.y += velocity.y;

    }

    public void eatHeart(){
        Heart eatHeart = Physics.bodyInRect(this.boxCollider, Heart.class);
        if (eatHeart != null && eatHeart.isActive){
            heart--;
            eatHeart.getEat();
        }
    }

    private void castPoop() {
        if (InputManager.instance.gPressed){
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

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        instanceFemale = this;
        eatHeart();
        castPoop();
    }
}
