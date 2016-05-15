import javax.swing.JOptionPane;

public class Player extends Organisms {

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
	}

	//Instance
	private int luck;
	private int mana;
	private int strength;
	private int level;
	private int xp;
	private String name;
	
	
	//Methods
	public void Des(){
		JOptionPane.showMessageDialog(null, name + " has the following stats: "+ "\nlevel:" + level  + "\nHealth:" + super.getHealth() + "\nSpeed:" + super.getspeed() + "\nMana:" + mana + "\nLuck:" + luck + "\nStrength:" + strength  , name = " stats", 1, null);
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
				super.setspeed(speedNew);
			}
		}
	}

	//Add Xp
	public void giveXp(int i){
		xp +=i;
		levelUp();
	}

	//All get and set methods
	
	public String getName(){
		return(name);
	}
	
	public void setName(String n){
		name = n;
	}
	
}
