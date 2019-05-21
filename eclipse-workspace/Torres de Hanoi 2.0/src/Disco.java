import java.awt.Color;
import java.awt.Graphics;

public class Disco  {
	final static Color[] COLORES = {Color.RED,Color.BLACK,Color.PINK,Color.BLUE,Color.GREEN,Color.YELLOW,Color.GRAY,Color.CYAN,Color.MAGENTA,Color.ORANGE};
	int size,
		ancho;
	public Disco(int size) {
		this.size=size;
		this.ancho=size*30;
	}
	public void pintaDisco(Graphics g, int x, int y) {
		g.setColor(COLORES[this.size-1]);
		g.fillRect(x-(ancho/2), y, this.ancho, 30);
	}
}
