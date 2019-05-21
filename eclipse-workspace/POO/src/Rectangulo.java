
public class Rectangulo implements Figura {
	protected double 	largo,
						ancho;
	public Rectangulo(){
		this(4.0,6.0);
	}
	public Rectangulo(double largo, double ancho) {
		this.largo=largo;
		this.ancho=ancho;
	}
	public double perimetro() {
		return (this.largo+this.ancho)*2.0;
	}
	public double area() {
		return this.ancho*this.largo;
	}
	public double volumen() {
		return 0.0;
	}
	public String toString() {
		return "Rectangulo con largo "+this.largo+" y ancho "+this.ancho;
	}
	
}