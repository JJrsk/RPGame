<<<<<<< HEAD
import java.awt.image.BufferedImage;
import java.util.ArrayList;
=======
import java.lang.reflect.Array;

import javax.swing.JOptionPane;
>>>>>>> 96d0edd893e48d3bfc80362bd517830be2c8e3fe

/**
 * A class representing the player character; barebones implementation
 * of Entity right now, but will later be updated with health, exp,
 * etc as instance data.
 */

<<<<<<< HEAD
public class Player extends Entity{
    //you don't need to remember animation indecies if you do this
    private static final int STAND = 4, UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    
    //the side length of our player's sprite in pixels
    private static final int SIZE = 32;

    /**
    * The constructor for Player; assembles the player using the preset
    * spritesheet, this.SIZE, and coordinates passed in by Map.createPlayer.
    * @param x
    *  The starting x-coordinate of the player
    * @param y
    *  The starting y-coordinate of the player
    */
    public Player(int x, int y){
        super(loadAnims(),x,y,SIZE,SIZE);
        changeAnimation(STAND);
    }
=======
	//Constructor
	//Pre condition: l+m+st+sp = 20
	public Player(int sp, int l, int m, int st, String n) {
		super(20, 1, sp + 5);	
		luck = l + 5;
		mana = m + 5;
		strength = st + 5;
		name = n;
		level = 1;
		xp = 0;
		currentLocation = 1;
		gold = 10;
		for(int i = 0; i<8; i++){
			locationCanGo[i] = false;
		}
	}

	//Instance
	public static Boolean[] locationCanGo = new Boolean[8];
	private int luck;
	private int mana;
	private int strength;
	private int level;
	private int xp;
	private String name;
	private int gold;
	private int currentLocation;
	
	//Index, Name, Places it can go to
	//1 Pub (2)
	//2 Trail (1, 8, 6,)
	//3 Mines (6)
	//4 Ocean (8)
	//5 Dungeon (6, 7)
	//6 Mountains (2, 3, 5)
	//7 Alter (Dungeon level 20)
	//8 dock (2, 4)
	
	
	
	
	//Methods
	public void Des(){
		JOptionPane.showMessageDialog(null, name + " has the following stats: "+ "\nlevel:" + level  + "\nMax health:" + super.getHealth() + "\nCurrent health:" + super.getCurrentHealth() + "\nSpeed:" + super.getspeed() + "\nMana:" + mana + "\nLuck:" + luck + "\nStrength:" + strength  , "Stats", 1, null);
	}
	
	//Needs to find what the scaling should be. Current Values are guessed not balanced
	public void levelUp(){
		while(xp>99){
			if(xp/(100*level) >= 1){
				xp -= (100*level);
				level++;
				int strengthNew = 0;
				int manaNew = 0;
				int luckNew = 0;
				int speedNew = 0;
				
				JOptionPane.showMessageDialog(null, "Level up! You are now level "  + level + ". You have 10 points to distribute." , "Level" + level, 1, null);
				
				
				
				while(luckNew + manaNew + strengthNew + speedNew != 10 ){
					if(luckNew + manaNew + strengthNew + speedNew > 0 ){
						JOptionPane.showMessageDialog(null, "Please follow the guidelines and hit exactly 10 points used", "Stats", 1, null);
						 strengthNew = 0;
						 manaNew = 0;
						 luckNew = 0;
						 speedNew = 0;
					}
		
					//Gets Luck
					luckNew = Integer.parseInt(JOptionPane.showInputDialog("How many points should be added to luck?\nCurrent Value:" + luck + "\nPoints remaining:" + (10 - luckNew - manaNew - strengthNew - speedNew)));
					//Gets Mana
					manaNew = Integer.parseInt(JOptionPane.showInputDialog("How many points should be added to mana?\nCurrent Value:" + mana + "\nPoints remaining:" + (10 - luckNew - manaNew - strengthNew - speedNew)));
					//Gets strength
					strengthNew = Integer.parseInt(JOptionPane.showInputDialog("How many points should be added to strength?\n\nCurrent Value:" + strength + "\nPoints remaining:" + (10 - luckNew - manaNew - strengthNew - speedNew)));
					//Gets speed
					speedNew = Integer.parseInt(JOptionPane.showInputDialog("How many points should be added to speed?\n\nCurrent Value:" + super.getspeed() + "\nPoints remaining:" + (10 - luckNew - manaNew - strengthNew - speedNew)));
				}
				
				luck+= luckNew;
				mana += manaNew;
				strength =+ strengthNew;
				super.setHealth(super.getHealth() + 20);
				super.setspeed(speedNew);
			}
		}
	}
>>>>>>> 96d0edd893e48d3bfc80362bd517830be2c8e3fe

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

<<<<<<< HEAD
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
=======
	//All get and set methods
	
	public String getName(){
		return(name);
	}
	
	public void setName(String n){
		name = n;
	}
	
	public int getGold(){
		return(gold);
	}
	public void setGold(int i){
		gold +=i;
	}

	public void setCurrentLocation(int i){
		currentLocation = i;
	}
	public int getCurrentLocation(){
		return(currentLocation);
	}
	
	public int getLuck(){
		return luck;
	}
	
>>>>>>> 96d0edd893e48d3bfc80362bd517830be2c8e3fe
}
