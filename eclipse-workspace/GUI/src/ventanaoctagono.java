/*Eduardo Méndez Santa Ana
 * A01632947
 */

import javax.swing.JFrame;

public class ventanaoctagono extends JFrame{
	public ventanaoctagono(){
		super("Prueba");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		paneloctagono pnl = new paneloctagono();
		this.add(pnl);
		this.pack();
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ventanaoctagono vo = new ventanaoctagono();
	}
}
