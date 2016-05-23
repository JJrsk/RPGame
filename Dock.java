import javax.swing.JOptionPane;


public class Dock {

	
	public static boolean cecil = false;
	public static boolean canFindCecil = false;
	
	public static Player run(Player player1){
		int choice = 0;
		while(choice<=0 || choice >= 5){
			choice = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the docks! What would you like to do?\n1. " + foundCecil() +"\n2. Fish\n3. Go to the ocean\n4. Go to the trail" ));
		}

		//1 Talk to Cecil
		//2 Fish
		//3 Go to ocean
		//4 Go to trail
		if(choice == 1){
			player1 = cecil(player1);
		}else if(choice == 2){
			player1 = fish(player1);
		}else if(choice == 3){
			if(Player.locationCanGo[3]){
				JOptionPane.showMessageDialog(null, "You rent a boat from a man at the docks.");
				if(player1.getGold()>=2){
					JOptionPane.showMessageDialog(null, "You have been charged 2 gold");
				}else{
					JOptionPane.showMessageDialog(null, "Seeing your low economic state, the man gives you the boat for free!");
				}
				player1.setCurrentLocation(4);
			}else{
				JOptionPane.showMessageDialog(null, "Hey look, im sorry, but you cant go here yet!\nIt's for your own saftey, I promise!", "Random Captain", 1, null);
			}
		}else if(choice == 4){
			if(Player.locationCanGo[1]){
				player1.setCurrentLocation(2);
			}else{
				JOptionPane.showMessageDialog(null, "Hey look, im sorry, but you cant go here yet!\nIt's for your own saftey, I promise!", "Random Captain", 1, null);
			}
		}
		
		return(player1);
	}
	
	
	
	private static Player cecil(Player player1) {
		if(cecil){
		}else{
			findCecilGame();
		}
		return(player1);
	}



	private static void findCecilGame() {
			JOptionPane.showMessageDialog(null, "You approach a small house boat locked up with a note attached to the door.\nIt appears to be clue.");
			JOptionPane.showMessageDialog(null, "A drink is what I need. But often comes a game with threes. You play the game, then ill know your name, and then you can meet with me.\n Huh. I wonder what that means.");
			canFindCecil = true;
		
	}



	private static String foundCecil() {
		if(cecil){
			return("Talk to cecil");
		}else{
			return("Find cecil");
		}
	}



	public static Player fish(Player player1){
		int choice = 0;
		int[] fishing = new int[(int)player1.getLuck()/5];
		int chance = player1.getLuck()/5;
		int gainedHp;
		boolean gotOne = false;
		String location = "";
		int temp = -1;
		
		if(player1.getGold()>=0){
			while(choice <=0 || choice >=10){
				choice = Integer.parseInt(JOptionPane.showInputDialog("You go to cast your line. You see nine promising areas for fishing.\n Please input a number between 1 and 9 inclusive to indicate where you want to fish."));
			}
			
			for(int i = 0; i<chance; i++){
				temp = -1;
				temp = (int) (Math.random()*9 + 1);
				for(int j: fishing){
					try{
						if(fishing[j] == temp){
							temp = -1;
						}
					}catch (IndexOutOfBoundsException e) {
						
					}
				}
				
				if(temp == -1){
					i--;
				}else{
					fishing[i] = temp;
				}
			}
			
			
			for(int i: fishing){
				location += i + " ";
				if(i == choice){
					if(player1.getCurrentHealth()+4<=player1.getHealth()){
						player1.setCurrentHealth(4);
						gainedHp = 4;
					}else{
						gainedHp = player1.getHealth() - player1.getCurrentHealth();
						player1.setCurrentHealth(player1.getHealth());
					}
					JOptionPane.showMessageDialog(null, "You've caught a fish! You gained two gold and " + gainedHp + " health points!");
					player1.setGold(2);
					gotOne = true;
				}
			}
			player1.setGold(-1);
		
			if(!gotOne){
				JOptionPane.showMessageDialog(null, "Luck was not in your favor! The fish were at: " + location);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Error, no gold to buy bait.");
		}
		return player1;
	}
	
	
	
	//can talk to guy or fish, fish is based off luck, 5 points = 1 fish out of nine, rewards 2 gold and 4 HP
}
