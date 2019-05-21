
public class Rectangle implements Polygon{
	private double ancho;
	private double largo;
	
	public Rectangle(double ancho,double largo) {
		this.ancho=ancho;
		this.largo=largo;
	}
	public double area() {
		return this.ancho*this.largo;
	}
	public double perimetro() {
		return (2*this.ancho)+(2*this.largo);
	}
	
}
