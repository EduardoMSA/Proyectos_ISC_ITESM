import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
	
public class EyM extends JPanel implements Runnable{
	
	private int xV,
				yV,
				distX = 2,
				distY = 2,
				counter;
	private double velocidad,
				   aceleracion;
	private String carga;
	private Color particula = Color.GRAY;
	private boolean simula = false;
	private Thread hilo = new Thread(this);
	
	public EyM() {
		super();
		this.carga = "-";
		this.setPreferredSize(new Dimension(800, 900));
		
	}
	
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   this.setBackground(Color.WHITE);
	   g.setColor(Color.DARK_GRAY);
	   
	   //Placas
	   g.fillRect(50, 100, 50, 100+(distY*100));
	   g.fillRect(100+(distX*100), 100, 50, 100+(distY*100));
	   g.setColor(particula);
	   
	   //Part�cula
	   g.fillOval(this.xV+((175+(distX*100)))/2, this.yV+75, 25, 25);
	   g.setColor(Color.RED);
	   
	   //Medida en Y
	   g.fillRect(200+((distX*100)), 100, 10, 100+(distY*100));
	   g.fillRect(190+((distX*100)), 100, 30, 5);
	   g.fillRect(190+((distX*100)), 200+(distY*100), 30, 5);
	   g.setFont(new Font("TimesRoman", Font.BOLD, 24)); 
	   g.drawString(this.distY + " cm", (220+((distX*100))), (280+(distY*100))/2);
	   
	   //Medida en X
	   g.fillRect(50, 240+(distY*100), 100+(distX*100), 10);
	   g.fillRect(50, 230+(distY*100), 5, 30);
	   g.fillRect(150+(distX*100), 230+(distY*100), 5, 30);
	   g.drawString(this.distX + " cm", (220+((distX*100)))/2, 280+(distY*100));
	   
	   //Signos
	   for(int i=0; i<distY+1; i++) {
		   g.setColor(Color.RED);
		   g.drawString("+", 118+(distX*100), 160+(i*100));
		   g.setColor(Color.CYAN);
		   g.drawString("-", 68, 150+(i*100));
	   }
   }

   public void run() {
	   
	    //Aqu� falta una forma de hacer que la part�cula llegue al punto final de la placa.
	    //Todo eso se pondr�a en la suma de xV porque es lo que define qu� tanto se mueve seg�n su yV
	   	try {
	   		int contador=0;
	   		while(this.xV+((175+(distX*100)))/2>100 && this.xV+((175+(distX*100)))/2<(100+(distX*100))-25) {
	   			this.yV++;
	   			this.paintImmediately(0, 0, this.getWidth(), this.getHeight());   		
	   			if(this.carga.equals("-")) {
	   				this.xV++;
	   				contador++;
	   			}
	   			else {
	   				this.xV--;
	   			}
	   		}
	   		
	   		Thread.sleep(10);
	   		
		} catch (InterruptedException e) {
			System.out.println("No se pudo ejecutar");
		}
   }
   
   public void setCarga(String carga) {
	   this.carga = carga;
   }
   
   public void setVelocidad(double velocidad) {
	   this.velocidad = velocidad;
   }
   
   public void setColor(Color particula) {
	   this.particula = particula;
   }
   
   public void setDistX(int x) {
	   this.distX = x;
	   this.repaint();
   }
   
   public void setSimula() {
	   hilo.start();
   }
   
   public void setDistY(int y) {
	   this.distY= y;
	   this.repaint();
   }
   
   public String getCarga() {
	   return this.carga;
   }
   
   public double getDistX() {
	   double a = (double) this.distX;
	   return (a/2)/100;
   }
   
   public double getDistY() {
	   double a = (double) this.distY;
	   return a/100;
   }
   
   public void setAc(double aceleracion) {
	   this.aceleracion = aceleracion;
   }
   
   public void setXv(int xV) {
	   this.xV=xV;
   }
   public void setYv(int yV) {
	   this.yV=yV;
   }
}
