import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;

        for(int i = 0; i <= 10; i++) {
            sum += i;
        }

        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;

        for(double price : prices) {
            total += price;
        }

        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(String item : menuItems) {
            System.out.printf("%d %s\n", menuItems.indexOf(item), item);
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.print("Please enter your name: ");
        String userName = System.console().readLine();

        System.out.println("Hello, " + userName);
        System.out.println(String.format("There are %d people in front of you.", customers.size()));

        customers.add(userName);

        for(String customer : customers) {
            System.out.print(customer + ", ");
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for(int i = 1; i <= maxQuantity; i++) { //Prints price for each possible quantity with a $0.50 discount for every quantity after 1
            System.out.printf("%d - $%.2f\n", i, (price*i - ((i-1) * .5)));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if(menuItems.size() != prices.size()){
            return false;
        }

        for(int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }

        return true;
    }

    public void addCustomers(ArrayList<String> customers) {
        while(true) {
            System.out.print("Please enter your name('q' to Quit): ");
            String userName = System.console().readLine();

            if(userName.toUpperCase().equals("Q")) {
                break;
            }
    
            System.out.println("Hello, " + userName);
            System.out.println(String.format("There are %d people in front of you.", customers.size()));
    
            customers.add(userName);
        }
        for(String name : customers) {
            System.out.print(name + ", ");
        }
    }
}
