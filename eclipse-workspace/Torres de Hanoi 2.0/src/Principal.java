import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Principal extends JFrame {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PanelTorres torres = new PanelTorres(1);
		JFrame ventana = new JFrame("Torres");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(torres);
		ventana.add(new PanelControles(torres), BorderLayout.WEST);
		ventana.pack();
		ventana.setVisible(true);

	}
}
