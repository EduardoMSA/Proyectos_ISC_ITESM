
public class Triangle extends Polygon {
	
	private Point[] vertices;

	public Triangle(Point uno, Point dos, Point tres) {
		
		vertices = new Point[3];
		vertices[0] = uno;
		vertices[1] = dos;
		vertices[2] = tres;
		n = 3;
		name = "Triangulo";
	}
	
	public double[] getAristas() {
		double[] aristas = new double[3];
		aristas[0] = Math.sqrt(Math.pow(this.vertices[0].getX() - this.vertices[1].getX(), 2)+Math.pow(this.vertices[0].getY() - this.vertices[1].getY(), 2)); // 1 a 2;
		aristas[1] = Math.sqrt(Math.pow(this.vertices[1].getX() - this.vertices[2].getX(), 2)+Math.pow(this.vertices[1].getY() - this.vertices[2].getY(), 2)); // 2 a 3;
		aristas[2] = Math.sqrt(Math.pow(this.vertices[2].getX() - this.vertices[0].getX(), 2)+Math.pow(this.vertices[2].getY() - this.vertices[0].getY(), 2)); // 3 a 1;
		return aristas;
	}

	public double getArea() {
		return Math.sqrt((this.getPerimetro()/2)*((this.getPerimetro()/2)-this.getAristas()[0])*((this.getPerimetro()/2)-getAristas()[1])*((this.getPerimetro()/2)-getAristas()[2]));
	}
	
	public double getPerimetro() {
		return getAristas()[0] + getAristas()[1] + getAristas()[2];
		
	}
}


