
public class AiAttempt {

	boolean runEnd = false;
	int temp;
	
	public void run(BoardTicTacToe two){
		runEnd = false;
		temp = -1;

		
		runEnd = two.noJulian();
		
		
		if(!runEnd){
			runEnd=two.noGeorge();
		}
		
		//finds if it can win/lose side to side
		if(!runEnd){
			temp = two.sideToSideAI();
			if(temp != -1){
				two.replaceBoard(temp);
				runEnd = true;
			}
			
		}
		
		if(!runEnd){
			//finds if it can win/lose up down
			temp = two.upDownAI();
			if(temp != -1){
				runEnd = true;
				two.replaceBoard(temp);
			}
		}

		//finds if it can win/lose by diagnol
		if(!runEnd){
			temp = two.diagnolAI();
			if(temp != -1){
				runEnd = true;
				two.replaceBoard(temp+1);
			}
		}

		if(!runEnd){
			temp = two.lookMiddle();
			if(temp != -1){
				two.replaceBoard(temp+1);
				runEnd = true;

			}
		
		}
		if(!runEnd){
			temp = two.lookCorners();
			if(temp != -1){
				two.replaceBoard(temp+1);
				runEnd = true;
			}
		}
		
		
		if(!runEnd){
			temp = two.lookSides();
			if(temp != -1){
				two.replaceBoard(temp+1);
				runEnd = true;
			}
		}
	}
	
}
