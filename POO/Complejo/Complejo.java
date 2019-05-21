/*
-Eduardo Méndez Santa Ana
-A01632947
*/

public class Complejo{
	private double x,
		       i;
	public Complejo(){	
	}
	public Complejo(double x, double i){
		this.establecer(x,i);		
	}
	public void establecer(double x, double i){
		this.x = x;
		this.i = i;
	}
	public void imprimir(){
		if(i>=0){
			System.out.println(this.x + " + " + this.i + "i");
		} else {
			System.out.println(this.x + " " + this.i + "i");
		}
	}
	public void agregar(double x, double i){
		this.x = this.x + x;
		this.i = this.i + i;
	}
	public void agregar(Complejo numero){
		this.x = this.x + numero.x;
		this.i = this.i + numero.i;
	}
	public Complejo suma(Complejo numero){
		return new Complejo(this.x + numero.x, this.i + numero.i);
	}
	public Complejo resta(Complejo numero){
		return new Complejo(this.x - numero.x, this.i - numero.i);
	}
	public Complejo multiplicacion(Complejo numero){
		return new Complejo(this.x*numero.x + this.i*numero.i, this.x*numero.i + this.i*numero.x);
	}
	public Complejo multiplicacion(double x){
		return new Complejo(this.x*x, this.i*x);
	}
	public Complejo conjugado(){
		return new Complejo(this.x, -this.i);
	}
}