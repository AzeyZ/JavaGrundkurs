import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class fyrkant {
	public static void main(String[] args) {
		// Deklarer variabler och fönstret
		SimpleWindow w = new SimpleWindow(600, 600, "Square");
		Square sq = new Square(100, 100, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();

			int dx = (w.getMouseX() - sq.getX()) / 10;
			int dy = (w.getMouseY() - sq.getY()) / 10;

			for(int i = 0; i <10; i++) {
				sq.erase(w);
				sq.move(dx, dy);
				sq.draw(w);
				w.delay(10);
			}
		}
	}

}
