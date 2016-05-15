//Jeremy Code Master Race
//Completed for all in game organism base
public class Organisms  {
	
	//Constructor
	public Organisms(int h, int r, int s){
		health = h;
		resistance = r;
		speed = s;
	}
	
	//Instance Data
	private int health;
	private int resistance;
	private int speed;

	//Methods
	public int getHealth(){
		return(health);
	}
	public void setHealth(int i){
		health += i;
	}
	public int getResistance(){
		return(resistance);
	}
	public void setResistance(int i){
		resistance = i;
	}
	public int getspeed(){
		return(speed);
	}
	public void setspeed(int i){
		speed += i;
	}
	
	
}