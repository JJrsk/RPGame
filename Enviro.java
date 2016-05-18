import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * An Entity representing a stationary environmental object, such
 * as a tree or house, which cannot be interacted with.
 */

public class Enviro extends Entity{
    
    public Enviro(BufferedImage[] bi,int x, int y){
        super(loadAnims(bi),x,y,
                bi[0].getWidth(),bi[0].getHeight());
    }

    private static ArrayList<BufferedImage[]> loadAnims(BufferedImage[] bi){
        ArrayList<BufferedImage[]> anims = new ArrayList<BufferedImage[]>();
        anims.add(bi);
        
        return anims;
    }

    public void move(){
        //trees don't move stupid
    }

    public void collide(Entity other){
        if(other instanceof Player)
            other.collide(this); //I should really just put that code here
    }
}
