package cardgame;
import pair.Pair;
import pair.PairSet;

public class Simulate {
	
	private static final int NBR_ITERATIONS = 1000000;
	private PairSet deck;
	
	public Simulate() {
		this.deck = new PairSet(4,13);
	}
	
	public static void main(String[] args) {
		double klarade = 0;
		for(int i=0; i<NBR_ITERATIONS;i++) {
			Simulate s = new Simulate();
			if(s.patiens()) {
				klarade++;
			}
		}
		System.out.println((klarade/NBR_ITERATIONS));
	}
	
	public boolean patiens() {
		int säger = 1;
		while(deck.more()) {
			Pair picked = deck.pick();
			if(picked.second() == säger) {
				return false;
			}			
			säger++;
			if(säger>3) säger = 1;
		}
		return true;
	}
}