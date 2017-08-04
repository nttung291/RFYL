package game.bases;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public class Vector2D {
    public float x;
    public float y;
    public static final Vector2D ZERO = new Vector2D(0,0);
    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public  Vector2D() {
        this(0, 0);
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D vector2D) {
        this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D) {
        return add(vector2D.x, vector2D.y);
    }

    public float magnitude() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public Vector2D multiply(float f) {
        return new Vector2D(this.x*f,this.y*f);
    }

    public Vector2D nomalize() {
        float mag = this.magnitude();
        return new Vector2D(this.x / mag, this.y / mag);
    }

    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }

    public Vector2D invert() {
        return new Vector2D(this.x * (-1), this.y * (-1));
    }

    public Vector2D subtract(Vector2D vector2D) {
        return subtract(vector2D.x,vector2D.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D vector2D) {
        set(vector2D.x, vector2D.y);
    }

    public Vector2D turn(float p){
        return new Vector2D((float)(x*Math.cos(p)-y*Math.sin(p)),(float)(x*Math.sin(p) + y*Math.cos(p)));
    }
    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
