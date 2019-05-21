
public class Polygon extends Figure {
	
	private int n;
	protected Vertex[] vertices;
	
	public Polygon(int n) {
		this.n=n;
		this.vertices = new Vertex[this.n];
	}
	
	public double getArea() { // Formula obtenida de http://bit.ly/2xRErIz
		double 	a=0,
				b=0;
		for(int i = 1; i<vertices.length; i++) {
			a+=(this.vertices[i-1].getX() * this.vertices[i].getY());
			b+=(this.vertices[i-1].getY() * this.vertices[i].getX());
		}
		
		return Math.abs((a-b)/2);
	}
}
