import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class twoTurtles {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "twoTurtles");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random r = new Random();
		t1.penDown();
		t2.penDown();
		double dist = Math.sqrt((t1.getX()-t2.getX())*(t1.getX()-t2.getX())) + ((t1.getY()-t2.getY())*(t1.getY()-t2.getY()));
		while(dist >= 70) {
			t1.forward(r.nextInt(10)+1);
			t1.left(r.nextInt(361)-180);
			t2.forward(r.nextInt(10)+1);
			t2.left(r.nextInt(361)-180);
			SimpleWindow.delay(10);
			dist = Math.sqrt((t1.getX()-t2.getX())*(t1.getX()-t2.getX())) + ((t1.getY()-t2.getY())*(t1.getY()-t2.getY()));
		}
	}
}
