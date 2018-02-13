import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	int nbr;
	int yrsel;
	Random rnd;
	public DizzyTurtle(RaceWindow w, int nbr, int yrsel) {
		super(w, nbr);
		this.nbr = nbr;
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
		String nummer = "Nummer " + nbr + "  - DizzyTurtle" + " (Yrsel : " + yrsel+ ")";
		return nummer;
	}
}
