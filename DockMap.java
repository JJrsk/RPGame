import java.awt.image.BufferedImage;

/**
 * A Map corresponding to the first map to the right on
 * the top of the complete game map
 * TODO think of better map descriptions
 * Probably where the first enemy will go
 */

public class DockMap extends Map{

    public DockMap(){
        super();
        Sprite.loadSprite("Willy in the Raw copy.png",128,128);
        BufferedImage[] bi = {Sprite.getSprite(0,0)};
        addEntity(new Enviro(bi,120,40));
    }

    public Location getExitLocation(){
    	if(this.getPlayer().getX() < 0)
    		return new Trail();
    	else
    		return null;
    }


}
