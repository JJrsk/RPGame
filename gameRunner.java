import javax.swing.JOptionPane;


public class gameRunner {

	
	public static void run(){
		int choice = 0;
		
		while(choice != 3){
			choice = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Gils Game player! We have the following games:\n1. Thirteens\n2. Tic Tac Toe\n3. Quit"));
			
			if(choice == 1){
				ThirteenGUIRunner.runGame();
				if(Dock.canFindCecil){
					JOptionPane.showMessageDialog(null, "After playing a game a hooded figure approaches.");
					JOptionPane.showMessageDialog(null, "You've done the task, in the pace with flasks, now you need to say the key.\nGo to the docks, and to undo the locks, by saying the code word:", "Random Captain", 1, null);
					JOptionPane.showMessageDialog(null, "Before the figure can tell you the key, a bar fight erupts! Better get going before you get yourself in trouble.\nMaybe there's a clue to the key around the docks or ocean.");
					Player.locationCanGo[3] = true;
				}
			}else if(choice == 2){
				WithoutCrazyStuff.run();
			}
		}
	}
	
	
}
