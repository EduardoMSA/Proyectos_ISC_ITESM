//import java.math.*;;

public class Triangle implements Polygon  {
	
	private Vertex[] vertices;
	private double[] aristas;
	
	public Triangle(Vertex uno, Vertex dos, Vertex tres) {
		this.vertices = new Vertex[3];
		this.aristas = new double[3];
		this.vertices[0] = uno;
		this.vertices[1] = dos;
		this.vertices[2] = tres;
		this.aristas[0] = Math.sqrt(Math.pow(this.vertices[0].getX() - this.vertices[1].getX(), 2)+Math.pow(this.vertices[0].getY() - this.vertices[1].getY(), 2)); // 1 a 2;
		this.aristas[1] = Math.sqrt(Math.pow(this.vertices[1].getX() - this.vertices[2].getX(), 2)+Math.pow(this.vertices[1].getY() - this.vertices[2].getY(), 2)); // 2 a 3;
		this.aristas[2] = Math.sqrt(Math.pow(this.vertices[2].getX() - this.vertices[0].getX(), 2)+Math.pow(this.vertices[2].getY() - this.vertices[0].getY(), 2)); // 3 a 1;
	}
	
	
	public double area() {
		return Math.sqrt((this.perimetro()/2)*((this.perimetro()/2)-this.aristas[0])*((this.perimetro()/2)-this.aristas[1])*((this.perimetro()/2)-this.aristas[2]));
	}
	public double perimetro() {
		return this.aristas[0] + this.aristas[1] + this.aristas[2];
	}
}
