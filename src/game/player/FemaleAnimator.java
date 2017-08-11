package game.player;

import game.Utils;
import game.bases.Vector2D;
import game.bases.renderer.Animation;
import game.bases.renderer.Renderer;
import game.cameras.Camera;
import inputs.InputManager;

import java.awt.*;

/**
 * Created by Nttung PC on 8/11/2017.
 */
public class FemaleAnimator implements Renderer {
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

    public FemaleAnimator() {
        leftAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/femaleplayer/runleft/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img5.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/runleft/img8.png")
        );

        rightAnimation = new Animation(1,true,
                Utils.loadImage("assets/images/femaleplayer/runright/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img5.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/runright/img8.png")
        );
        standleftAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/femaleplayer/standleft/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/standleft/img2.png")
        );

        standrightAnimation = new Animation(10,true,
                Utils.loadImage("assets/images/femaleplayer/standright/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/standright/img2.png")
        );

        jumpRightAnimation = new Animation(
                Utils.loadImage("assets/images/femaleplayer/jumpright/img4.png")
        );

        jumpLeftAnimation = new Animation(
                Utils.loadImage("assets/images/femaleplayer/jumpleft/img4.png")
        );

        throwshitleft = new Animation(1,true,
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img5.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img8.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitleft/img9.png")
        );

        throwshitright = new Animation(1,true,
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img5.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img8.png"),
                Utils.loadImage("assets/images/femaleplayer/throwshit/throwshitright/img9.png")
        );

        fallingleft = new Animation(2,true,
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img8.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img9.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img10.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img11.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img12.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img13.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img14.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingleft/img15.png")
        );
        fallingright = new Animation(2,true,
                Utils.loadImage("assets/images/femaleplayer/fallingright/img1.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img2.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img3.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img4.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img5.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img6.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img7.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img8.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img9.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img10.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img11.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img12.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img13.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img14.png"),
                Utils.loadImage("assets/images/femaleplayer/fallingright/img15.png")

        );
        currenAnimation = standrightAnimation;
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
