package game.bases.renderer;

import game.bases.FrameCounter;
import game.bases.Vector2D;
import game.cameras.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 7/25/2017.
 */
public class Animation implements Renderer {

    private List<BufferedImage> images;
    private int imageIndex = 0;
    private FrameCounter frameCounter;
    private boolean finished;
    private boolean repeat;
    public Vector2D anchor;
    public Vector2D scale;

    public boolean isFinished() {
        return finished;
    }

    public Animation(int delayFrame, boolean repeat, BufferedImage... imagesArr)
    {
        this.images = Arrays.asList(imagesArr);
        frameCounter = new FrameCounter(delayFrame);
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.scale = new Vector2D(1,1);
        this.repeat = repeat;
    }

    public Animation(BufferedImage... imageArr)
    {
        this(1, true, imageArr);
    }


    private void changeIndex() {

        if (imageIndex >= images.size() - 1)
        {
            if (repeat) {
                imageIndex = 0;
            }
            finished = true;
        } else
        {
            imageIndex++;
        }
    }

    public void reset()
    {
        imageIndex = 0;
        finished = false;
    }


    @Override
    public void render(Graphics2D g, Vector2D position, Camera camera) {
        if (frameCounter.run())
        {
            changeIndex();
            frameCounter.reset();
        }
        BufferedImage image = images.get(imageIndex);
        Vector2D realPosition = position.subtract(image.getWidth() * anchor.x, image.getHeight() * anchor.y);
        Vector2D positionInCamera = camera.translate(realPosition);
        g.drawImage(image, (int) positionInCamera.x, (int) positionInCamera.y, null);
    }
}
