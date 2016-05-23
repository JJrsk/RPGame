import javax.swing.JOptionPane;


public class BoardTicTacToe {

	private boolean win = false;
	private char turn = 'o';
	
	char[] boardT = new char[9];
	
	public void setUp(){
		for(int i=0; i<9; i++){
			boardT[i] = "-".charAt(0);
		}
		win = false;
		turn = 'o';
	}
	
	public void getBoard(){
		
		
		JOptionPane.showMessageDialog(null, "" + boardT[0] + boardT[1] + boardT[2] + "    1" + "2" + "3" +
		"\n" + boardT[3] + boardT[4] + boardT[5] +  "    4" + "5" + "6" +
		"\n" + boardT[6] + boardT[7] + boardT[8] + "    7" + "8" + "9");	
	}
	
	public void sideToSide(){
		for(int i = 0; i<7; i+=3){
			if(boardT[i]==boardT[i+1] && boardT[i] == boardT[i+2] && boardT[i] != '-'){
				this.win = true;
			}
		}
	}

	public void upDown(){
		for(int i = 0; i<3; i++){
			if(boardT[i]==boardT[i+3] && boardT[i] == boardT[i+6] && boardT[i] != '-'){
				this.win = true;
			}
		}
	}
		
	public void diagnol(){
		
			if(boardT[0] == boardT[4] && boardT[0] == boardT[8] && boardT[0] != '-'){
				this.win = true;
			}else if(boardT[2] == boardT[4] && boardT[2] == boardT[6] && boardT[2] != '-'){
				this.win = true;
				
			}
		}

	public boolean getWin(){
		return(win);
	}
	
