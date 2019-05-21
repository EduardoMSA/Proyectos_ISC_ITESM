public class Caja extends Rectangulo {
	protected double alto;
	public Caja() {
		this(5.0,6.0,3.0);
	}
	
	public Caja(double largo, double ancho, double alto) {
		super(largo,ancho);
		this.alto=alto;
	}
	public String toString() {
		return "Caja con largo " + this.largo + ", ancho " + this.ancho + " y alto " + this.alto;
	}
	public double volumen() {
		return super.area()*this.alto;
	}
	public double area() {
		return 2*(this.alto*this.ancho + this.alto*this.largo + super.area());
	}
	public double perimetro() {
		return this.alto*8 + this.ancho*2 + this.largo*4;
	}
	public void saluda() {
		System.out.println("Hola");
	}
}
