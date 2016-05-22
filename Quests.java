import javax.swing.JOptionPane;


public class Quests {


	public static boolean questOneGot = false;
	public static boolean questTwoGot = false;
	public static boolean questThreeGot = false;
	public static boolean questFourGot = false;
	public static boolean questFiveGot = false;
	public static boolean onGoingQuest = false;
	
	public static boolean questOneComplete = false;
	public static boolean questTwoComplete = false;
	public static boolean questThreeComplete = false;
	public static boolean questFourComplete = false;
	public static boolean questFiveComplete = false;
	
	
	public static Player run(Player player1){
		int choice = 0;
		while(choice!=4){
			choice = Integer.parseInt(JOptionPane.showInputDialog("You came to the right place for all thing quests! Please enter one of the following:\n1. Get a new quest\n2. Look at current quest\n3. Turn in quest\n4. Quit"));
			if(choice == 1){
				if(onGoingQuest){
					JOptionPane.showMessageDialog(null, "Please complete your ongoing quest first!");
				}else{
					Quests.getQuest();
				}
			}else if(choice == 2){
				if(onGoingQuest){
					Quests.getQuest();
				}else{
					JOptionPane.showMessageDialog(null, "Please get a new quest first!");
				}
			}else if(choice == 3){
				
			}else if(choice != 4){
				JOptionPane.showMessageDialog(null, "Invalid option!");
			}
		}
		return(player1);
	}
	
	
	public static void getQuest(){
		if(questOneComplete){
			if(questTwoComplete){
				if(questThreeComplete){
					if(questFourComplete){
						if(questFiveComplete){
							
						}else{
							questFive();
						}
					}else{
						questFour();
					}
				}else{
					questThree();
				}
			}else{
				questTwo();
			}
		}else{
			questOne();
		}
	}
	
	public static void turnInQuest(){
		
	}
	public static void updateQuests(){
		
	}
	public static void questOne(){
		//Conditions, go to docks and talk to Cecil.
		//Done
		questOneGot = true;
		onGoingQuest = true;
		JOptionPane.showMessageDialog(null, "Adventure needed! Fisherman Cecil has not been heard from in 20 days.\nA hefty reward of 20 gold peices will be given if you can locate him! He should be at the docks");
		Pub.firstRun++;
		Player.locationCanGo[7] = true;
		Player.locationCanGo[1] = true;
	}
	
	private static void questTwo() {
		
		
	}
	
	private static void questThree() {
		
		
	}
	
	private static void questFour() {
		
		
	}
	
	private static void questFive() {
		
		
	}
}
