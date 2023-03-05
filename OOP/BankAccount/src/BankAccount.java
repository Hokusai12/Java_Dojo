import java.util.Random;


public class BankAccount {
	//ATTRIBUTES
	private double checkingBalance;
	private double savingsBalance;
	private static int numAccounts;
	private static double balanceOfAllAccounts;
	private long accountNumber;
	
	//SETTERS AND GETTERS
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	
	//CONSTRUCTORS
	public BankAccount() {
		accountNumber = generateAccountNumber();
		numAccounts++;
	}
	
	//METHODS
	public void deposit(String accountType, double amount) { //RELIES ON accountType ARGUMENT TO BE UPPERCASE
		if(accountType.equals("CHECKING")) {
			System.out.println(String.format("Successfully deposited $%.2f into checking account under account %d", amount, accountNumber));
			checkingBalance += amount;
		}
		else if(accountType.equals("SAVING")) {
			System.out.println(String.format("Successfully deposited $%.2f into savings account under account %d", amount, accountNumber));
			savingsBalance += amount;
		}
		else {
			return;
		}
		balanceOfAllAccounts += amount;
	}
	
	public double withdraw(double amount) {
		if(checkingBalance < amount) {
			System.out.println(String.format("Unsuccessful withdraw from account %d for $%.2f: Insufficient Funds", accountNumber, amount));
			return 0.0;
		}
		else {
			System.out.println(String.format("Succesfully withdrew $%.2f from account %d", amount, accountNumber));
			checkingBalance -= amount;
			balanceOfAllAccounts -= amount;
			return amount;
		}
	}
	
	public String getBalanceTotalsString() {
		return String.format("-----%d-----\nChecking Account Balance: $%.2f\nSavings Account Balance: $%.2f", accountNumber, checkingBalance, savingsBalance);
	}
	
	private long generateAccountNumber() {
		Random rand = new Random();
		return rand.nextLong(1000000000, Long.parseLong("9999999999"));//For whatever reason it didn't let me put in 9999999999 raw b/c it gave typeError for thinking it was integer argument
	}
	
	public static String getAllAccountTotalsString() {
		return String.format("All Bank Accounts Total: $%.2f", balanceOfAllAccounts);
	}
	
	public static String getNumAccountsString() {
		return String.format("Number of Bank Accounts: %d", numAccounts);
	}
}
