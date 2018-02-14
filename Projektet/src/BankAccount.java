
public class BankAccount {
	private long AccountNbr;
	private long balance;
	private static long AccNbrGenerator = 10000;
	private Customer customer;
	
	public BankAccount(long holderId, String holderName) {
		this.customer = new Customer(holderName, holderId);
		AccountNbr = AccNbrGenerator;
		balance = 0;
		AccNbrGenerator++;
	}
	
	public BankAccount(Customer holder) {
		this.customer = holder;
		AccountNbr = AccNbrGenerator;
		balance = 0;
		AccNbrGenerator++;
	}
	
	public Customer getHolder() {
		return customer;
	}
	
	public long getAmount() {

		return balance;
	}
	
	public long getAccountNbr() {
		return AccountNbr;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		if((balance - amount) < 0) {
			System.out.println("uttaget misslyckades, endast " + balance + " på kontot!");
			return false;
		} else
		{
			balance -= amount;
			return true;
		}
	}
	
	public String toString() {
		return "konto " + AccountNbr + customer + balance;
	}
	
}
