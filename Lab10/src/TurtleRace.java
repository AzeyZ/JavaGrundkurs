import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
		
	public static void main(String[] args) {
		boolean gameOver = false;
		RaceWindow w = new RaceWindow();
		ArrayList <RaceTurtle> turtleList = new ArrayList<RaceTurtle>();
		ArrayList <RaceTurtle> finished = new ArrayList<RaceTurtle>();
		Random rnd = new Random();
		for ( int i = 0; i< 8; i++) {
			int R = rnd.nextInt(3);
			if(R==0) turtleList.add(new MoleTurtle(w,(i+1)));
			if(R==1) turtleList.add(new DizzyTurtle(w,(i+1),rnd.nextInt(5)+1));
			if(R==2) turtleList.add(new AbsentMindedTurtle(w,(i+1),rnd.nextInt(100)));
		}
		for(int i = 0; i<turtleList.size(); i++) {
			System.out.println(turtleList.get(i));
		}
		
		while(!gameOver) {
			w.delay(10);
			for(int j = 0; j<turtleList.size(); j++) {
				turtleList.get(j).raceStep();
				if(turtleList.get(j).getX()>=w.X_END_POS) {
					finished.add(turtleList.get(j));
					turtleList.remove(j);
					j--;
				}
				if(turtleList.size()== 0) {
					gameOver = true;
				}
			}
		}
		for(int k = 0; k< 3; k++) {
			System.out.println("På plats " + (k+1) + ": " + finished.get(k));
		}
	}
}
