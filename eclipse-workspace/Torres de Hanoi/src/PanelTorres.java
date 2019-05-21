
/*
 * Eduardo Méndez A01632947
 * Sebastián Serna A01633102
 * Clase con main = Principal
 * 26/02/2018
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanelTorres extends JPanel {
	private int numDiscos;
	private Torre origen, auxiliar, destino;

	public PanelTorres(int numDiscos) {
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(screenSize.width - 100, screenSize.height));
		this.numDiscos = numDiscos;
		this.origen = new Torre(1);
		this.auxiliar = new Torre(2);
		this.destino = new Torre(3);
		for (int i = numDiscos; i >= 1; i--) {
			this.origen.push(new Disco(i));
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.origen.pintaTorre(g);
		this.auxiliar.pintaTorre(g);
		this.destino.pintaTorre(g);
	}

	public Torre getOrigen() {
		return this.origen;
	}

	public Torre getAux() {
		return this.auxiliar;
	}

	public Torre getDestino() {
		return this.destino;
	}

	public void reiniciar() {
		origen.clear();
		auxiliar.clear();
		destino.clear();
		for (int i = this.numDiscos; i >= 0; i--) {
			this.origen.push(new Disco(i));
		}
		this.repaint();
	}

	public int getNumDiscos() {
		return this.numDiscos;
	}

	public void setNumDiscos(int numDiscos) {
		this.numDiscos = numDiscos;
	}

	public void reiniciar(int num) {
		origen.clear();
		auxiliar.clear();
		destino.clear();
		for (int i = num; i >= 1; i--) {
			this.origen.push(new Disco(i));
		}
		this.repaint();
	}
}
