import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;

import javax.swing.JPanel;

public class PanelTorres extends JPanel{
		private int numDiscos,
					contador;
		private Torre origen,
				      auxiliar,
				      destino;

		public PanelTorres(int numDiscos) {
			super();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setPreferredSize(new Dimension(screenSize.width-100, screenSize.height));
			this.numDiscos=numDiscos;
			this.origen = new Torre(1);
			this.auxiliar = new Torre(2);
			this.destino = new Torre(3);
			for(int i = 1; i<numDiscos+1;i++) {
				this.origen.push(new Disco(i));
				//this.destino.push(new Disco(i));
				//this.auxiliar.push(new Disco(i));
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.origen.pintaTorre(g);
			this.auxiliar.pintaTorre(g);
			this.destino.pintaTorre(g);
		}
		
		public void hanoi(int n, Torre origen, Torre auxiliar, Torre destino) {
			
			if(n==1) {
				destino.push(origen.pop());
				System.out.println("Movimiento de " + origen.num + " a " + destino.num);
				this.repaint();
				
			} else {
				hanoi(n-1,origen,destino,auxiliar);
				destino.push(origen.pop());
				this.repaint();
				System.out.println("Movimiento de " + origen.num + " a " + destino.num);
				hanoi(n-1,auxiliar,origen,destino);
			}
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
			for(int i = 1; i<numDiscos+1;i++) {
				this.origen.push(new Disco(i));
			}
			this.repaint();
		}
		
		public int getNumDiscos() {
			return this.numDiscos;
		}
		
		public void reiniciar(int num) {
			origen.clear();
			auxiliar.clear();
			destino.clear();
			for(int i = 1; i<num+1;i++) {
				this.origen.push(new Disco(i));
			}
			this.repaint();
		}
}
