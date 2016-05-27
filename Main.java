
public class Main {
	
	public static void main(String[] args){
		
		boolean gameOver = false;
		Player player1 = SetUp.run();
		while(!gameOver){
			
			//Index, Name, Places it can go to
			//1 Pub (2)
			//2 Trail (1, 4, 6,)
			//3 Mines (6)
			//4 Ocean (3, 8)
			//5 Dungeon (6, 7)
			//6 Mountains (2, 3, 5)
			//7 Alter (Dungeon level 20)
			//8 dock (4)
			
			if(player1.getCurrentLocation() == 1){
				//pub
				player1 = (new Pub()).run(player1);
			}else if(player1.getCurrentLocation() == 2){
				//trail
				player1 = (new Trail()).run(player1);
			}else if(player1.getCurrentLocation() == 3){
				//mines
				//mines.run(player1);
			}else if(player1.getCurrentLocation() == 4){
				//Ocean
				//Ocean.run(player1);
			}else if(player1.getCurrentLocation() == 5){
				//Dungeon
				//Dungeon.run(player1);
			}else if(player1.getCurrentLocation() == 6){
				//Mountains
				//Mountains.run(player1);
			}else if(player1.getCurrentLocation() == 7){
				//Alter
				//Alter.run(player1);
			}else if(player1.getCurrentLocation() == 8){
				//dock
				player1 = (new Dock()).run(player1);
			}
		}
	}
}
