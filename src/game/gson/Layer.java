package game.gson;

import java.util.ArrayList;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class Layer {
    public ArrayList<Integer> data = null;
    public Integer height;
    public String name;
    public Integer opacity;
    public boolean visible;
    public Integer width;
    public Integer x;
    public Integer y;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", opacity=" + opacity +
                ", visible=" + visible +
                ", width=" + width +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
