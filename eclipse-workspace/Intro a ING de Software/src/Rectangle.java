
public class Rectangle implements Polygon{
	private double 	ancho,
					largo,
					area,
					perimetro;
	
	public Rectangle(double ancho,double largo) {
		this.ancho=ancho;
		this.largo=largo;
		this.setPerimetro();
		this.setArea();
	}
	public void setArea() {
		this.area = this.ancho*this.largo;
	}
	public void setPerimetro() {
		this.perimetro = (2*this.ancho)+(2*this.largo);
	}
	public double getArea() {
		return this.area;
	}
	public double getPerimetro() {
		return this.perimetro;
	}
	
}
