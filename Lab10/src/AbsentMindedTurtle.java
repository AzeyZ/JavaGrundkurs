import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	private int absent;

	public AbsentMindedTurtle(RaceWindow w, int nbr, int absent) {
		super(w, nbr);
		this.absent = absent;
	}
	
	public void raceStep(){
		Random rnd = new Random();
		if(rnd.nextInt(100)>absent) {
			super.raceStep();
		}
		
	}
	
	public String toString() {
		String nummer = super.toString() + "  - AbsentMindedTurtle " + "(" + absent + "% Frånvarande)";
		return nummer;
	}
	
}
