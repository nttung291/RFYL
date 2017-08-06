package game.bases.physics;

import game.bases.Vector2D;

import java.util.Vector;

/**
 * Created by SNOW on 8/5/2017.
 */
public class Physics {
    private static Vector<Physicbody> bodies = new Vector<>();

    public static void add(Physicbody body){
        bodies.add(body);
    }

    public static <T extends Physicbody> T bodyinRed(BoxCollider boxCollider, Class<T> classz){
        for (Physicbody body: bodies){
            if (body.getBoxCollider().collideWidth(boxCollider)){
                if (body.getClass() == classz){
                    return (T) body;
                }
            }
        }
        return null;
    }
}
