import javax.swing.JOptionPane;

import org.w3c.dom.events.EventException;

import java.lang.*;
public class ProgramRunner {
	
	
	private int turn = 1;
	public int userInput = -1;
	public int catsGame = 0;
	
	
	public void runOne(BoardTicTacToe two){
		AiAttempt three = new AiAttempt();
		
		two.setUp();
		
		while(!two.getWin()){
			if(turn == 1){
				JOptionPane.showMessageDialog(null, "It is your turn" , "Your turn", JOptionPane.INFORMATION_MESSAGE, null);
				
				while(this.userInput<1 || userInput>9 || !(two.valid(userInput))){
					JOptionPane.showMessageDialog(null, "Here is the current board" , "Board Status", JOptionPane.INFORMATION_MESSAGE, null);
					two.getBoard();
					try{
						this.userInput = Character.getNumericValue(JOptionPane.showInputDialog(null, "Where your will symbol go?").charAt(0));
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "ERROR, INPUT NOT VALID" , "ERROR", JOptionPane.ERROR_MESSAGE, null);
						userInput = -91342;
					}
				}
				two.replaceBoard(this.userInput);
				JOptionPane.showMessageDialog(null, "Here is the new board" , "Board Status", JOptionPane.INFORMATION_MESSAGE, null);
				two.getBoard();
				two.sideToSide();
				two.upDown();
				two.diagnol();
				catsGame+=1;
			}else{
				three.run(two);
				two.sideToSide();
				two.upDown();
				two.diagnol();
				catsGame+=1;
			}

			if(two.getWin()){
				if(turn == 1){
					JOptionPane.showMessageDialog(null, "Player 1 has won!" , "WINNER", JOptionPane.INFORMATION_MESSAGE, null);
				}else{
					JOptionPane.showMessageDialog(null, "The computer has won!" , "WINNER", JOptionPane.INFORMATION_MESSAGE, null);
				}
			
			}else if(turn==1){
				turn = 2;
				userInput = -1;
			}else{
				turn = 1;
				userInput = -1;
			}
			
			if(catsGame == 9){
				two.catsGame();
			}
			
		}
	}
}

