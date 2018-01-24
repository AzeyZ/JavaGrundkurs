import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	private int width;
	private int blocksize;
	private int height;

	private SimpleWindow w;

	public Graphics(int w, int h, int bs)
	{
		width = w;
		height = h;
		blocksize = bs;


		this.w = new SimpleWindow(width * blocksize, height * blocksize, "Digging");
	}

	public void block(int x, int y, java.awt.Color color) {
		w.setLineColor(color);
		int left = x * blocksize;
		int right = left + blocksize -1;
		int top = y * blocksize;
		int bottom = top + blocksize -1;
		for(int row = top; row <= bottom; row++) {
			w.moveTo(left, row);
			w.lineTo(right, row);	
		}
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getBlocksize() {
		return blocksize;
	}
	public void rectangle(int x, int y, int width, int height, java.awt.Color c) {
		for(int yy = y; yy<y+height; yy++) {
			for(int xx = x; xx<x+width; xx++) {
				block(xx,yy,c);
			}

		}
	}

	public char waitForKey() {
		return w.waitForKey();
	}

}
