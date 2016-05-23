//Jeremy Code Master Race
//Completed for all in game organism base
public class Organisms  {
	
	//Constructor
	public Organisms(int h, int r, int s, int aL, int aH){
		health = h;
		resistance = r;
		speed = s;
		currentHealth = h;
		attackLow = aL;
		attackHigh = aH;
	}
	
	//Instance Data
	private int health;
	private int currentHealth;
	private int resistance;
	private int speed;
	private int attackLow;
	private int attackHigh;

	//Methods
	public int getHealth(){
		return(health);
	}
	public void setHealth(int i){
		health += i;
	}
	public int getCurrentHealth(){
		return(currentHealth);
	}
	public void setCurrentHealth(int i){
		currentHealth += i;
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