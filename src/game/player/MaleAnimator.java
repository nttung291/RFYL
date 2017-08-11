package game.player;

import game.Utils;
import game.bases.Vector2D;
import game.bases.renderer.Animation;
import game.bases.renderer.Renderer;
import game.cameras.Camera;
import inputs.InputManager;

import java.awt.*;

/**
 * Created by Administrator on 7/30/2017.
 */
public class MaleAnimator implements Renderer {

    public Animation jumpLeftAnimation;
    public Animation jumpRightAnimation;
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation standleftAnimation;
    public Animation standrightAnimation;
    public Animation throwshitleft;
    public Animation throwshitright;
    public Animation fallingleft;
    public Animation fallingright;
    public Animation currenAnimation;

    public MaleAnimator() {
        leftAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/maleplayer/runleft/img1.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img2.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img3.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img4.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img5.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img6.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img7.png"),
                Utils.loadImage("assets/images/maleplayer/runleft/img8.png")

        );

        rightAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/maleplayer/runright/img1.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img2.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img3.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img4.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img5.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img6.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img7.png"),
                Utils.loadImage("assets/images/maleplayer/runright/img8.png")
                );
        standleftAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/maleplayer/standleft/img1.png"),
                Utils.loadImage("assets/images/maleplayer/standleft/img2.png")
        );

        standrightAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/maleplayer/standright/img1.png"),
                Utils.loadImage("assets/images/maleplayer/standright/img2.png")
        );

        jumpRightAnimation = new Animation(
                Utils.loadImage("assets/images/maleplayer/jumpright/img1.png")
        );

        jumpLeftAnimation = new Animation(
                Utils.loadImage("assets/images/maleplayer/jumpleft/img4.png")
        );

        throwshitleft = new Animation(1,true,
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img1.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img2.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img3.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img4.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img5.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img6.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitleft/img7.png")
        );

        throwshitright = new Animation(1,true,
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img1.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img2.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img3.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img4.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img5.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img6.png"),
                Utils.loadImage("assets/images/maleplayer/throwshit/throwshitright/img7.png")
        );

        fallingleft = new Animation(2,true,
                Utils.loadImage("assets/images/maleplayer/fallingleft/img1.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img2.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img3.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img4.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img6.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img7.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img8.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img9.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img10.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img11.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img12.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img13.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img14.png"),
                Utils.loadImage("assets/images/maleplayer/fallingleft/img15.png")
        );
        fallingright = new Animation(2,true,
                Utils.loadImage("assets/images/maleplayer/fallingright/img1.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img2.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img3.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img4.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img6.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img7.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img8.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img9.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img10.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img11.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img12.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img13.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img14.png"),
                Utils.loadImage("assets/images/maleplayer/fallingright/img15.png")
        );
        currenAnimation = standrightAnimation;
    }
    public int check = 0;
    public void run(Player player) {
        if (MalePlayer.instanceMale.bananaStand){
            if (check == 1){
                currenAnimation = fallingleft;
            }else{
                currenAnimation = fallingright;
            }
        }
        else if(InputManager.instance.mPressed) {
            if (MalePlayer.instanceMale.position.x - FemalePlayer.instanceFemale.position.x > 0) {
                currenAnimation = throwshitleft;
            }else{
                currenAnimation = throwshitright;
            }
        }
        else if (player.velocity.x > 0){
            check = 2;
            currenAnimation = rightAnimation;
            if (player.velocity.y < 0) {
                currenAnimation = jumpRightAnimation;
            }
        }
        else if (player.velocity.x < 0) {
            check = 1;
            currenAnimation = leftAnimation;
            if (player.velocity.y < 0){
                currenAnimation = jumpLeftAnimation;
            }
        }
        else {
            if (check == 1){
                currenAnimation = standleftAnimation;
            }else{
                currenAnimation = standrightAnimation;
            }
        }
    }

    @Override
    public void render(Graphics2D g, Vector2D position, Camera camera) {
        if (currenAnimation != null) {
            currenAnimation.render(g,position,camera);
        }
    }
}
