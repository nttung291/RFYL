package game.bases;


import game.bases.physics.Physicbody;
import game.bases.physics.Physics;
import game.cameras.Camera;
import game.bases.renderer.Renderer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public class GameObject {
    public Vector2D position;
    public Vector2D screenPosition;
    public Renderer renderer;
    public Vector<GameObject> children;
    public boolean isActive;

    public static Vector<GameObject> gameObjects = new Vector<>();
    public static Vector<GameObject> newGameObjects = new Vector<>();

    public GameObject() {
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
        this.renderer = null;
        isActive = true;
    }

    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
        if (gameObject instanceof Physicbody){
            Physics.add((Physicbody) gameObject);
        }
    }

    public static void runAll(){
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive)
                gameObject.run(Vector2D.ZERO);
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }
    public void run(Vector2D parentPosition){
        this.screenPosition = parentPosition.add(position);
        for (GameObject child : children){
            child.run(this.screenPosition);
        }
    }

    public GameObject setPosition(float x, float y) {
        this.position.set(x, y);
        return this;
    }

    public static Vector<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void render(Graphics2D g2d, Camera camera) {
        if (renderer != null && this.isActive) {
            renderer.render(g2d, this.screenPosition, camera);
        }
        for (GameObject child: children) {
            child.render(g2d, camera);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void  refresh(){
        isActive = true;
    }

    public static void clear(){
        gameObjects.clear();
        Physics.clear();
    }
}
