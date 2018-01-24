import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class tusenSteps {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "tusenSteg");
		Turtle t = new Turtle(w, 300, 300);
		Random r = new Random();
		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(r.nextInt(10)+1);
			t.left(r.nextInt(361)-180);
		}
	}
}
