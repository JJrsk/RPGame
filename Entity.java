import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * An abstract class that represents any object which can be interacted
 * with inside a Map. Subclasses are responsible for providing a list of
 * animations, an x and y location, dimensions, and other properties TBD.
 */

public abstract class Entity{
    private int x, y;
   
    /**
     * A Rectangle representing the area taken up by this Entity, used for
     * collision testing.
     */
    private Rectangle region;
    
    /**
     * This Entity's current Animation
     */
    private Animation animation;

    /**
     * An arraylist that holds all the necessary movement animations for an
     * Entity, assembled in the constructor.
     * Make sure moves.get(0) is standing, 1 is moving up, 2 is down, 3 is
     * left, and 4 is right
     */
    private ArrayList<Animation> moves;

    /**
     * The constructor for an Entity
     * @param moves
     *  The BufferedImages to be used to construct this.moves
     * @param x
     *  The x-coordinate of this Entity
     * @param y
     *  The y-coordinate of this Entity
     * @param xDim
     *  The x-dimension (length) of this Entity
     * @param yDim
     *  The y-dimension (height) of this Entity
     */
    public Entity(ArrayList<BufferedImage[]> moves,
            int x, int y, int xDim, int yDim){
        this.x = x;
        this.y = y;
        region = new Rectangle(x, y, xDim, yDim);
        
        this.moves = new ArrayList<Animation>();

        for(BufferedImage[] biArray : moves)
            this.moves.add(new Animation(biArray,20));
        this.animation = this.moves.get(0);
    }
    
    /**
     * A method to update the position and animation of this Entity.
     */
    public abstract void move();

    /**
     * Handles the collision between two entities
     */
    public abstract void collide(Entity other);

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Rectangle getRegion(){
        return this.region;
    }

    /**
     * Determines whether this and another Entity intersect.
     * @param other
     *  The other entity being compared to
     * @return Whether the two Entities overlap
     */
    public boolean intersects(Entity other){
        return this.region.intersects(other.getRegion());
    }

    public void update(){
        this.move();
        this.animation.update();
    }

    public Animation getAnimation(){
        return this.animation;
    }

    /**
     * Increases the Entity's position by dx and dy. Provides a way for
     * subclasses to implement this.move effectively.
     * @param dx
     *  The change in the x-position of this Entity
     * @param dy
     *  The change in the y-position of this Entity
     */
    public void changePosition(int dx, int dy){
        this.x += dx;
        this.y += dy;
        region = new Rectangle(this.x,this.y,region.width,region.height);
    }

    /**
     * Changes this Entity's current animation
     * @param newAnim
     *  The index (in this.moves) of the new animation
     */
    public void changeAnimation(int newAnim){
        this.animation = this.moves.get(newAnim);
        this.animation.start();
    }

    public void resetAnimation(){
        this.animation.reset();
    }

    public int getWidth(){
        return region.width;
    }

    public int getHeight(){
        return region.height;
    }

}

