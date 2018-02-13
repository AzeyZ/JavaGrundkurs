import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	private int nbr;

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.nbr = nbr;
	}
	
	public void raceStep(){
		Random rnd = new Random();
		int dig = rnd.nextInt(2);
		if(dig==0) {
			penDown();
		}
		else {
			penUp();
		}
		super.raceStep();
	}
	
	public String toString() {
		String nummer = "Nummer " + nbr + "  - MoleTurtle";
		return nummer;
	}
	
}
