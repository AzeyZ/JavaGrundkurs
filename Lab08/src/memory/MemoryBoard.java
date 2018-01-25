package memory;

import java.util.Random;

public class MemoryBoard {
	private MemoryCardImage[][] board;
	private int size;
	private String backFileName;
	private String[] frontFileNames;
	

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.board = new MemoryCardImage[size][size];
		this.size = size;
		this.backFileName = backFileName;
		this.frontFileNames = frontFileNames;

		
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		
			String[] framsidor = new String[size*size];
			int factor = 0;
			for (int i = 0; i < framsidor.length; i++) {
				framsidor[i] = frontFileNames[factor];
				if(i == ((size*size/2)-1)) {
					factor=0;
				}
				factor++;
			}
			
			Random r = new Random();
			int n = size*size;
			for(int rows = 0; rows < size; rows++) {
				
				for (int cols = 0; cols < size; cols++) {
					int rand = r.nextInt(n);
					this.board[rows][cols] = new MemoryCardImage(framsidor[rand],backFileName);
					frontFileNames[rand] = frontFileNames[rand-1];
					frontFileNames[rand-1] =null;				
					n--;
				}
			}
			
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return false;
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return false;
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		return false;
	}	
}
