package game.scenes;

/**
 * Created by SNOW on 8/12/2017.
 */
public class SceneManager {
    private Scene currentScene;
    private Scene nextScene;

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    public static final SceneManager instance = new SceneManager();

    public SceneManager(){

    }

    public void changeSceneIfNeeded(){
        if (nextScene != null){
            if (currentScene != null){
                currentScene.deInit();
                nextScene.init();
                currentScene = nextScene;
                nextScene = null;

            }
        }
    }

    public void requestChangeScene(Scene scene){
        if (currentScene == null){
            currentScene = scene;
        }else {
            nextScene = scene;
        }
    }
}
