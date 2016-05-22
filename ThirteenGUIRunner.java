/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ThirteenGUIRunner {

	
	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void runGame(){
		Board board = new ThirteensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
		while(gui.running){
			try {
			    Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}

}
