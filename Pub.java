import javax.swing.JOptionPane;

//pub class done

public class Pub {

	public static int firstRun = 1;
	public static int option;
	public static int option2;
	public static Player run(Player player1){
		if(firstRun == 1){
			player1 = welcome(player1);
		}else{
			player1 = enterance(player1);
		}
		
		
		return (player1);
	}
	
	public static Player enterance(Player player1){
		int i = 0;
		
		option = Integer.parseInt(JOptionPane.showInputDialog("Hey! What do you want to do?\n1. Look at quests\n2. Buy a drink\n3. Rent a room\n4. See your stats\n5. Play a game\n6. Leave"));
		if(option == 1){
			player1 = Quests.run(player1);
		}else if(option == 2){
			option2 = Integer.parseInt(JOptionPane.showInputDialog("I hope you're of age, I mean there's no cards in AWE, but ill trust you. What do you want?\n1.Beer - 50 Gold\n2.Wine - 100 gold \n3.Water - 10 gold"));
				if(option2 == 1){
					if(player1.getGold()>=50){
						player1.setGold(-50);
						if(player1.getCurrentHealth() + 6 <= player1.getHealth()){
							player1.setCurrentHealth(6);
							i = 6;
						}else{
							i = player1.getHealth() - player1.getCurrentHealth();
							player1.setCurrentHealth(player1.getHealth());
						}
						JOptionPane.showMessageDialog(null, "Hey slow down there! You really know how to down a drink" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);
					}
				}else if(option2 == 2){
					if(player1.getGold()>=100){
						player1.setGold(-100);
						if(player1.getCurrentHealth() <= (player1.getHealth() - 14)){
							player1.setCurrentHealth(14);
							i = 14;
						}else{
							i = player1.getHealth() - player1.getCurrentHealth();
							player1.setCurrentHealth(player1.getHealth());
						}
						player1.setCurrentHealth(14);
						JOptionPane.showMessageDialog(null, "Hey slow down there! You really know how to down a drink" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);

					}
				}else if(option2 == 3){
					if(player1.getGold()>=10){
						player1.setGold(-10);
						if(player1.getCurrentHealth()<player1.getHealth()){
							player1.setCurrentHealth(1);
							i = 1;
						}else{
							i = 0;
						}
						
						JOptionPane.showMessageDialog(null, "Im proud of you with sticking to water" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);
					}
				}
		}else if(option == 3){
			option2 = Integer.parseInt(JOptionPane.showInputDialog("I offer cheap rooms starting at 250 a night. The following are the options:\n1.Basic room - 250 gold, refunds 1/4 of your health\n2.Delux room - 400 gold, refunds 1/2 of your health.\n3.Ultra room - 700 gold, refunds all of your health"));
				if(option2 == 1){
					if(player1.getGold()>=250){
						player1.setGold(-250);
						if(player1.getCurrentHealth()*1.25 <= player1.getHealth()){
							i = (int)(player1.getCurrentHealth()*.25);
							player1.setCurrentHealth(i);
						}else{
							i = player1.getHealth() - player1.getCurrentHealth();
							player1.setCurrentHealth(player1.getHealth());
						}
						JOptionPane.showMessageDialog(null, "Wow you sure slept for a long time!" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);
					}
				}else if(option2 == 2){
					if(player1.getGold()>=450){
						player1.setGold(-450);
						if(player1.getCurrentHealth()*1.5 <= player1.getHealth()){
							i = (int)(player1.getCurrentHealth()*.5);
							player1.setCurrentHealth(i);
						}else{
							i = player1.getHealth() - player1.getCurrentHealth();
							player1.setCurrentHealth(player1.getHealth());
						}
						JOptionPane.showMessageDialog(null, "Wow you sure slept for a long time!" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);
					}
				}else if(option2 == 3){
					if(player1.getGold()>=700){
						player1.setGold(-700);
						player1.setCurrentHealth(player1.getHealth());
						JOptionPane.showMessageDialog(null, "Wow you sure slept for a long time!" , "Tavern Keep", 1, null);
						JOptionPane.showMessageDialog(null, "You have gained " + i + " health\nYou now have "+player1.getCurrentHealth() + " health." , "Player Info", 1, null);
					}
				}
		}else if(option == 4){
			player1.Des();
		}else if(option == 5){
			gameRunner.run();
		}else if(option == 6){
			if(firstRun < 3){
				JOptionPane.showMessageDialog(null, "I dont think you should be leaving the pub for the first time without a quest!" , "Gill", 1, null);	
			}else if(Player.locationCanGo[1] = true){
				player1.setCurrentLocation(2);
			}
		}	
		return player1;
	}
	
	public static Player welcome(Player player1){
		JOptionPane.showMessageDialog(null, "Hey you! Yeah you! Whats your name?" , "Tavern Keep", 1, null);
		JOptionPane.showMessageDialog(null, player1.getName() + " huh? Well hi, my names Gill" , "Gill", 1, null);
		JOptionPane.showMessageDialog(null, "Ill let you look around, when you're ready come back to me and I can give you a quest." , "Gill", 1, null);
		firstRun = 2;
		return (player1);
	}


}
