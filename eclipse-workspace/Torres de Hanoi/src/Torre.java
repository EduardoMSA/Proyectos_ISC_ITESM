
/*
 * Eduardo Méndez A01632947
 * Sebastián Serna A01633102
 * Clase con main = Principal
 * 26/02/2018
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

public class Torre extends Stack<Disco> {
	private int num;

	public Torre(int num) {
		super();
		this.num = num;
	}

	public void pintaTorre(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((num * 500) - 3, 90, 6, 310);
		g.fillRect((num * 500) - 160, 400, 320, 50);
		Disco[] tmp = new Disco[this.size()];
		Disco[] discosInvertido = this.toArray(tmp);
		Disco[] discos = new Disco[discosInvertido.length];
		int maximo = discosInvertido.length;
		for (int i = 0; i < discosInvertido.length; i++) {
			discos[maximo - 1] = discosInvertido[i];
			maximo--;
		}
		for (int i = 0; i < discos.length; i++) {
			discos[i].pintaDisco(g, num * 500, 400 - ((this.size() - i) * 30));
		}
	}

	public int getNum() {
		return this.num;
	}
}
