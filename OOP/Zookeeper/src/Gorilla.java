
public class Gorilla extends Mammal {
	
	public Gorilla() { super(); }
	
	public void throwObject() {
		energy -= 5;
		System.out.println("Object yeeted");
	}
	
	public void eatBanana() {
		energy += 10;
		System.out.println("Mmmmm, yummy banana");
	}
	
	public void climb() {
		energy -= 10;
		System.out.println("I'm climbing so high");
	}
}
