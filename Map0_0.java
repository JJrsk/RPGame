import java.awt.image.BufferedImage;

/**
 * A Map corresponding to the upper left-hand corner of
 * the complete game map, where the player initially spawns.
 */

public class Map0_0 extends Map{

    public Map0_0(){
        super();
        Sprite.loadSprite("NEW SCIOLY LOGO.png",128,64);
        BufferedImage[] bi = {Sprite.getSprite(2,1),Sprite.getSprite(1,2)};
        addEntity(new Enviro(bi,50,100));
    }

}
