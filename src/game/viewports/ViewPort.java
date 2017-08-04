package game.viewports;

import game.cameras.Camera;
import game.bases.GameObject;

import java.awt.*;

/**
 * Created by Nttung PC on 8/3/2017.
 */
public class ViewPort {
    private boolean isHidden;
    private Camera camera;

    public ViewPort() {
        camera = new Camera();
    }

    public Camera getCamera() {
        return camera;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void render(Graphics2D g, java.util.List<GameObject> gameObjects) {
        if (!isHidden) {
            if (camera != null) {
                for (GameObject gameObject : gameObjects) {
                    gameObject.render(g, camera);
                }
            }
        }
    }
}
