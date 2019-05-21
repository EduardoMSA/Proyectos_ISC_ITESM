import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		super("Simulador");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EyM panel = new EyM();
		this.add(panel);
		this.add(new Controles(panel), BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
	}
}
