
public class Driver extends Car {
	public void drive() {
		gas -= 1;
		System.out.println("Driving");
		if(gas == 0)
			gameOver();
		printGas();
	}
	
	public void boost() {
		if(gas >= 3) {
			gas -= 3;
			System.out.println("Boosted!!!!");
			if(gas <= 0)
				gameOver();
			printGas();
		}
		else {
			System.out.println("Not enough gas!");
		}
	}
	
	public void refuel() {
		if(gas <= 8) {
			gas += 2;
			System.out.println("Gassed up!");
			printGas();
		}
		else {
			System.out.println("No need for fuel now.");
		}
	}
}
