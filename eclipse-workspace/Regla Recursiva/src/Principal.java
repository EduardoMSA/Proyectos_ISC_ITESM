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


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Principal {
	
	public static void main(String[] args) {
		JFrame ventana=new JFrame("Regla recursiva - Eduardo Méndez Santa Ana - A01632947 - Gpo 1");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReglaRecursiva regla=new ReglaRecursiva();
		ventana.add(regla);
		ventana.add(new PanelControl(regla),BorderLayout.WEST);
		ventana.pack();
		ventana.setVisible(true);
	}

}
