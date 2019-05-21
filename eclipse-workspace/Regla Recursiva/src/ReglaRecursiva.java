/*
 * Eduardo Méndez Santa Ana A01632947
 * Clase donde está el main: Principal
 * 23/01/18
 * 
 * El repaint dentro de la clase ReglaRecursiva ocasiona que se vea doble la regla
 * cada vez que se quiere utilizar el JSlider,
 * cambiar de tamaño la ventana hace que se vea normal la regla.
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ReglaRecursiva extends JPanel {
	private int nivel;
	
	public ReglaRecursiva() {
		super();
		this.nivel=1;
		this.setPreferredSize(new Dimension(1000, 300));
	}
	
	public void setNivel(int nivel) {
		this.nivel=nivel;
		this.repaint(); // Repaint ocasiona que se vea doble la ventana
	}
	
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(20, 250, this.getWidth()-20, 250);
		this.pintaRegla(g, 20, this.getWidth()-20, this.nivel);
	}
	
	public void pintaRegla(Graphics g, int inicio, int fin, int nivel) {
		int x=(inicio+fin)/2;
		if(nivel>0) {
			g.drawLine(x, 250, x, 250-(nivel*15)); //15 es el tamaño que se aumenta al tick en cada nivel
			this.pintaRegla(g, inicio, x, nivel-1);
			this.pintaRegla(g, x, fin, nivel-1);
		}
	}


}
