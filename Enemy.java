import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * An abstract class intented to represent a basic enemy encounter,
 * including an overworld appearence and the necessary data for a full
 * combat encounter.
 */

public abstract class Enemy extends Entity{
    
    //An arraylist representing the enemies in this Enemy's encounter
    private ArrayList<Enemy> buddies;

    public Enemy(ArrayList<BufferedImage[]> moves, int x, int y,
        int xDim, int yDim, Enemy[] buddies){
        super(moves,x,y,xDim,yDim);
        this.buddies = new ArrayList<Enemy>();
        
        this.buddies.add(this);

        for(Enemy e : buddies)
            this.buddies.add(e);
    }

    public void addBuddy(Enemy e){
        buddies.add(e);
    }
    
}