	public void replaceBoard(int i){
		if(boardT[i-1] == "-".charAt(0)){
			boardT[i-1] = turn;
			if(turn == 'o'){
				turn = 'x';
			}else{
				turn = 'o';
			}
		}else{
			JOptionPane.showMessageDialog(null, "Invalid Location", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}
	}

	public char getTurn(){

		return(turn);
	}
	
	public boolean valid(int userInput) {
		if(userInput>=1 && userInput<=9){
			if(boardT[userInput-1] != 'x' && boardT[userInput-1] !='o'){
				return(true);
			}else{
				return(false);
			}
		}else{
			return(false);
		}
	}

	public int sideToSideAI(){
		
		int j = -1;
		
		for(int i = 0; i<7; i+=3){
			if((boardT[i]==boardT[i+1]) && boardT[i+2] == '-' && boardT[i] == 'x'){
				j = (i+3);
			}else if((boardT[i] == boardT[i+2]) && boardT[i+1] == '-'  && boardT[i] == 'x'){
				j = (i+2);
			}else if((boardT[i+1] == boardT[i+2]) && boardT[i] == '-'  && boardT[i+1] == 'x'){
				j = (i+1);
			}
		}
		if(j!=-1){
			return(j);
		}
		
		for(int i = 0; i<7; i+=3){
			if((boardT[i]==boardT[i+1]) && boardT[i+2] == '-' && boardT[i] == 'o'){
				j = (i+3);
			}else if((boardT[i] == boardT[i+2]) && boardT[i+1] == '-'  && boardT[i] == 'o'){
				j = (i+2);
			}else if((boardT[i+1] == boardT[i+2]) && boardT[i] == '-'  && boardT[i+1] == 'o'){
				j = (i+1);
			}
		}
		System.out.print(j);
		return(j);
	}
	
	public int upDownAI(){
		
		int temp = -1;
		
		for(int i = 0; i<3; i++){
			if((boardT[i]==boardT[i+3]) && boardT[i+6] == '-'  && boardT[i] == 'x'){
				temp = (i+7);
			}else if((boardT[i] == boardT[i+6]) && boardT[i+3] == '-'  && boardT[i+6] == 'x'){
				temp = (i+4);
			}else if((boardT[i+3] == boardT[i+6]) && boardT[i] == '-'  && boardT[i+6] == 'x'){
				temp = (i+1);
			}
		}
		if(temp!=-1){
			return(temp);
		}
		
		for(int i = 0; i<3; i++){
			if((boardT[i]==boardT[i+3]) && boardT[i+6] == '-'  && boardT[i] == 'o'){
				temp = (i+7);
			}else if((boardT[i] == boardT[i+6]) && boardT[i+3] == '-'  && boardT[i+6] == 'o'){
				temp = (i+4);
			}else if((boardT[i+3] == boardT[i+6]) && boardT[i] == '-'  && boardT[i+6] == 'o'){
				temp = (i+1);
			}
		}
		
		return(temp);
	}

	public int diagnolAI(){
		
		int temp = -1;
		
		if(boardT[0] == boardT[4] && boardT[8] == '-'  && boardT[4] != '-'){
			temp = 8;
		}else if(boardT[0] == boardT[8] && boardT[4] == '-'  && boardT[0] != '-'){
			temp = 4;
		}else if(boardT[4] == boardT[8] && boardT[0] == '-'  && boardT[8] != '-'){
			temp = 0;
		}
		
		if(boardT[2] == boardT[4] && boardT[6] == '-'  && boardT[2] != '-'){
			temp = 6;
		}else if(boardT[2] == boardT[6] && boardT[4] == '-'  && boardT[2] != '-'){
			temp = 4;
		}else if(boardT[4] == boardT[6] && boardT[2] == '-'  && boardT[6] != '-'){
			temp = 2;
		}
		
		return(temp);
	}
	
	public int lookMiddle() {
		int temp = -1;
		if(boardT[4] == '-'){
			temp = 4;
		}
		return(temp);
	}

	public int lookCorners() {
		int temp = -1;
		for(int i = 0; i<9; i+=2){
			if(boardT[i] == '-'){
				temp = (i);
			}
		}
		return(temp);
	}
	
	public int lookSides(){
		int temp = -1;
		for(int i = 1; i<8; i+=2){
			if(boardT[i] == '-'){
				temp = i;
			}
		}
		return(temp);
	}

	public void getBoardTest(){
		
		
		JOptionPane.showMessageDialog(null, "" + boardT[0] + boardT[1] + boardT[2] + "    1" + "2" + "3" +
		"\n" + boardT[3] + boardT[4] + boardT[5] +  "    4" + "5" + "6" +
		"\n" + boardT[6] + boardT[7] + boardT[8] + "    7" + "8" + "9");	
	}

	public void catsGame(){
		
		JOptionPane.showMessageDialog(null, "Cats Game!" , "Tie", JOptionPane.INFORMATION_MESSAGE, null);
		win = true;
	}

	public boolean noJulian(){
		if(boardT[0] == 'o' && boardT[8] == 'o' && boardT[4] == 'x'){
			if(boardT[1] == '-'){
				boardT[1] = 'x';
				turn = 'o';
				return (true);
			}
		}else if(boardT[2] == 'o' && boardT[6] == 'o' && boardT[4] == 'x'){
			if(boardT[1] == '-'){
				boardT[1] = 'x';
				turn = 'o';
				return(true);
			}else{
				return(false);
			}
		}
		return(false);
	}

	public boolean noGeorge(){
		
		if(boardT[1] == boardT[3] && boardT[1] != '-'){
			if(boardT[0] == '-'){
				boardT[0] = 'x';
				turn = 'o';
				return (true);
			}
		}else if(boardT[3] == boardT[7] && boardT[3] != '-'){
			if(boardT[6] == '-'){
				boardT[6] = 'x';
				turn = 'o';
				return (true);
			}
		}else if(boardT[5] == boardT[7] && boardT[5] != '-'){
				if(boardT[8] == '-'){
				boardT[8] = 'x';
				turn = 'o';
				return (true);
				}
		}else if(boardT[5] == boardT[1] && boardT[1] != '-'){
			if(boardT[2] == '-'){
				boardT[2] = 'x';
				turn = 'o';
				return (true);
			}
		}
		return(false);
	}
}

