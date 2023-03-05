
public class BatTest {

	public static void main(String[] args) {

		System.out.println("-----Bat Test-----");
		Bat vampire = new Bat();
		
		vampire.attackTown();
		vampire.attackTown();
		vampire.attackTown();
		
		vampire.eatHuman();
		vampire.eatHuman();
		
		vampire.fly();
		vampire.fly();
		
		vampire.displayEnergy();
	}

}
