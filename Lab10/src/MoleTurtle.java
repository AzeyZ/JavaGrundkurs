import java.util.Random;

public class MoleTurtle extends RaceTurtle {
	private Random rnd = new Random();
	
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	public void raceStep(){
		
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
		String nummer = super.toString() + "  - MoleTurtle";
		return nummer;
	}
	
}
