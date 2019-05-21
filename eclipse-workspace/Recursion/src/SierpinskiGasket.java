import java.awt.Graphics;
import java.awt.Point;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiGasket extends JFrame{
	private int level;
	public SierpinskiGasket() {
		super("Fractal SierpinskiGasket");
		this.setSize(640,480);
		this.level=Integer.parseInt(JOptionPane.showInputDialog("INtroduce el nivel del Fractal"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point a=new Point(30, 380);
		Point b=new Point(620, 380);
		Point c=new Point(320, 50);
		this.pintaTriangulos(g,this.level,a,b,c);
	}
	
	private Point puntoMedio(Point a, Point b) {
		return new Point((a.x+b.x)/2,(a.y+b.y)/2);
	}
	
	private void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	private void pintaTriangulos(Graphics g, int level, Point a, Point b, Point c) {
		if(level==0) {
			this.pintaLineas(g, a, b);
			this.pintaLineas(g, a, c);
			this.pintaLineas(g, b, c);
		}
		else {
			Point pmAB=this.puntoMedio(a, b),
				  pmBC=this.puntoMedio(b, c),
				  pmCA=this.puntoMedio(c, a);
			this.pintaTriangulos(g, level-1, a, pmAB, pmCA);
			this.pintaTriangulos(g, level-1, pmAB, b, pmBC);
			this.pintaTriangulos(g, level-1, pmCA, pmBC, c);
			
		}
	}
	
	public static void main(String[] args) {
		SierpinskiGasket s = new SierpinskiGasket();
	}
}
