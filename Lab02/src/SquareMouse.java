import java.awt.Color;
import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class SquareMouse {
	public static void main(String[] args) {
		//Deklarer variabler och fönstret
		SimpleWindow w = new SimpleWindow(600, 600, "Square");
		double oldX = 0;
		double oldY = 0;
		int lastX = 0;
		int lastY = 0;
		int Steg = 40;
		//Animations while sats
		while (true) {
			w.waitForMouseClick();
			//Tar bort senaste fyrkanten från förra klicket
			w.setLineColor(Color.white);
			Square sqlast = new Square(lastX,lastY,100);
			sqlast.draw(w);
			w.setLineColor(Color.black);
			//Hämtar nya klick kordinater och beräknar steglängden
			double newX = w.getMouseX();
			double newY = w.getMouseY();
			double xDist = (newX - oldX) / Steg;
			double yDist = (newY - oldY) / Steg;
			//double restX = newX%Steg;
			//double restY = newY%Steg;
			
			//For sats som ritar ut och tar bort förfyttningen
			for (int i = 0; i < Steg; i++) {
				double xSteg = oldX + xDist * i;
				double ySteg = oldY + yDist * i;
				
				int xStegint = (int) Math.round(xSteg);
				int yStegint = (int) Math.round(ySteg);
				
				//Ritar fyrkanterna
				w.moveTo(xStegint, yStegint);
				Square sq = new Square(xStegint, yStegint, 100);
				sq.draw(w);				
				SimpleWindow.delay(14);
				if (i != (Steg - 1)) sq.erase(w);
				//Sparar sista kvadratens position
				lastX = xStegint;
				lastY = yStegint;
				
				
			}
			//Sparar förra klick positionen
			oldX = newX;
			oldY = newY;
		}
	}
}
