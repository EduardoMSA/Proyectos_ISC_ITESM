import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ficha {
	protected final String[] COLORES = {"CLARO","OSCURO"};
	protected final String[] TIPOS = {"REY","REINA","ALFIL","CABALLO","TORRE","PEON"};
	
	protected String	color,
						tipo;
	protected Image img;
	
	protected int 	X,
					Y,
					movimientos;
	
	public Ficha(int color, int tipo) {
		this.color=COLORES[color];
		this.tipo=TIPOS[tipo];
		this.movimientos=0;
		this.setImg();
	}
	
	public void anadeMovimientos() {
		this.movimientos++;
	}
	
	public int getMovimientos() {
		return this.movimientos;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setImg() {
		String imagen;
		imagen = (this.color==this.COLORES[0])?"claro":"oscuro";
		switch(tipo){
		case "REY":
			imagen+="rey";
			break;
		case "REINA":
			imagen+="reina";
			break;
		case "ALFIL":
			imagen+="alfil";
			break;
		case "CABALLO":
			imagen+="caballo";
			break;
		case "TORRE":
			imagen+="torre";
			break;
		case "PEON":
			imagen+="peon";
			break;
		}
		imagen+=".png";
		this.img=new ImageIcon(imagen).getImage();
	}
	
	public void dibujaFicha(Graphics g, int px, int py) {
		g.drawImage(this.img, px+15, py+10,50,50, null);
	}
	
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles =new ArrayList<Celda>();
		return posibles;
	}

}
