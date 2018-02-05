import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;



public class RaceTurtle extends Turtle {
	private int nummer;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		nummer = nbr;
		penDown();
		left(-90);
	}
	
	public void raceStep(){
		Random rnd = new Random();
		forward(rnd.nextInt(6));
	}
	
	public String toString() {
		String nbr = "Nummer " + nummer;
		return nbr;
	}
}
