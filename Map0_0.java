
/**
 * A Map corresponding to the upper left-hand corner of
 * the complete game map.
 */

public class Map0_0 extends Map{

    public Map0_0{
        super();
        Sprite.loadSprite("NEW SCIOLY LOGO.png");
        addEntity(new Enviro(Sprite.getSprite(2,1)),50,100);
    }

    public void createPlayer(){
        
    }
}
