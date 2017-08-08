package game.bases.renderer;

import game.bases.Vector2D;
import game.cameras.Camera;

import java.awt.*;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public interface Renderer {
    void render(Graphics2D g, Vector2D position, Camera camera);
}
