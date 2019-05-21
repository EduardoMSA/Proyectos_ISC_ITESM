
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.Math;

import javax.swing.JPanel;

/*Eduardo Méndez Santa Ana
 * A01632947
 */
public class paneloctagono extends JPanel{
	private int[] puntosX,
				  puntosY;
	private int lados;
	public paneloctagono() {
		super();
		this.lados = 500; //Inserta cuantos lados quieres que tenga la espiral
		puntosX = new int[lados];
		puntosY = new int[lados];
		this.setPreferredSize(new Dimension(800, 600));
		this.setPuntos(200, 400, 300, lados); //Modifica el tamaño del poligono (Apotema, X del centro, Y del centro, # de lados) 
		
	}
	
	public void setPuntos(int apotema, int xCentro, int yCentro, int lados) {
		double angulo = 270; //Punto de incio
		for(int i = 0; i<lados;i++) {
			double diagonal = Math.sqrt((Math.pow(apotema, 2))+(Math.pow(apotema*Math.tan(Math.toRadians((360/(double)(lados))/2)), 2)));
			puntosX[i]=(int)(xCentro + (diagonal*Math.cos(Math.toRadians(angulo))));
			puntosY[i]=(int)(yCentro - (diagonal*Math.sin(Math.toRadians(angulo))));
			angulo+=(360/8)%360;//Modifica los lados para crear espirales; Cambia por /lados para crear poligonos regulares;
			if(i%1==0) { //Modifica el modulo para cambiar cada cuanto se cierra el poligono
				apotema = (int)(apotema*.9995); //Modifica para cambiar cuanto se disminuye el apotema
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		for(int i = 0;i<this.lados-1;i++) { //Quita el -1 para hacer que el poligono se cierre 
			g.drawLine(puntosX[i], puntosY[i], puntosX[(i+1)%this.lados], puntosY[(i+1)%this.lados]);
		}
		
	}
}
