
public class Bat extends Mammal {
	
	public Bat() {
		energy = 300;
	}
	
	public void fly() {
		energy -= 50;
		System.out.println("SKREEEEEEEE");
	}
	
	public void eatHuman() {
		energy += 25;
		System.out.println("Mmmmm, yummy human");
	}
	
	public void attackTown() {
		energy -= 100;
		System.out.println("AHHH AHHHHHHHH IM BURNING PLEASE HELP US! THIS ONE SINGLE BAT HAS GONE INSANE AND BURNED EVERYTHING DOWN!");
	}
}
