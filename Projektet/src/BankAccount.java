
public class BankAccount {
	private long AccountNbr;
	private double balance;
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
		String s = new String("55" + AccNbrGenerator );
		AccountNbr = Long.valueOf(s).longValue();
		balance = 0;
		AccNbrGenerator++;
	}
	
	public Customer getHolder() {
		return customer;
	}
	
	public double getAmount() {

		return balance;
	}
	
	public long getAccountNbr() {
		return AccountNbr;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public String toString() {
		return " ej klar" + AccountNbr;
	}
	
}
