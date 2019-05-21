import java.awt.Point;

import javax.swing.JOptionPane;

public class DentroRectangulo {
	
	static boolean dentro(Point p1, Point p2, Point p3, Point p4, Point p5) {
		if((p5.getX()>p1.getX())&&(p5.getX()<p2.getX())&(p5.getY()>p3.getY())&&(p5.getY()<p1.getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Point[] puntos=new Point[5];
		int x,
			y;
		for(int i=0;i<puntos.length;i++) {
			if(i<4) {
				x=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor en X del punto " + (i+1)));
				y=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor en Y del punto " + (i+1)));
			} else {
				x=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor en X del punto que quieres conocer"));
				y=Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor en Y del punto que quieres conocer"));
			}
			puntos[i]=new Point(x, y);
			
		}
		if(dentro(puntos[0], puntos[1], puntos[2], puntos[3], puntos[4])) {
			JOptionPane.showMessageDialog(null, "Está Dentro");
		}
		else {
			JOptionPane.showMessageDialog(null, "Está Fuera");
		}
	}

}
