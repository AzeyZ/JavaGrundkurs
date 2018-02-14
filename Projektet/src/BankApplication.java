import java.util.Scanner;

public class BankApplication {
	private Scanner scan = new Scanner(System.in);
	private Bank Bank = new Bank();

	public static void main(String [] args) {
		BankApplication b = new BankApplication();
		b.runApplication();
		b.runApplication();
	}

	public void runApplication() {
		printMenu();
		int val = scanIntVal();
		switch (val) {
		case 1:
			
			break;
		case 2:  
			break;
		case 3:  
			break;
		case 4:  
			break;
		case 5: 
			break;
		case 6:
			System.out.print("namn: ");
			String namn = new String(scanString());
			scan.nextLine();
			System.out.print("id: ");
			long id = scanInt();
			System.out.println("konto skapat: "+ Bank.addAccount(namn, id));
			break;
		case 7: 
			break;
		case 8:  
			break;
		case 9:  
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
		String s = null;
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

	public int scanInt() { 
		int i = 0;
		try
		{
			i = scan.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Du ska skriva en siffra");
			scan.nextLine();
			scanInt();
		}
		return i;
	}


}
