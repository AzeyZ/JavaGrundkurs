package memory;

import java.util.Scanner;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";
		boolean playagain = true;
		while(playagain){
			int försök = 0;
			MemoryBoard board = new MemoryBoard(4,backFileName,frontFileNames);
			MemoryWindow window = new MemoryWindow(board);
			window.drawBoard();
			
			while(!board.hasWon()) {
				försök++;
				int r1 = 0;
				int c1 = 0;
				int r2 = 0;
				int c2 = 0;
				boolean click = false;
				while(!click) {
					window.waitForMouseClick();
					r1 = window.getMouseRow();
					c1 = window.getMouseCol();
					if(!board.frontUp(r1, c1)) {
						click = true;
					}
				}
				board.turnCard(r1,c1);
				window.drawCard(r1, c1);
				click = false;
				while(!click) {
					window.waitForMouseClick();
					r2 = window.getMouseRow();
					c2 = window.getMouseCol();
					if(!board.frontUp(r2, c2)) {
						click = true;
					}
				}
				board.turnCard(r2,c2);
				window.drawCard(r2, c2);
				if(!board.same(r1, c1, r2, c2)) {
					window.delay(800);
					board.turnCard(r1, c1);
					window.drawCard(r1, c1);
					board.turnCard(r2, c2);
					window.drawCard(r2, c2);
				}
			}
			System.out.println("Du vann med " + försök + " f�rs�k, Vill du spela igen?");
			System.out.println("Skriv y f�r att spela igen");
			Scanner scan = new Scanner(System.in);
			if(!scan.next().equals("y")) {
				playagain = false;
			}
			window.close();
		}
		
	}
}
