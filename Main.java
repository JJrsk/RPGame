
public class Main {
	
	public static void main(String[] args){
		
		Player player1 = SetUp.run();
		player1 = Pub.run();
		player1.giveXp(400);
	}
}
