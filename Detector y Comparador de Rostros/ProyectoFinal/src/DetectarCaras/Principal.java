//Clase con el metodo main principal
//Eduardo Méndez
//Sebastián Serna

package DetectarCaras;

import java.io.IOException;

import javax.swing.JFrame;

import jssim.SsimException;

public class Principal extends JFrame {

    public Principal() throws SsimException, IOException, NullPointerException {
	super("Comparador");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Comparador comp = new Comparador();
	this.add(comp);
	this.pack();
	this.setVisible(true);
    }

    public static void main(String[] args) {
	try {
	    Principal p = new Principal();
	}
	catch(SsimException | IOException e1) {
	    // TODO Auto-generated catch block
	    System.out.println("Error del SSIM " + e1.getMessage());
	}
	catch(NullPointerException e2) {
	}
    }
}
