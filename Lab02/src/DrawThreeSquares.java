import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawThreeSquares {
	public static void main(String[] args) {
		int x = 250;
		int y = 250;
		int s = 100;
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		for(int i=0;i<3;i++) {
			Square sq = new Square(x, y, s);
			sq.draw(w);
			x=x+50;
			y=y-50;
			if(i==1) {
				y=y + 65;
				x=x-30;
			}
		}
	}
}
