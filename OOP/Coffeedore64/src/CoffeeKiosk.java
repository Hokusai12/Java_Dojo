import java.util.ArrayList;


public class CoffeeKiosk {
	//ATTRIBUTES
	private ArrayList<Item> menu;
	private ArrayList<Order> orders;
	
	//CONSTRUCTORS	
	public CoffeeKiosk() {
		menu = new ArrayList<Item>();
		orders = new ArrayList<Order>();
	}
	
	//METHODS
	public void addMenuItem(String itemName, double itemPrice) {
		Item newItem = new Item(itemName, itemPrice);
		menu.add(newItem);
		newItem.setIndex(menu.indexOf(newItem));
	}
	
	public void displayMenu() {
		for(Item menuItem : menu) {
			System.out.println(String.format("%d %s -- $%.2f", menu.indexOf(menuItem), menuItem.getName(), menuItem.getPrice()));
		}
	}
	
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        
        if(name.equals("admin")) {
        	addMenuItemByInput();
        	displayMenu();
        	return;
        }
    
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
        	newOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        newOrder.display();
        orders.add(newOrder);
        
    }
    
    public void addMenuItemByInput() {
    	System.out.println("Item Name: ");
    	String itemName = System.console().readLine();
    	
    	System.out.println("Item Price: ");
    	String itemPrice = System.console().readLine();
    	
    	addMenuItem(itemName, Double.parseDouble(itemPrice));
    }
}
