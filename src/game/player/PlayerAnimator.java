package game.player;

import game.Utils;
import game.bases.Vector2D;
import game.bases.renderer.Animation;
import game.bases.renderer.Renderer;
import game.cameras.Camera;

import java.awt.*;

/**
 * Created by Administrator on 7/30/2017.
 */
public class PlayerAnimator implements Renderer {

    public Animation jumpLeftAnimation;
    public Animation jumpRightAnimation;
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation straightAnimation;

    private Animation currenAnimation;

    public PlayerAnimator() {
        leftAnimation = new Animation(
                Utils.loadImage("assets/images/playerboy/left/1.png"),
                Utils.loadImage("assets/images/playerboy/left/2.png"),
                Utils.loadImage("assets/images/playerboy/left/3.png"),
                Utils.loadImage("assets/images/playerboy/left/4.png"),
                Utils.loadImage("assets/images/playerboy/left/5.png"),
                Utils.loadImage("assets/images/playerboy/left/6.png"),
                Utils.loadImage("assets/images/playerboy/left/7.png"),
                Utils.loadImage("assets/images/playerboy/left/8.png"),
                Utils.loadImage("assets/images/playerboy/left/8.png"),
                Utils.loadImage("assets/images/playerboy/left/9.png")

        );

        rightAnimation = new Animation(
                Utils.loadImage("assets/images/playerboy/right/1.png"),
                Utils.loadImage("assets/images/playerboy/right/2.png"),
                Utils.loadImage("assets/images/playerboy/right/3.png"),
                Utils.loadImage("assets/images/playerboy/right/4.png"),
                Utils.loadImage("assets/images/playerboy/right/5.png"),
                Utils.loadImage("assets/images/playerboy/right/6.png"),
                Utils.loadImage("assets/images/playerboy/right/7.png"),
                Utils.loadImage("assets/images/playerboy/right/8.png"),
                Utils.loadImage("assets/images/playerboy/right/9.png")
                );

        straightAnimation = new Animation(
                Utils.loadImage("assets/images/playerboy/straight/0.png")
                );

        jumpRightAnimation = new Animation(
                Utils.loadImage("assets/images/playerboy/right/5.png")
        );

        jumpLeftAnimation = new Animation(
                Utils.loadImage("assets/images/playerboy/left/5.png")
        );
        currenAnimation = straightAnimation;
    }

    public void run(Player player) {
        if (player.velocity.x < 0) {
            currenAnimation = leftAnimation;
            if (player.velocity.y < 0){
                currenAnimation = jumpLeftAnimation;
            }
        }
        else if (player.velocity.x > 0){
            currenAnimation = rightAnimation;
            if (player.velocity.y < 0) {
                currenAnimation = jumpRightAnimation;
            }
        }
        else {
            currenAnimation = straightAnimation;
        }
    }

    @Override
    public void render(Graphics2D g, Vector2D position, Camera camera) {
        if (currenAnimation != null) {
            currenAnimation.render(g,position,camera);
        }
    }
}
