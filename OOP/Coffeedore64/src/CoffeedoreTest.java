
public class CoffeedoreTest {

	public static void main(String[] args) {
		//Works when ran from terminal but not interal Spring console due to NullPointerException with using System.console().readLine() since console isn't initialized properly
		CoffeeKiosk coffeedore64 = new CoffeeKiosk();
		
		coffeedore64.addMenuItem("banana", 2);
		coffeedore64.addMenuItem("coffee", 1.5);
		coffeedore64.addMenuItem("latte", 4.5);
		coffeedore64.addMenuItem("cappucino", 3);
		coffeedore64.addMenuItem("muffin", 4);
		
		coffeedore64.newOrder();
	}

}
