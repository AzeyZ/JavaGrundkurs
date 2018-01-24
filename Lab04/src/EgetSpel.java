import java.util.Scanner;

public class EgetSpel {

	public static void main(String[] args) {
		System.out.println("Välj antalet tal");
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()==false) {
			System.out.println("Skriv på formen \"10\"");
			scan.next();
		}
		int antal = scan.nextInt();
		int Max = 25;
		int Min = 1;
		boolean igen = true;
		EgetSpel s = new EgetSpel();
		
		while(igen) {
			s.spelet(antal,Max,Min);
			System.out.println("Vill du spela igen? true/false");
			while(scan.hasNextBoolean()==false) {
				System.out.println("Skriv på formen \"false\"");
				scan.next();
			}
			igen = scan.nextBoolean();
			if(!igen) igen = false;
		}
			
	}
	
	public void spelet(int antalTal, int startMax, int startMin) {
		Numbers player = new Numbers(antalTal,startMin,startMax);
		Numbers bot = new Numbers(antalTal,startMin,startMax);
		int datornsTal[]= new int[antalTal];

		System.out.println("Jag har " + antalTal + " hemliga tal mellan " + startMin + " och " + 
				startMax );
		System.out.println("Vi väljer båda var sitt tal och ser vems som är högst");
		System.out.println("Högst tal ger 1 poäng och båda talen " + '"' + "kastas" + '"' + " Först till " + 
		(1+player.getSpelNumbers().length/2)+ " poäng");

		player.PrintNumbers();	

		int iter = 0; //Antalet gånger vårt spel har körts
		//Spelets While sats som körs så länge ingen vunnit
		while(player.getvinst() != true && bot.getvinst() != true) {
			//Vi sätter spelarens och datorns tal
			player.scannTal();
			bot.setvaltTal(bot.getSpelNumbers()[bot.rNum(startMin-1, bot.getSpelNumbers().length-1)]);
			//Kollar vem som hade högst och ger poäng
			if(player.getvaltTal()>bot.getvaltTal()) {
				player.Score();		
				System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + 
						"Du vann! Och det står: " + player.getscore() + "-" + bot.getscore());
			}
			else if(player.getvaltTal() == bot.getvaltTal()) {
				System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Lika! Båda fär poäng");
				player.Score();
				bot.Score();
				System.out.println("Det står nu: " + player.getscore() + "-" + bot.getscore());
			}
			else {
				bot.Score();
				System.out.println( "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" +
						"Du förlorade och det står nu: " + player.getscore() + "-" + bot.getscore());
			}
			//Sparar datorns valda tal
			datornsTal[iter] = bot.getvaltTal();
			//Printar datorns använda tal
			if(player.getSpelNumbers().length != 0) {
				System.out.print("Datorn har använt: ");
				for(int i = 0; i<=iter; i++) {
					System.out.print(datornsTal[i] + "  ");
				}
			}
			//Tar bor spelarens och datorns valda tal från deras "array"
			player.Remove();
			bot.Remove();
			System.out.print("\n");

			if(player.getSpelNumbers().length != 0) {
				System.out.print("Dina tal: ");
				for(int i = 0; i<player.getSpelNumbers().length; i++) {
					System.out.print(player.getSpelNumbers()[i] + "  ");
				}
			}
			//räknar antalet gånger vi kört
			iter++;
		}
		//Printar vem som van
		if(player.getvinst()==true && bot.getvinst()!=true) {
			System.out.println("\n" + "----------------------Du vann!----------------------");
		}
		else if(bot.getvinst()==true && player.getvinst()!=true) {
			System.out.println("\n" + "----------------------Du förlorade.----------------------");
		}
		else {
			System.out.println("\n" + "----------------------Lika!!?!??----------------------");
		}
	
	}
}
