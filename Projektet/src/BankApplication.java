import java.util.Scanner;

public class BankApplication {
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String [] args) {
		BankApplication b = new BankApplication();
		b.runApplication();
	}
	
	public void runApplication() {
		printMenu();
		
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
		System.out.println("val: ");
	}
	
	public int scanInt() { 
		int i = 0;
		try
		{
		    i = scan.nextInt();
		}
		catch (Exception e)
		{
			System.out.println("Skriv en siffra mellan 1 och 9");
			printMenu();
		    scanInt();
		}
		return i;
	}
	
	
	
	
}
