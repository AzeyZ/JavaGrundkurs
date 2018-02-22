import java.util.Scanner;

public class BankApplication {
	private Scanner scan = new Scanner(System.in);
	private Bank Bank = new Bank();
	private static boolean GO = false;

	public static void main(String [] args) {
		BankApplication b = new BankApplication();
		GO = true;
		while(GO) {
			b.runApplication();
		}
	}

	public void runApplication() {
		printMenu();
		long id;
		String name;
		int val = scanIntVal();
		switch (val) {
		case 1:
			System.out.print("id: ");
			id = scanLong();
			if(Bank.findAccountsForHolder(id).size() == 0) {
				System.out.println("Kunde inte hitta något konto med det Id nummret");	
			} else {
				for(int print = 0; print < Bank.findAccountsForHolder(id).size();print++ ) {
					System.out.println(Bank.findAccountsForHolder(id).get(print));
				}
			}
			break;
			
		case 2:  
			scan.nextLine();
			System.out.print("namn: ");
			name = scanStringName();
			if(Bank.findByPartofName(name).size() == 0) {
				System.out.println("Hittade ingen användare med det namnet");
			}
			for(int k = 0;k<Bank.findByPartofName(name).size();k++ ) {
				System.out.println(Bank.findByPartofName(name).get(k));
			}
			break;
			
		case 3:
			System.out.print("konto: ");
			long accAdd = scanLong();
			scan.nextLine();
			if(accExists(accAdd)) {
				System.out.print("belopp: ");
				double belopp = scanDoubleBelopp();
				Bank.findByNumber(accAdd).deposit(belopp);
				System.out.println(Bank.findByNumber(accAdd));
			}
			break;
			
		case 4:  
			System.out.print("konto: ");
			long accWithdraw = scanLong();
			scan.nextLine();
			if(accExists(accWithdraw)) {
				System.out.print("belopp: ");
				double withdraw = scanDoubleBelopp();
				if(Bank.findByNumber(accWithdraw).withdraw(withdraw)) {
					System.out.println(Bank.findByNumber(accWithdraw));
				}
				else {
					System.out.println("uttaget misslyckades, endast " + Bank.findByNumber(accWithdraw).getAmount() + " på kontot!");
				}
			}
			break;
			
		case 5: 
			System.out.print("från konto: ");
			long accFrom = scanLong();
			scan.nextLine();
			if(accExists(accFrom)) {
				System.out.print("till konto: ");
				long accTo = scanLong();
				scan.nextLine();
				if(accExists(accFrom)) {
					System.out.print("belopp: ");
					double sum = scanDoubleBelopp();
					if(Bank.findByNumber(accFrom).withdraw(sum)) {
						System.out.println(Bank.findByNumber(accFrom));
						Bank.findByNumber(accTo).deposit(sum);
						System.out.println(Bank.findByNumber(accTo));
					}
					else {
						System.out.println("uttaget misslyckades, endast " + Bank.findByNumber(accFrom).getAmount() + " på kontot!");
					}
				}
			}
			break;
			
		case 6:
			int antalKonto = Bank.getAllAccounts().size();
			scan.nextLine();
			System.out.print("namn: ");
			name = scanStringName();
			System.out.print("id: ");
			id = scanLong();
			long bnkNbr = Bank.addAccount(name, id);
			int antalKontoEfter = Bank.getAllAccounts().size();
			if(antalKonto == antalKontoEfter) {
				System.out.println("konto med detta id finns redan");
			}
			else {
				System.out.println("nytt konto skapat: " + bnkNbr);
			}
			break;
			
		case 7: 
			System.out.print("konto: ");
			long accRemove = scanLong();
			scan.nextLine();
			if(accExists(accRemove)) {
				Bank.removeAccount(accRemove);
				System.out.println("Konto: "+ accRemove + " har tagits bort");
			}
			else {
				System.out.println("Kunde inte hitta något konto med det nummret");
			}
			break;
			
		case 8:
			for(int i=0;i<Bank.getAllAccounts().size();i++) {
				System.out.println(Bank.getAllAccounts().get(i));
			}
			break;
			
		case 9:  
			GO = false;
			break;
		}
	}

	private boolean accExists(long accNbr) {
		for(int i = 0; i<Bank.getAllAccounts().size();i++) {
			if(Bank.getAllAccounts().get(i).getAccountNbr() == accNbr) {
				return true;
			}
		}
		System.out.println("Kunde inte hitta kontot");
		return false;
	}

	private void printMenu() {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");
		System.out.print("val: ");
	}

	private int scanIntVal() { 
		int i = 0;
		boolean ok = false;
		while(!ok) {
			try
			{
				ok = true;
				i = scan.nextInt();
				if(!(i<10 && i>0)) {
					System.out.println("Skriv en siffra mellan 0 till 9");
				}
			}
			catch (Exception e)
			{
				System.out.println("Du måste skriva en siffra mellan 1 och 9");
				printMenu();
				scan.nextLine();
				ok = false;
			}
		}
		return i;
	}

	private String scanStringName() { 
		String s = "error";
		boolean ok = false;
		while(!ok) {
			try
			{
				ok = true;
				s = scan.nextLine();
			}
			catch (Exception e)
			{
				System.out.println("Du ska skriva ett namn");
				printMenu();
				scan.nextLine();
				ok = false;
			}
		}
		return s;
	}

	private long scanLong() { 
		long i = 0;
		boolean ok = false;
		while(!ok) {
			try
			{
				ok = true;
				i = scan.nextLong();
			}
			catch (Exception e)
			{
				System.out.println("Du måste skriva en siffra");
				scan.nextLine();
				ok = false;
			}
		}
		return i;
	}

	private double scanDoubleBelopp() { 
		double i = 0;
		boolean ok = false;
		while(!ok) {
			try
			{
				ok = true;
				i = scan.nextDouble();
				if(i<0) {
					System.out.println("Det måste vara ett positivt belopp");
					System.out.print("belopp: ");
					ok = false;
				}

			}
			catch (Exception e)
			{
				System.out.println("Du måste skriva ett belopp");
				scan.nextLine();
				ok = false;
			}
		}
		return i;
	}
}