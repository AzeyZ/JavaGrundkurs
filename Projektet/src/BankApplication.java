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
		int val = scanIntVal();
		switch (val) {
		case 1:
			System.out.print("id: ");
			long idSearch = scanLong();
			for(int print = 0; print < Bank.findAccountsForHolder(idSearch).size();print++ )
			System.out.println(Bank.findAccountsForHolder(idSearch).get(print));
			break;
		case 2:  
			scan.nextLine();
			System.out.print("namn: ");
			String part = scanString();
			Bank.findByPartofName(part);
			for(int k = 0;k<Bank.findByPartofName(part).size();k++ ) {
				System.out.println(Bank.findByPartofName(part).get(k));
			}
			break;
		case 3:
			System.out.print("konto: ");
			long accAdd = scanLong();
			scan.nextLine();
			System.out.print("belopp: ");
			long belopp = scanLong();
			Bank.findByNumber(accAdd).deposit(belopp);
			System.out.println(Bank.findByNumber(accAdd));
			break;
		case 4:  
			System.out.print("konto: ");
			long accWithdraw = scanLong();
			scan.nextLine();
			System.out.print("belopp: ");
			long withdraw = scanLong();
			if(Bank.findByNumber(accWithdraw).withdraw(withdraw)) {
				System.out.println(Bank.findByNumber(accWithdraw));
			}			
			break;
		case 5: 
			System.out.print("från konto: ");
			long accFrom = scanLong();
			scan.nextLine();
			System.out.print("till konto: ");
			long accTo = scanLong();
			scan.nextLine();
			System.out.print("belopp: ");
			long sum = scanLong();
			if(Bank.findByNumber(accFrom).withdraw(sum)) {
				System.out.println(Bank.findByNumber(accFrom));
			}
			Bank.findByNumber(accTo).deposit(sum);
			System.out.println(Bank.findByNumber(accTo));
			break;
		case 6:
			scan.nextLine();
			System.out.print("namn: ");
			String namn = scanString();
			System.out.print("id: ");
			long id = scanLong();
			System.out.println("konto skapat: "+ Bank.addAccount(namn, id));
			break;
		case 7: 
			System.out.print("konto: ");
			long accRemove = scanLong();
			scan.nextLine();
			Bank.removeAccount(accRemove);
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

	public void printMenu() {
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");
		System.out.print("val: ");
	}

	public int scanIntVal() { 
		int i = 0;
		try
		{
			i = scan.nextInt();
			if(!(i<10 && i>0)) {
				System.out.println("Skriv en siffra mellan 0 till 9");
				printMenu();
				scanIntVal();
			}
		}
		catch (Exception e)
		{
			System.out.println("Du måste skriva en siffra mellan 1 och 9");
			printMenu();
			scan.nextLine();
			scanIntVal();
		}
		return i;
	}

	public String scanString() { 
		String s = "error";
		try
		{
			s = scan.nextLine();

		}
		catch (Exception e)
		{
			System.out.println("Du ska skriva ett namn");
			printMenu();
			scan.nextLine();
			scanString();
		}
		return s;
	}

	public long scanLong() { 
		long i = 0;
		try
		{
			i = scan.nextLong();
		}
		catch (Exception e)
		{
			System.out.println("Du ska skriva en siffra");
			scan.nextLine();
			scanLong();
		}
		return i;
	}
}