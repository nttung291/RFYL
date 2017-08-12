package game.scenes;

import com.google.gson.Gson;
import game.GameWindow;
import game.Utils;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.gson.MapJson;
import game.items.*;
import game.player.FemalePlayer;
import game.player.MalePlayer;
import game.player.Player;
import game.viewports.ViewPort;

import static game.GameWindow.checkLevel;
import static game.GameWindow.endTime1;

/**
 * Created by SNOW on 8/12/2017.
 */
public class Level1Scene extends Scene {
    public Player malePlayer;
    public Player femalePlayer;
    MapJson readJson = new MapJson();

    @Override
    public void init() {
        addBackGround();
        readGson();
        addIteam();
        addPlayer();
        addViewPorts();
        checkLevel = 1;
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

    public void readGson(){
        Gson gson = new Gson();
        readJson = gson.fromJson(Utils.loadFileContent("map.json"),MapJson.class);
    }

    private void addViewPorts() {
        GameWindow.maleViewPort.getCamera().follow(MalePlayer.instanceMale);
        GameWindow.maleViewPort.getCamera().getOffset().set(400, 0);

        GameWindow.femaleViewPort = new ViewPort();
        GameWindow.femaleViewPort.getCamera().follow(FemalePlayer.instanceFemale);
        GameWindow.femaleViewPort.getCamera().getOffset().set(400, 0);

        GameWindow.mainViewPort = new ViewPort();
        GameWindow. mainViewPort.getCamera().followedObject = new GameObject();
        GameWindow.mainViewPort.getCamera().getOffset().set(600, 0);


        GameObject.add(GameWindow.maleViewPort.getCamera());
        GameObject.add(GameWindow.femaleViewPort.getCamera());
        GameObject.add(GameWindow.mainViewPort.getCamera());
    }

    public void addIteam(){
        int[][] item = Utils.convert_1D_To_2D(readJson.layers.data,25,200);
        for (int i = 0; i < 25; i++){
            for (int j = 0; j < 200; j++){
                int vt = item[i][j];
                switch (vt){
                    case 1:
                        GameObject.add(new Lava().setPosition(32*j,32*i+10));
                        break;
                    case 4:
                        GameObject.add(new Banana().setPosition(32*j,32*i+10));
                        break;
                    case 5:
                        GameObject.add(new Poop().setPosition(32*j,32*i+10));
                        break;
                    case 2:
                        GameObject.add(new Heart().setPosition(32*j,32*i+10));
                        break;
                    case 3:
                        GameObject.add(new Drug().setPosition(32*j,32*i+10));
                        break;
                    default: break;
                }
            }
        }
    }

    private void addPlayer() {
        malePlayer = new Player().createMalePlayer();
        femalePlayer = Player.createFemalePlayer();
        GameObject.add(malePlayer.setPosition(100, 670));
        GameObject.add(femalePlayer.setPosition(300, 670));
    }

    public void nextSence(){
        endTime1 = System.currentTimeMillis();
        GameWindow.currentTime2 = endTime1;
        SceneManager.instance.requestChangeScene(new Level2Scene());
    }
}
