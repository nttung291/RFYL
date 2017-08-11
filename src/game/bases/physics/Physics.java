package game.bases.physics;

import game.bases.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Nttung PC on 7/25/2017.
 */
public class Physics {
    private static Vector<Physicbody> bodies = new Vector<>();

    public static void add(Physicbody body){
        bodies.add(body);
    }

    public static <T extends Physicbody> T bodyInRect(BoxCollider boxCollider, Class<T> classZ){
        for (Physicbody body : bodies){
            if (body.isActive() && body.getBoxCollier().collideWith(boxCollider) && boxCollider.screenPosition.x !=0 && boxCollider.screenPosition.y != 0){
                if (body.getClass() == classZ){
                    return (T) body;
                }
            }
        }
        return null;
    }

    public static <T extends Physicbody> T bodyInRect(Vector2D position, float width, float height, Class<T> classz)
    {
        float left = position.x - width/2;
        float right = position.x + width/2;
        float top = position.y - height/2;
        float bottom = position.y + height/2;

        for (Physicbody body : bodies)
        {
            if (body.isActive() && body.getBoxCollier().collideWith(top, bottom, left, right))
            {
                if (body.getClass() == classz)
                    return (T) body;
            }
        }

        return null;
    }

    public static <T extends Physicbody> List<T> bodiesInRect(Vector2D position, float width, float height, Class<T> classz)
    {
        List<T> gameObjects = new ArrayList<>();
        float left = position.x - width/2;
        float right = position.x + width/2;
        float top = position.y - height/2;
        float bottom = position.y + height/2;

        for (Physicbody body : bodies)
        {
            if (body.isActive() && body.getBoxCollier().collideWith(top, bottom, left, right))
            {
                if (body.getClass() == classz)
                    gameObjects.add((T)body);
            }
        }
        return gameObjects;
    }

    public static void clear(){
        bodies.clear();
    }
}
