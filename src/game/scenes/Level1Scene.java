package game.scenes;

import game.bases.GameObject;
import game.items.Lava;

/**
 * Created by SNOW on 8/12/2017.
 */
public class Level1Scene extends Scene {
    @Override
    public void init() {
        addBackGround();

    }

    public void addBackGround(){
        BackGround backGround = new BackGround();
        GameObject.add(backGround);
        Lava lavaGround = new Lava();
        lavaGround.renderer = null;
        lavaGround.getBoxCollier().width = 20000;
        lavaGround.setPosition(0,718);
        GameObject.add(lavaGround);
    }
}
