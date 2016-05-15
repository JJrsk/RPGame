//Done by Jeremy
//Completed 
import javax.swing.JOptionPane;
public class SetUp {

	//For constructor
	public static int luck = 0;
	public static int mana = 0;
	public static int strength = 0;
	public static int speed = 0;
	public static String name;
	
	//Sets up the player
	public static Player run(){
		//Welcome Statement
		JOptionPane.showMessageDialog(null, "Welcome to the wonderful word of Pokem—n, oh wait I mean Ame.\nFirst things first, you must set up your player" , "Welcome", 1, null);
		
		//Gets name
		name = JOptionPane.showInputDialog("What is your name?");
		
		//Tells about preconditions to distribution of stats
		JOptionPane.showMessageDialog(null, "Next you will distribute your stat points. You have 20 points to give to\nSpeed, Luck, Mana, and Strength. Each stat has a base of 5." , "Stats", 1, null);
	
		//Makes sure all points are used
		while(luck + mana+ strength + speed != 20){
			if(luck + mana + strength + speed > 0 ){
				JOptionPane.showMessageDialog(null, "Please follow the guidelines and hit exactly 20 points used", "Stats", 1, null);
				luck = 0;
				mana = 0;
				strength = 0;
				speed = 0;
			}

			//Gets Luck
			luck = Integer.parseInt(JOptionPane.showInputDialog("How many points should go in to luck?\nPoints remaining:" + (20 - luck - mana - strength - speed)));
			//Gets Mana
			mana = Integer.parseInt(JOptionPane.showInputDialog("How many points should go in to mana?\nPoints remaining:" + (20 - luck - mana - strength - speed)));
			//Gets strength
			strength = Integer.parseInt(JOptionPane.showInputDialog("How many points should go in to strength?\nPoints remaining:" + (20 - luck - mana - strength - speed)));
			//Gets speed
			speed = Integer.parseInt(JOptionPane.showInputDialog("How many points should go in to speed?\nPoints remaining:" + (20 - luck - mana - strength - speed)));
		}
		
		//Creates player1
		Player player1 = new Player(speed, luck, mana, strength, name);
		player1.Des();
		return player1;
	}

}
