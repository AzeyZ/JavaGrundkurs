package memory;
import java.util.Random;

public class MemoryBoard {
	private MemoryCardImage[][] board;
	private MemoryCardImage[] cards;
	private boolean[][] frontUp;
	
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		board = new MemoryCardImage[size][size];
		frontUp = new boolean[size][size];
		cards = new MemoryCardImage[size*size/2];
		createCards(backFileName, frontFileNames);	
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
			Random r = new Random();
			for(int i = 0; i <cards.length; i++) {
				cards[i] = new MemoryCardImage(frontFileNames[i],backFileName);
				for(int j = 0; j < 2; j++) {
					int rows = r.nextInt(getSize());
					int cols = r.nextInt(getSize());
					while (!(board[rows][cols] == null))
					{
						rows = r.nextInt(getSize());
						cols = r.nextInt(getSize());
					}
					board[rows][cols] = cards[i];
				}
			}
	}
	
	/** Tar reda på brädets storlek. */
	public int getSize() {
		return board.length;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if(!frontUp[r][c]) {
			frontUp[r][c] = true;
		}
		else {
			frontUp[r][c] = false;
		}
		//frontUp[r][c] = !frontUp[r][c];
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		if(frontUp[r][c]) {
			
			return true;
		}
		
		return false;
		
		//return frontUp[r][c]
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		if(board[r1][c1].equals(board[r2][c2])) {
			return true;
		}
		return false;
	}
	
	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		int frontup = 0;
		for(int r = 0; r < getSize(); r++) {
			for( int c = 0; c < getSize(); c++) {
				if(frontUp[r][c]) frontup++;
			}
		}
		if(frontup == getSize()*getSize()) {
			return true;
		}
		return false;
	}	
}
