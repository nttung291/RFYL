package game.bases.physics;

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
            if (body.isActive() && body.getBoxCollier().collideWith(boxCollider)){
                if (body.getClass() == classZ){
                    return (T) body;
                }
            }
        }
        return null;
    }

    public static void clear(){
        bodies.clear();
    }
}
