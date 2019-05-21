import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class mipanel extends JPanel{
	private Image fondo;
	private int xV, 
				yV,
				xLabel,
				yLabel,
				subir;
	private String nombre;
	private boolean moverVamoosh;	
	private Color color;
	public mipanel() {
		super();
		this.xV=this.yV=0;
		this.xLabel=100;
		this.yLabel=570;
		color = Color.RED;
		this.fondo=new ImageIcon("pato.jpg").getImage();
		this.moverVamoosh = false;
		this.nombre="Pocoyo";
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(mipanel.this.xV<550||mipanel.this.xV<mipanel.this.getWidth()-250) {
					try {
						if(mipanel.this.moverVamoosh) {
							mipanel.this.xV+=2;
							mipanel.this.yV++;
							mipanel.this.repaint();
							
						}
						Thread.sleep(15);
					}
					catch(InterruptedException ex) {
						System.out.println("No puede arrancar");
					}
				}
				
			}
		});
		hilo.start();
		this.setPreferredSize(new Dimension(800, 600));
		this.addMouseListener(new MouseAdapter() { //Usar MauseAdapter para que no importe todos los metodos del MauseListener
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub		
				if(moverVamoosh) {
					mipanel.this.moverVamoosh = false;
				}
				else {
					mipanel.this.moverVamoosh = true;
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				mipanel.this.xLabel=e.getX();
				mipanel.this.yLabel=e.getY();
				mipanel.this.repaint();
				
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0,this.getWidth(),this.getHeight(), this);
		g.setColor(Color.black);
		g.drawLine(100+this.xV, 400-this.yV-this.subir, 100+this.xV, 515-this.yV-this.subir);
		g.setColor(Color.orange);
		g.fillOval(50+this.xV, 500-this.yV-this.subir, 200, 100);
		g.setColor(this.color);
		g.fillOval(50+this.xV, 300-this.yV-this.subir, 100, 100);
		g.setColor(Color.CYAN);
		g.fillArc(50+this.xV, 500-this.yV-this.subir, 200, 100, 0, 100);
		g.setColor(Color.BLACK);
		g.drawString("Vamos " + this.nombre + "!", this.xLabel, this.yLabel);
	}
	
	public void setSubir(int subir) {
		this.subir=subir;
		this.repaint();
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
		this.repaint();
	}
	public void setColorGlobo(Color color) {
		this.color=color;
		this.repaint();
	}
	public Color getColorGlobo() {
		return this.color;
	}

}
