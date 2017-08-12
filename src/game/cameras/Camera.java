package game.cameras;

import game.bases.Contraints;
import game.bases.GameObject;
import game.bases.Vector2D;

/**
 * Created by Nttung PC on 8/2/2017.
 */
public class Camera extends GameObject {

    public GameObject followedObject;
    private Vector2D offset;
    Contraints contraints;

    public Camera() {
        super();
        offset = new Vector2D();
        contraints = new Contraints(0,800,600,5400);
    }

    public Vector2D getOffset() {
        return offset;
    }

    public Camera follow(GameObject followedObject) {
        this.followedObject = followedObject;
        return this;
    }

    @Override
    public void run(Vector2D parentPosition) {
        if(followedObject != null) {
            this.position.x = followedObject.position.x;
            contraints.make(position);
        }
        super.run(parentPosition);
    }

    public Vector2D translate(Vector2D position) {
        return position.subtract(this.screenPosition.subtract(offset));
    }
}
