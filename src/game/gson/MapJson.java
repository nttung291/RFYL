package game.gson;


import game.gson.Layer;
import game.gson.Tileset;

import java.util.List;

/**
 * Created by Nttung PC on 8/4/2017.
 */
public class MapJson {
    public Integer height;
    public Layer layers;
    public Integer nextobjectid;
    public Integer tileheight;
    public List<Tileset> tilesets;

    @Override
    public String toString() {
        return "MapJson{" +
                "height=" + height +
                ", layers=" + layers +
                ", nextobjectid=" + nextobjectid +
                ", tileheight=" + tileheight +
                ", tilesets=" + tilesets +
                '}';
    }
}
