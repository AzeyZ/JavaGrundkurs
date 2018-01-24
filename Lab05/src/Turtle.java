import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	private double x;
	private double y;
	private double angle;
	private boolean penDown;
	private SimpleWindow w;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, double x, double y) {
		this.x = x;
		this.y = y;
		this.w = w;
		angle = Math.PI/2;
		penDown = false;
		w.moveTo((int) Math.round(x), (int)Math.round(y));
	}

	/** Sänker pennan. */
	public void penDown() {
		penDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		penDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(double n) {
		w.moveTo((int)Math.round(x), (int)Math.round(y));
		x = x + n * Math.cos(angle);
		y = y - n * Math.sin(angle);

		if (penDown) {
			w.lineTo((int)Math.round(x), (int)Math.round(y));
		} else
			w.moveTo((int)Math.round(x), (int)Math.round(y));
	}
	
	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		angle += beta*Math.PI/180;
	}
	
	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(double newX, double newY) {
		x = newX;
		y = newY;
		w.moveTo((int)Math.round(x), (int)Math.round(y));
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		angle = Math.PI/2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int)Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int)Math.round(y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return (int)Math.round(angle*180/Math.PI);
	}
}
