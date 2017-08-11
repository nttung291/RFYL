package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nttung PC on 8/1/2017.
 */
public class Utils {
    public static BufferedImage loadImage(String url){
        try {
            return  ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String loadFileContent(String url) {
        File file = new File(url);
        FileInputStream fis = null;
        String content = null;
        try {
            fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            content = new String(data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static int[][] convert_1D_To_2D(ArrayList<Integer> array, final int cows, final int cols) {
        int[][] arr2d = new int[cows][cols];
        int sz=0;
        for ( int i = 0; i < cows; i++ ) {
            for (int j = 0; j< cols ; j++){
                if (sz < array.size()){
                    arr2d[i][j] = array.get(sz);
                    sz++;
                }
            }
        }

        return arr2d;
    }
}
