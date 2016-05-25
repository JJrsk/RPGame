
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.reflect.Array;

import javax.swing.JOptionPane;

/**
 * A class representing the player character; barebones implementation
 * of Entity right now, but will later be updated with health, exp,
 * etc as instance data.
 */


public class Player extends Entity{
    //you don't need to remember animation indecies if you do this
    private static final int STAND = 4, UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    
    //the side length of our player's sprite in pixels
    private static final int SIZE = 32;

    private static PlayerData player1;
    
	public static Boolean[] locationCanGo = new Boolean[8];

    /**
    * The constructor for Player; assembles the player using the preset
    * spritesheet, this.SIZE, and coordinates passed in by Map. Player.
    * @param x
    *  The starting x-coordinate of the player
    * @param y
    *  The starting y-coordinate of the player
    */
    public Player(int x, int y, PlayerData play){
        super(loadAnims(),x,y,SIZE,SIZE);
        changeAnimation(STAND);
        player1 = play;
        for(int i = 0; i<8; i++){
			locationCanGo[i] = false;
		}
    }

	
    /**
     * The default constructor for player; does the same thing as the
     * overloaded constructor, but uses default coordinates of (0,0)
     */
    public Player(){
        super(loadAnims(),0,0,SIZE,SIZE);
        changeAnimation(STAND);
    }
    


	/**
     * Assembles the BufferedImage[] ArrayList needed by super; as
     * more animations are added, be sure to include their indecies
     * as final int instance data.
     * @return a BufferedImage[] ArrayList corresponding to the animations
     *  to be passed to super.
     */
    private static ArrayList<BufferedImage[]> loadAnims(){
        ArrayList<BufferedImage[]> imgs = new ArrayList<BufferedImage[]>();
        Sprite.loadSprite("PlayerSpriteSheet.png",SIZE,SIZE);
        
        BufferedImage[] walkingLeft =
             {Sprite.getSprite(0, 1), Sprite.getSprite(1, 1), Sprite.getSprite(2, 1)};
        BufferedImage[] walkingRight =
             {Sprite.getSprite(0, 2), Sprite.getSprite(1, 2), Sprite.getSprite(2, 2)};
        BufferedImage[] walkingDown =
             {Sprite.getSprite(0, 0), Sprite.getSprite(1, 0), Sprite.getSprite(2, 0)};
        BufferedImage[] walkingUp =
             {Sprite.getSprite(0, 3), Sprite.getSprite(1, 3), Sprite.getSprite(2, 3)};
        BufferedImage[] standing =
             {Sprite.getSprite(1,0)};
        imgs.add(walkingUp);
        imgs.add(walkingDown);
        imgs.add(walkingLeft);
        imgs.add(walkingRight);
        imgs.add(standing);


        return imgs;
     }
    
    public void move(){
        //required by the Entity superclass, but the player does not move
        //until input is given
    }
    /**
     * Moves the player according to the command passed in and updates
     * the animation accordingly
     * @param command
     *  The string form of the movement command to be executed
     */
    public void move(String command){
        if(command.equals("UP")){
            changeAnimation(UP);
            changePosition(0,-8);
        } else if(command.equals("DOWN")){
            changeAnimation(DOWN);
            changePosition(0,8);
        } else if(command.equals("LEFT")){
            changeAnimation(LEFT);
            changePosition(-8,0);
        } else if(command.equals("RIGHT")){
            changeAnimation(RIGHT);
            changePosition(8,0);
        } else if(command.equals("KEY RELEASED")){
            resetAnimation();
        }
    }

    public void collide(Entity other){
        if(other instanceof Enemy){
            //combat panel to be implemented
        } else if(other instanceof Enviro){
            boolean adjX = Math.abs(this.getX() - other.getX())
                >= Math.abs(this.getY() - other.getY());
            int adj = 0;
            if(adjX){
                if(this.getX() > other.getX())
                    adj = 1;
                else
                    adj = -1;
                while(this.intersects(other))
                    changePosition(adj,0);
            } else {
                if(this.getY() > other.getY())
                    adj = 1;
                else
                    adj = -1;
                while(this.intersects(other))
                    changePosition(0,adj);
            }
        }
    }
    
    public String getName(){
		return(player1.getName());
	}
	
	public void setName(String n){
		player1.setName(n);
	}
	
	public int getGold(){
		return(player1.getGold());
	}
	public void setGold(int i){
		player1.setGold(i);
	}

	public void setCurrentLocation(int i){
		player1.setCurrentLocation(i);
	}
	public int getCurrentLocation(){
		return(player1.getCurrentLocation());
	}
	
	public int getLuck(){
		return player1.getLuck();
	}
	
	public int getHealth(){
		return(player1.getHealth());
	}
	public void setHealth(int i){
		player1.setHealth(i);
	}
	public int getCurrentHealth(){
		return(player1.getCurrentHealth());
	}
	public void setCurrentHealth(int i){
		player1.setCurrentHealth(i);
	}
	public int getResistance(){
		return(player1.getResistance());
	}
	public void setResistance(int i){
		player1.setResistance(i);
	}
	public int getspeed(){
		return(player1.getspeed());
	}
	public void setspeed(int i){
		player1.setspeed(i);;
	}
    
	
	public void Des(){
		player1.Des();
	}
	
	//Needs to find what the scaling should be. Current Values are guessed not balanced
	public void levelUp(){
		player1.levelUp();
	}

        public PlayerData getPlayerData(){
            return player1;
        }
}
