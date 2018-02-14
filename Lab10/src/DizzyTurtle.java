import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int yrsel;
	private Random rnd;
	public DizzyTurtle(RaceWindow w, int nbr, int yrsel) {
		super(w, nbr);
		Random rnd = new Random();
		this.rnd = rnd;
		this.yrsel = yrsel;
	}
	
	public void raceStep(){
		if(rnd.nextInt(2)==1) {
			left(yrsel);
		}
		else {
			left(-yrsel);
		}
		super.raceStep();
	}
	
	public String toString() {
		String nummer = super.toString() + "  - DizzyTurtle" + " (Yrsel : " + yrsel + ")";
		return nummer;
	}
}
