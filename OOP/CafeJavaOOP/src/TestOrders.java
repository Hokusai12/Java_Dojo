
public class TestOrders {

	public static void main(String[] args) {
		//The 4 item instantiations
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		Item item4 = new Item();
		
		item1.name = "mocha";
		item2.name = "drip coffee";
		item3.name = "latte";
		item4.name = "cappucino";
		
		item1.price = 7.25;
		item2.price = 5;
		item3.price = 6.30;
		item4.price = 5.75;
		
		
		//The 4 order instantiations
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		
		order1.name = "Cindhuri";
		order2.name = "Jimmy";
		order3.name = "Sam";
		order4.name = "Noah";
		
		//System.out.println(order1);  Outputs - "Order@75a1cd57"
		//System.out.println(order1.total);		Outputs - "0.0"
		
		/*
		order2.items.add(item1);
		order2.total += item1.price;
		*/
		
		
		/*
		order3.items.add(item4);
		order3.total += item4.price;
		 */
		
		/*
		order4.items.add(item3);
		order4.total += item3.price; 
		 */
		
		/*
		order1.ready = true;
		 */
		
		/*
		order3.items.add(item3);
		order3.items.add(item3);
		order3.total += item3.price * 2;
		 */
		
		/*
		order2.ready = true;
		 */
	}

}
