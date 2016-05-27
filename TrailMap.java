import java.awt.image.BufferedImage;

/**
 * A Map corresponding to the upper left-hand corner of
 * the complete game map, where the player initially spawns.
 */

public class TrailMap extends Map{

    public TrailMap(){
        super();
        Sprite.loadSprite("NEW SCIOLY LOGO.png",0,0);
        BufferedImage[] bi = {Sprite.getSprite(2,1),Sprite.getSprite(1,2)};
        addEntity(new Enviro(bi,50,100));
    }

    public Location getExitLocation(){
    	if(this.getPlayer().getX() < 0)
    		return new Pub();
    	else if(this.getPlayer().getX() > this.getWidth())
    		return new Dock();
    	else
    		return null;
    }

}
