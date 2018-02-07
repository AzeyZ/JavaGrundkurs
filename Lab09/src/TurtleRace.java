import java.util.ArrayList;

public class TurtleRace {
		
	public static void main(String[] args) {
		boolean gameOver = false;
		RaceWindow w = new RaceWindow();
		ArrayList <RaceTurtle> turtleList = new ArrayList<RaceTurtle>();
		ArrayList <RaceTurtle> finished = new ArrayList<RaceTurtle>();
		for ( int i = 0; i< 8; i++) {
			turtleList.add(new RaceTurtle(w,(i+1)));
		}
		while(!gameOver) {
			w.delay(10);
			for(int j = 0; j<turtleList.size(); j++) {
				turtleList.get(j).raceStep();
				if(turtleList.get(j).getX()>=w.X_END_POS) {
					finished.add(turtleList.get(j));
					turtleList.remove(j);
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
