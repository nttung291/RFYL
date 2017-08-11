package game.player;

import game.GameWindow;
import game.Utils;
import game.bases.Vector2D;
import game.bases.renderer.Animation;
import game.bases.renderer.Renderer;
import game.cameras.Camera;
import inputs.InputManager;

import java.awt.*;

/**
 * Created by Nttung PC on 8/12/2017.
 */
public class GirlAnimator implements Renderer {
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

    public GirlAnimator() {
        leftAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/girlplayer/runleft/img2.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img3.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img4.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img5.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img6.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img7.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img8.png"),
                Utils.loadImage("assets/images/girlplayer/runleft/img9.png")
        );

        rightAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/girlplayer/runright/img2.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img3.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img4.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img5.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img6.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img7.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img8.png"),
                Utils.loadImage("assets/images/girlplayer/runright/img9.png")
        );
        standleftAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/girlplayer/standleft/img1.png"),
                Utils.loadImage("assets/images/girlplayer/standleft/img2.png")
        );

        standrightAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/girlplayer/standright/img1.png"),
                Utils.loadImage("assets/images/girlplayer/standright/img2.png")
        );

        jumpRightAnimation = new Animation(
                Utils.loadImage("assets/images/girlplayer/jumpright/img5.png")
        );

        jumpLeftAnimation = new Animation(
                Utils.loadImage("assets/images/girlplayer/jumpleft/img5.png")
        );

        throwshitleft = new Animation(1,true,
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img1.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img2.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img3.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img4.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img5.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitleft/img6.png")
        );

        throwshitright = new Animation(1,true,
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img1.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img2.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img3.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img4.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img5.png"),
                Utils.loadImage("assets/images/girlplayer/throwshit/throwshitright/img6.png")
        );

        fallingleft = new Animation(2,true,
                Utils.loadImage("assets/images/girlplayer/fallingleft/img1.png"),
                Utils.loadImage("assets/images/girlplayer/fallingleft/img2.png"),
                Utils.loadImage("assets/images/girlplayer/fallingleft/img3.png"),
                Utils.loadImage("assets/images/girlplayer/fallingleft/img4.png")
        );
        fallingright = new Animation(2,true,
                Utils.loadImage("assets/images/girlplayer/fallingright/img1.png"),
                Utils.loadImage("assets/images/girlplayer/fallingright/img2.png"),
                Utils.loadImage("assets/images/girlplayer/fallingright/img3.png"),
                Utils.loadImage("assets/images/girlplayer/fallingright/img4.png")

        );
        if (GameWindow.checkLevel == 1){
            currenAnimation = standrightAnimation;
        }else{
            currenAnimation = standleftAnimation;
        }
    }
    public int check = 0;

    public void run(Player player) {
        if (FemalePlayer.instanceFemale.bananaStand){
            if (check == 1){
                currenAnimation = fallingleft;
            }else{
                currenAnimation = fallingright;
            }
        }
        else if(InputManager.instance.gPressed) {
            if ( FemalePlayer.instanceFemale.position.x-MalePlayer.instanceMale.position.x > 0) {
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
