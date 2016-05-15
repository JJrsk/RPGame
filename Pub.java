import javax.swing.JOptionPane;


public class Pub {

	public static int firstRun = 1;
	public static int option;
	public static Player run(Player player1){
		if(firstRun == 1){
			player1 = welcome(player1);
		}
		
		
		return (player1);
	}
	
	public Player enterance(Player player1){
		option = Integer.parseInt(JOptionPane.showInputDialog("Hey! What do you want to do?\n1.Look at quests\n2.Buy a drink\n3.Rent a room", "Tavern Keep"));
		sif(option == 1){
			
		}else if(option == 2){
			option = Integer.parseInt(JOptionPane.showInputDialog("I hope you're of age, I mean there's no cards in AWE, but ill trust you. What do you want?\n1.Beer - 50 Gold\n2.Wine - 100 gold \n3.Water - 10 gold", "Tavern Keep"));
		}
		
		return player1;
	}
	
	public static Player welcome(Player player1){
		JOptionPane.showMessageDialog(null, "Hey you! Yeah you! Whats your name?" , "Tavern Keep", 1, null);
		JOptionPane.showMessageDialog(null, player1.getName() + " huh? Well hi, my names Gill" , "Gill", 1, null);
		JOptionPane.showMessageDialog(null, "Ill let you look around, when you're ready come back to me and I can give you a quest." , "Gill", 1, null);
		return (player1);
	}
}
