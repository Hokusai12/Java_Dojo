import java.util.ArrayList;


public class Order {
	private String name;
	private boolean ready;
	private ArrayList<Item> items;
	
	//CONSTRUCTORS
	
	public Order() {
		name = "Guest";
		items = new ArrayList<Item>();
	}
	
	public Order(String name) {
		this.name = name;
		items = new ArrayList<Item>();
	}

	//CLASS METHODS	
	
	public void addItem(Item newItem) {
		items.add(newItem);
	}
	
	public String getStatusMessage() {
		return isReady() ? name + ", your order is ready." : name + ", your order will be ready shortly.";
	}
	
	public double getOrderTotal() {
		double sum = 0.0;
		for(Item orderItem : items) {
			sum += orderItem.getPrice();
		}
		return sum;
	}
	
	public void display() {
		System.out.printf("Customer Name: %s", name);
		for(Item orderItem : items) {
			System.out.printf("\n%s - $%.2f", orderItem.getName(), orderItem.getPrice());//Prints each ordered items' name and price
		}
		System.out.printf("\nTotal: $%.2f\n", getOrderTotal());
	}
	
	//GETTER AND SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isReady() {
		return ready;
	}
	
	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
