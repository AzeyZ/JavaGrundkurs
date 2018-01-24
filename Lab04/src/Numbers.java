import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Numbers {

	private int[] spelNumbers;
	private int antalStart;
	private int valtTal;
	private int score;
	private boolean vinst;
	//Sätter datorns/spelarens tal
	public Numbers(int antalStart, int startMin, int startMax) {
		this.antalStart = antalStart;
		spelNumbers = new int[antalStart];
		for(int i = 0; i<antalStart; i++) {
			spelNumbers[i] = rNum(startMin,startMax);
		}		
	}
	//Slumpar ett tal mellan min och max
	public int rNum(int min, int max) {
		int rNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return rNum;
	}
	//Scannar ett tal och kontrollerar så att det finns bland spelarens tal och sätter sedan spelarens tal till det talet.
	public void scannTal() {
		int iter = 0;
		System.out.println("\n"+"Välj ett av dina tal");
		Scanner scan = new Scanner(System.in);
		boolean finns = false;

		while(finns == false) {

			while(scan.hasNextInt()==false) {
				System.out.println("Skriv på formen \"18\"");
				scan.next();
				iter++;
				if(iter>2) {
					iter = 0;
					PrintNumbers();
				}
			}
			valtTal = scan.nextInt();			

			for(int i = 0; i < spelNumbers.length; i++) {
				if(spelNumbers[i] == valtTal) {
					finns = true;
					break;
				}
			}
			if(finns==false) System.out.println("Du måste välja ett tal bland dina tal");
			iter++;
			if(iter>2) {
				iter = 0;
				PrintNumbers();
			}
		}
	}
	//Printar spelaren/datorns tal
	public void PrintNumbers() {
		System.out.print("Dina tal: ");
		for(int i = 0; i<spelNumbers.length; i++) {
			System.out.print(spelNumbers[i] + "  ");
		}
	}

	//Lägger till 1 poäng till en spelare och kontrollerar om någon vunnit
	public void Score() {
		score++;
		if(score == (antalStart/2)+1) {
			vinst = true;			
		}
	}
	//Tar bort det valda talet från spelaren/datorns tal
	public void Remove() {
		int rem = valtTal;
		int tempLength = 0;
		boolean removed = false;
		for(int i = 0; i < spelNumbers.length; i++) {
			if(spelNumbers[i] == rem && removed == false) {
				spelNumbers[i]=0;
				removed = true;
			}
			if(spelNumbers[i] != 0) {
				tempLength++;
			}
		}
		int spelNumbersTemp[] = new int[tempLength];
		tempLength = 0;
		for(int i=0; i < spelNumbers.length; i++) {
			if(spelNumbers[i] != 0) {
				spelNumbersTemp[tempLength] = spelNumbers[i];
				tempLength++;
			}

		}
		spelNumbers = spelNumbersTemp;
	}
	//Retunerar spelarens/datorns tal
	public int getvaltTal() {
		return valtTal;
	//Sätter spelarens/datorns tal
	}
	public void setvaltTal(int tal) {
		valtTal = tal;
	}
	//Retunerar spelaren/datorns alla tal
	public int[] getSpelNumbers() {
		return spelNumbers;
	//Retunerar spelaren/datorns poäng
	}
	public int getscore() {
		return score;
	//Retunerar en boolean som vet om någon vunnit
	}
	public boolean getvinst() {
		return vinst;
	}
}