
public class BankAccountTest {

	public static void main(String[] args) {
		System.out.println(BankAccount.getAllAccountTotalsString());
		System.out.println(BankAccount.getNumAccountsString());
		
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account3 = new BankAccount();
		
		account1.deposit("CHECKING", 300);
		account2.deposit("CHECKING", 40);
		account2.deposit("SAVING", 250);
		account3.deposit("SAVING", 1000);
		
		account1.withdraw(40);
		account2.withdraw(100);
		
		System.out.println(account1.getBalanceTotalsString());
		System.out.println(account2.getBalanceTotalsString());
		System.out.println(account3.getBalanceTotalsString());
		
		System.out.println(BankAccount.getAllAccountTotalsString());
		System.out.println(BankAccount.getNumAccountsString());
	}

}
