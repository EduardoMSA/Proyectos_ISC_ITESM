//import java.math.*;;

public class Triangle extends Polygon  {
	
	public Triangle(Vertex uno, Vertex dos, Vertex tres) {
		super(3);
		this.vertices[0] = uno;
		this.vertices[1] = dos;
		this.vertices[2] = tres;
		this.name = "Triangulo";
	}
}