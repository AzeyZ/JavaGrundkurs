public class Mole {
	private Graphics g = new Graphics(30,50,10);


	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 0, 30, 50, Colors.SOIL);
		g.rectangle(0, 0, 30, 5, Colors.SKY);
		g.rectangle(0, 5, 30, 1, Colors.GRASS);
	}

	public void dig() {
		int x = g.getWidth()/2;
		int y = g.getHeight()/2;
		while (true) {

			g.block(x, y, Colors.MOLE);

			char key = g.waitForKey();

			if(y!=5)g.block(x, y, Colors.TUNNEL);
			if(y==5)g.block(x, y, Colors.GRASS);

			if      (key == 'w' && y>5) {
				y=y-1;
			}
			else if (key == 's' && y<g.getHeight()-1) {
				y=y+1;
			}
			else if (key == 'a' && x>0) {
				x=x-1;
			}
			else if (key == 'd' && x<g.getWidth()-1) {
				x=x+1;
			}

		}
	}
}
