package game.scenes;

import game.Utils;
import game.bases.Contraints;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.bases.renderer.ImageRenderer;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public class BackGround extends GameObject{
    public ImageRenderer imageRenderer;
    public static Vector2D velocity;
    public static BackGround instance = new BackGround();

    public BackGround() {
        super();
        this.imageRenderer = new ImageRenderer(Utils.loadImage("assets/images/background/background.png"));
        imageRenderer.anchor.set(0,0);
        this.renderer = imageRenderer;
        velocity = new Vector2D();
        instance = this;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
    }
}
