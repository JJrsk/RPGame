import javax.swing.JOptionPane;


public class trail {

	public static Player run(Player player1) {
	
		int choice = 0;
	while(player1.getCurrentLocation() == 2){
		while (choice<=0 || choice >=4){
			//1 == pub(1/0)
			//2 == docks (8/7)
			//3 == mountains (6/5)
			choice = Integer.parseInt(JOptionPane.showInputDialog("The sign on the trail has the following directions\n1. Pub\n2. Docks\n3. Mountains"));
			//Gets
		}
		if(choice == 1){
			if(Player.locationCanGo[0] == true){
				player1.setCurrentLocation(1);
			}else{
				JOptionPane.showMessageDialog(null, "Hey look, im sorry, but you cant go here yet!\nIt's for your own saftey, I promise!", "Random Hiker", 1, null);
				choice = 0;
			}
		}else if(choice == 2){
			if(Player.locationCanGo[7] == true){
				player1.setCurrentLocation(8);
			}else{
				JOptionPane.showMessageDialog(null, "Hey look, im sorry, but you cant go here yet!\nIt's for your own saftey, I promise!", "Random Hiker", 1, null);
				choice = 0;
			}
		}else if(choice == 3){
			if(Player.locationCanGo[5] == true){
				player1.setCurrentLocation(6);
			}else{
				JOptionPane.showMessageDialog(null, "Hey look, im sorry, but you cant go here yet!\nIt's for your own saftey, I promise!", "Random Hiker", 1, null);
				choice = 0;
			}
		}
	}
	return(player1);	
	
	}

}
