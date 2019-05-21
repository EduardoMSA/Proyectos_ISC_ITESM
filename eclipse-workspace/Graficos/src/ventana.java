
//import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ventana extends JFrame {
	
	public ventana() {
		super("Mi primer ventana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mipanel PanelDibujo = new mipanel();
		this.add(PanelDibujo);
		this.add(new PanelControles(PanelDibujo), BorderLayout.WEST);
		this.pack(); //La ventana se ajusta al tamaño del panel
		this.setVisible(true);
		//this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); -La ventana toma el tamaño de la pantalla
	}
	
	
	
	public static void main(String[] args) {
		ventana uno = new ventana();
		
	}
}
