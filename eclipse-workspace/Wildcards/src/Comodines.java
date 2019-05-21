import java.util.ArrayList;
import java.util.Random;

public class Comodines {
	static Random rand = new Random();
	
	public static double suma(ArrayList<? extends Number> lista) {
		double suma = 0;
		/*for(int i=0; i<lista.size(); i++) {
			suma+=lista.get(i).doubleValue();
		}*/
		for(Number valor:lista) { // For mejorado
			suma+=valor.doubleValue();
		}
		return suma;
	}
	
	public static void imprime(ArrayList<?> lista) {
		/*for(int i=0; i<lista.size();i++) {
			System.out.print(lista.get(i) + " ");
		}*/
		for(Object valor:lista) {
			System.out.print(valor + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		for(int i=0; i<10;i++) {
			int x = rand.nextInt(50);
			lista.add(x);
		}
		imprime(lista);
		System.out.println(suma(lista));
	}
	
	
}
