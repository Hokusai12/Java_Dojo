public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.25;
        double latte = 4.0;
        double cappucino = 4.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        System.out.println(customer1 + pendingMessage); //Cindhuri ordered coffee

        //Noah ordered Cappucino
        //If the drink is ready display ready message and total
        if(isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + String.valueOf(cappucino));
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        //Sam ordered 2 lattes
        //Display total and if the order is ready display ready message
        
        System.out.println(displayTotalMessage + String.valueOf(latte * 2));
        if(isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        //Jimmy was charged for coffee but ordered a latte
        //Print the total message with price difference
        System.out.println(displayTotalMessage + String.valueOf(latte - dripCoffee));
    }
}
