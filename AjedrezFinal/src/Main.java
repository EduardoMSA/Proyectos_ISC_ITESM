
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class Main extends JFrame{
	public Main(){
		super("Prueba");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Juego juego = new Juego();
		//Juego juego = new Juego(true);
		this.add(new PanelControl(juego), BorderLayout.NORTH);
		this.add(new panelOpciones(juego), BorderLayout.SOUTH);
		this.add(juego);
		this.pack();
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		Main main = new Main();
	}
}

