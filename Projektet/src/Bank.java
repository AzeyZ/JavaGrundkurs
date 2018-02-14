import java.util.ArrayList;

public class Bank {

	private ArrayList <BankAccount> Accounts = new ArrayList<BankAccount>();


	public long addAccount(String holderName, long idNr) {
		for(int i = 0; i<Accounts.size(); i++) {
			if(Accounts.get(i).getHolder().getIdNr() == idNr && Accounts.get(i).getHolder().getName().equals(holderName)) {
				return Accounts.get(i).getHolder().getBnkNr();
			}
		}
		Customer c = new Customer(holderName, idNr);
		BankAccount b = new BankAccount(c);
		Accounts.add(b);
		sortAccounts();
		return b.getAccountNbr();
	}

	public Customer findHolder(long idNr) {
		for(int i = 0; i<Accounts.size(); i++) {
			if(Accounts.get(i).getHolder().getIdNr() == idNr) {
				return Accounts.get(i).getHolder();
			}
		}		
		return null;
	}

	public boolean removeAccount (long nbr) {
		for(int i = 0; i<Accounts.size(); i++) {
			if(Accounts.get(i).getAccountNbr() == nbr) {
				Accounts.remove(i);
				sortAccounts();
				return true;
			}
		}
		return false;
	}

	public ArrayList<BankAccount> getAllAccounts() {
		return Accounts;
		
	}
	
	private void sortAccounts() {
		for(int i = 1; i< Accounts.size(); i++) {
			if(Accounts.get(i-1).getHolder().getName().compareToIgnoreCase(Accounts.get(i).getHolder().getName()) > 0) {
				BankAccount higer = Accounts.get(i-1);
				BankAccount lower = Accounts.get(i);
				Accounts.set(i-1, lower);
				Accounts.set(i, higer);
				i=0;
			}
		}
	}

	public BankAccount findByNumber(long accountNumber) {
		for(int i = 0; i<Accounts.size(); i++) {
			if(Accounts.get(i).getAccountNbr() == accountNumber) {
				return Accounts.get(i);
			}
		}
		return null;
	}

	public ArrayList <BankAccount> findAccountsForHolder(long idNr) {
		ArrayList <BankAccount> holderAccounts = new ArrayList<BankAccount>();
		for(int i = 0; i< Accounts.size(); i++) {
			if(Accounts.get(i).getHolder().getIdNr() == idNr) {
				holderAccounts.add(Accounts.get(i));
			}
		}
		return holderAccounts;
	}
	
	public ArrayList<Customer> findByPartofName(String namePart){
		ArrayList <Customer> foundCustomers = new ArrayList<Customer>();
		for(int i = 0; i<Accounts.size();i++) {
			if(Accounts.get(i).getHolder().getName().contains(namePart)) {
				foundCustomers.add(Accounts.get(i).getHolder());
			}
		}
		
		return foundCustomers;
	}
}

