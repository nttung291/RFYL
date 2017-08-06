package game;


import com.google.gson.Gson;
import game.bases.GameObject;
import game.bases.Vector2D;
import game.gson.MapJson;
import game.items.*;
import game.scenes.BackGround;
import game.viewports.ViewPort;
import inputs.InputManager;
import game.player.FemalePlayer;
import game.player.MalePlayer;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;


/**
 * Created by Nttung PC on 8/1/2017.
 */
public class GameWindow extends JFrame {

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphic2D;

    private Player malePlayer;
    private Player femalePlayer;
    InputManager inputManager = InputManager.instance;
    float distance;

    ViewPort maleViewPort;
    ViewPort femaleViewPort;
    ViewPort mainViewPort;

    MapJson readJson = new MapJson();

    private BufferedImage leftBufferImage;
    private BufferedImage rightBufferImage;
    private Graphics2D leftG2d;
    private Graphics2D rightG2d;

    public GameWindow() {
        setupWindow();
        setupInput();
        addBackGround();
        readGson();
        addPlayer();
        addIteam();
        addViewPorts();
        setupBackBuffer();
        this.setVisible(true);

    }

    public void readGson(){
        Gson gson = new Gson();
        readJson = gson.fromJson(Utils.loadFileContent("map.json"),MapJson.class);
    }

    public void addIteam(){
       int[][] item = Utils.convert_1D_To_2D(readJson.layers.data,25,200);
       for (int i = 0; i < 20; i++){
           for (int j = 0; j < 200; j++){
               int vt = item[i][j];
               switch (vt){
                   case 1:
                       GameObject.add(new Lava().setPosition(32*j,32*i));
                       break;
                   case 6:
                       GameObject.add(new Banana().setPosition(32*j,32*i));
                       break;
                   case 5:
                       GameObject.add(new Poop().setPosition(32*j,32*i));
                       break;
                   case 2:
                       GameObject.add(new Condom().setPosition(32*j,32*i));
                       break;
                   case 3:
                       GameObject.add(new Heart().setPosition(32*j,32*i));
                       break;
                   case 4:
                       GameObject.add(new Drug().setPosition(32*i,32*j));
                       break;
                   default: break;
               }
           }
       }
    }

    private void addPlayer() {
        malePlayer = Player.createMalePlayer();
        malePlayer.setPlayerMove(new MalePlayer());
        femalePlayer = Player.createFemalePlayer();
        femalePlayer.setPlayerMove(new FemalePlayer());
        GameObject.add(malePlayer.setPosition(20, 500));
        GameObject.add(femalePlayer.setPosition(100, 500));
    }

    public void addBackGround(){
        BackGround backGround = new BackGround();
        GameObject.add(backGround);
    }

    private void setupWindow(){
        this.setSize(1600,800);
        this.setResizable(false);
        this.setTitle("Run for your life");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });
    }

    private void setupBackBuffer() {
        leftBufferImage = new BufferedImage(this.getWidth() / 2, this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        rightBufferImage = new BufferedImage(this.getWidth() / 2, this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        leftG2d = (Graphics2D) leftBufferImage.getGraphics();
        rightG2d = (Graphics2D) rightBufferImage.getGraphics();

        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferImage.getGraphics();
    }

    private void addViewPorts() {
            maleViewPort = new ViewPort();
            maleViewPort.getCamera().follow(malePlayer);
            maleViewPort.getCamera().getOffset().set(getWidth() / 4, 0);

            femaleViewPort = new ViewPort();
            femaleViewPort.getCamera().follow(femalePlayer);
            femaleViewPort.getCamera().getOffset().set(getWidth() / 4, 0);

            mainViewPort = new ViewPort();
            mainViewPort.getCamera().followedObject = new GameObject();
            mainViewPort.getCamera().getOffset().set(getWidth() / 4, 0);


            GameObject.add(maleViewPort.getCamera());
            GameObject.add(femaleViewPort.getCamera());
            GameObject.add(mainViewPort.getCamera());
    }

    long lastUpdateTime;
    public void loop(){
        while(true){
            long curentTime = System.currentTimeMillis();
            if (curentTime - lastUpdateTime > 17){
                lastUpdateTime = curentTime;
                run();
                render();
            }
        }
    }

    private void run() {
        GameObject.runAll();
    }

    private void render() {
        backBufferGraphic2D.setColor(Color.BLACK);
        backBufferGraphic2D.fillRect(0, 0, this.getWidth(), this.getHeight());

        distance = Math.abs(maleViewPort.getCamera().screenPosition.x - femaleViewPort.getCamera().screenPosition.x);
        if (distance > 750){
            maleViewPort.render(leftG2d, GameObject.getGameObjects());
            femaleViewPort.render(rightG2d, GameObject.getGameObjects());
            backBufferGraphic2D.drawImage(leftBufferImage, 0, 0, null);
            backBufferGraphic2D.drawImage(rightBufferImage, getWidth() / 2, 0, null);
            backBufferGraphic2D.drawLine(getWidth()/2,0,getWidth()/2,600);
        }else{
            mainViewPort.render(backBufferGraphic2D,GameObject.getGameObjects());
            mainViewPort.getCamera().followedObject.position.x = (malePlayer.position.x + femalePlayer.position.x)/2;
            backBufferGraphic2D.drawImage(backBufferImage,0,0,null);
        }
        Graphics2D graphics2D = (Graphics2D) this.getGraphics();
        graphics2D.drawImage(backBufferImage,0,0,null);
    }

}
