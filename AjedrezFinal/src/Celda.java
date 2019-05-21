import java.awt.Color;
import java.awt.Graphics;

public class Celda {
	private int x,
				y,
				ancho,
				alto;
	private Ficha ficha;
	private Color color;
	private boolean resaltado;
	public Celda(int x, int y) {
		this.x=x;
		this.y=y;
		this.ficha=null;
		this.ancho=75;
		this.alto=75;
		this.resaltado=false;
		//this.color = (((this.x+this.y)%2)==1)?new Color(105, 130, 102):new Color(206,247,202);
		this.color = (((this.x+this.y)%2)==1)?Color.GRAY:Color.WHITE;
	}
	
	public Celda(Ficha ficha) {
		this.x=0;
		this.y=0;
		this.ficha=ficha;
		this.ancho=0;
		this.alto=0;
		this.resaltado=false;
		this.color=Color.BLACK;
	}
	
	public void setFicha(Ficha ficha) {
		this.ficha=ficha;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Ficha getFicha() {
		return this.ficha;
	}
	
	public void setResaltado(boolean resaltado) {
		this.resaltado=resaltado;
	}
	
	public void dibujaCelda(Graphics g, int px, int py) {
		if (this.resaltado) {
			g.setColor(this.color);
			g.fillRect(px, py, this.ancho, this.alto);
			if(this.tieneFicha()) {
				g.setColor(Color.red);
			}
			else {
				g.setColor(Color.GREEN);
			}
			g.fillRect(px+1, py+1, this.ancho-2, this.alto-2);
			g.setColor(this.color);
			g.fillRect(px+5, py+5, this.ancho-10, this.alto-10);
			if (this.tieneFicha()) {
				this.ficha.dibujaFicha(g, px, py);
			}
			this.resaltado=false;
		} else {
			g.setColor(this.color);
			g.fillRect(px, py, this.ancho, this.alto);
			if (this.tieneFicha()) {
				this.ficha.dibujaFicha(g, px, py);
			}
		}
	}
	
	public boolean tieneFicha() {
		if(this.ficha!=null) {
			return true;
		}
		else {
			return false;
		}
	}
}