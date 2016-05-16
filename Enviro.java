
/**
 * An Entity representing a stationary environmental object, such
 * as a tree or house, which cannot be interacted with.
 */

public class Enviro extends Entity{
    
    public Enviro(BufferedImage bi,int x, int y){
        super(new ArrayList<BufferedImage>({{bi}}),x,y,
                bi.getWidth(),bi.getHeight());
    }

    public void move(){
        //trees don't move stupid
    }

    public void collide(Entity other){
        if(other instanceof Player)
            other.collide(this); //I should really just put that code here
    }
}
