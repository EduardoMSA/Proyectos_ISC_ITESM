import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class panelbarco extends JPanel implements Runnable {
	private int nivel,
				xV,
				xS,
				cambioNivel;
	private boolean ida,
					activo;
	private Image fondo;
	public panelbarco() {
		super();
		this.cambioNivel = 0;
		this.xV = 0;
		this.xS = 200;
		this.nivel = 500-cambioNivel;
		this.fondo=new ImageIcon("cielo.jpg").getImage();
		this.ida = this.activo = true;
		Thread hilo = new Thread(this);
		hilo.start();
		this.setPreferredSize(new Dimension(800, 600));
		
		
	}
	
	public void setCambioNivel(int cambioNivel) {
		this.cambioNivel=cambioNivel;
		this.nivel = 500-cambioNivel;
		this.repaint();
	}
	
	public void setActivo(boolean activo) {
		this.activo=activo;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0, 0,this.getWidth(),this.getHeight(), this);
		g.setColor(Color.BLUE);
		g.fillRect(0, nivel, this.getWidth(), this.getHeight());
		g.setColor(Color.ORANGE);
		int[] Xb = {xV,xV+200,xV+150,xV+50};
		int[] Yb = {nivel-50,nivel-50,nivel,nivel};
		g.fillPolygon(Xb, Yb, 4);
		
		g.setColor(Color.WHITE);
		int[] Xm = {xV+100,xV+xS,xV+100};
		int[] Ym = {nivel-100,nivel-65,nivel-65};
		g.fillPolygon(Xm, Ym, 3);
		
		g.setColor(Color.GRAY);
		g.drawLine(xV+100, nivel-50, xV+100, nivel-100);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (this.activo) {
			while (this.ida) {
				try {
					this.xV++;
					this.xS=200;
					this.repaint();

					Thread.sleep(10);

					if (this.xV >= this.getWidth()-200 && this.xV >= 500) {
						this.ida = false;
					}
				} catch (InterruptedException ex) {
					System.out.println("No puede arrancar");
				}
			}
			while (!this.ida) {
				try {
					this.xV--;
					this.xS=0;
					this.repaint();

					Thread.sleep(10);

					if (this.xV <= 0) {
						this.ida = true;
					}
				} catch (InterruptedException e) {
					System.out.println("No se puede correr");
				}
			}
		}


	}

}


