import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	int absent;
	int nbr;

	public AbsentMindedTurtle(RaceWindow w, int nbr, int absent) {
		super(w, nbr);
		this.absent = absent;
		this.nbr = nbr;
	}
	
	public void raceStep(){
		Random rnd = new Random();
		if(rnd.nextInt(100)>absent) {
			super.raceStep();
		}
		
	}
	
	public String toString() {
		String nummer = "Nummer " + nbr + "  - AbsentMindedTurtle " + "(" + absent + "% Frånvarande)";
		return nummer;
	}
	
}
