import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* A class managing the operations necessary in loading
* and retrieving sprites from a spritesheet.
* @author Savlon from gamedev.stackexchange.com
* Class has been modified from its original form in order
* to better suit our needs.
*/
public class Sprite{

    private static BufferedImage spriteSheet;
    private static int xSize = 32;
    private static int ySize = 32;

    public static BufferedImage loadSprite(String fileName, int new_xSize, int new_ySize){

        xSize = new_xSize;
        ySize = new_ySize;
        BufferedImage sprite = null;
        
        try{
            sprite = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        spriteSheet = sprite;
        return sprite;
    }
    
    public static BufferedImage getSprite(int xGrid, int yGrid){
        if(spriteSheet == null)
            spriteSheet = loadSprite("AnimationSpriteSheet.png",xSize,ySize);
        return spriteSheet.getSubimage(xGrid * xSize, yGrid * ySize, xSize, ySize);
    }

}
