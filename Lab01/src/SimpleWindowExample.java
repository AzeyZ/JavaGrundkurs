import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class SimpleWindowExample {

	public static void main(String[] args){
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
		int wid = 10;
		w.setLineColor(Color.BLUE);
		w.setLineWidth(wid);
		w.moveTo(100,  100);
		w.lineTo((150+(wid/2)),  100);
		w.moveTo(150,100);
		w.lineTo(150, (150+(wid/2)));
		w.moveTo(150, 150);
		w.lineTo((100-wid/2),150);
		w.moveTo(100, 150);
		w.lineTo(100, (100-(wid/2)));
	}
}
