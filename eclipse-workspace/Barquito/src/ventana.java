import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ventana extends JFrame {
	
	public ventana() {
		super("Barquito");
		panelbarco pb = new panelbarco();
		panelcontrol pc = new panelcontrol(pb);
		this.add(pb);
		this.add(pc, BorderLayout.WEST);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ventana uno = new ventana();
		

	}

}
