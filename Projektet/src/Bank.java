import java.util.ArrayList;

public class Bank {

	private ArrayList <BankAccount> Accounts;


	public long addAccount(String holderName, long idNr) {
		for(int i = 0; i<Accounts.size(); i++) {
			if(Accounts.get(i).getHolder().getIdNr() == idNr && Accounts.get(i).getHolder().getName().equals(holderName)) {
				return Accounts.get(i).getHolder().getBnkNr();
			}
		}
		Customer c = new Customer(holderName, idNr);
		Accounts.add(new BankAccount(c));
		return c.getBnkNr();
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
				return true;
			}
		}
		return false;
	}

	public ArrayList<BankAccount> getAllAccounts() {
		return Accounts;
		//		Ej sorterad
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
		//Unfinished
		return null;
	}
}

