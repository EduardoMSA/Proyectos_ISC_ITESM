
public class Prueba {

	public static void main(String[] args) {
		
		Figura[] figuras = {new Rectangulo(5.5,7),new Cuadrado(8.0),new Caja()}; //Se puede llamar a Rectangulos,Cuadrados o Cajas desde figuras por que "son" figuras (Polimorfismo).
		
		for(int i=0;i<figuras.length;i++) {
			System.out.println(figuras[i]); 
			System.out.println("Perimetro "+figuras[i].perimetro());
			System.out.println("Area "+figuras[i].area());
			System.out.println("Volumen "+figuras[i].volumen());
			if(figuras[i] instanceof Caja) {
				((Caja)figuras[i]).saluda();
			}
			System.out.println();
		}
		
	}
}
