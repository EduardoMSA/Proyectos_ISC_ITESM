import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

public class Torre extends Stack<Disco>{
	int num;
	public Torre(int num) {
		super();
		this.num= num;
	}
	public void pintaTorre(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((num*500)-3, 90, 6, 310);
		g.fillRect((num*500)-160, 400, 320, 50);
		Disco[] tmp = new Disco[this.size()];
		Disco[] discos = this.toArray(tmp);
		//for(int i = discos.length-1;i>0;i--) {
		for(int i = 0; i<this.size();i++) {
			discos[i].pintaDisco(g, num*500, 400-((this.size()-i)*30));
		}
	}
}
