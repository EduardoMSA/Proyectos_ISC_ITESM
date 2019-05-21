import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Tablero {
	private Celda[][] tablero;
	private Image fondo;
	public Tablero() {
		this.fondo = new ImageIcon("fondo.jpg").getImage();
		tablero = new Celda[8][8];
		for(int i = 0; i<tablero.length;i++) {
			for(int j = 0;j<tablero[i].length;j++) {
				tablero[i][j]=new Celda(i, j);
			}
		}
	}
	
	public Celda getCelda(int x,int y) {
		return this.tablero[x][y];
	}
	
	
	
	
	public void dibujaTablero(Graphics g) {
		g.drawImage(this.fondo, 0, 0, 700, 700, null);
		int px=50,
			py=50;
		for(int i = 0; i<this.tablero.length;i++) {
			for(int j = 0;j<this.tablero[i].length;j++) {
				this.tablero[j][i].dibujaCelda(g, px, py);
				px+=75;
			}
			px=50;
			py+=75;
		}
	}
	
}
