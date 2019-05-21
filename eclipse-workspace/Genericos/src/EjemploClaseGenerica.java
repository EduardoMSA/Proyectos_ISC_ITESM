
public class EjemploClaseGenerica<E extends Comparable<E>>{ //Siempre se utliza extends cuando se define un Generico //Comparable es parametrizada, necesita poner el valor al que  se comparara
	
	private E[] arreglo;
	
	public EjemploClaseGenerica(E[] arreglo) {
		this.arreglo=arreglo;
	}
	
	public EjemploClaseGenerica(int size) {
		this.arreglo=(E[]) new Comparable[size];
	}

	public E min() {
		E menor = arreglo[0];
		for(int i = 1; i<arreglo.length;i++) {
			if(arreglo[i].compareTo(menor)<0) {
				menor=arreglo[i];
			}
		}
		return menor;
	}
	
	public int largo() {
		return arreglo.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] palabras= {"hola","que","tal","como","estas","espero","que","Bien","bye"};
		
		Double[] decimales= {10.1,15.4,1.0,8.9,9.2,3.5,7.6};
		
		Integer[] numeros = {10,15,1,8,9,3,7};
		
		EjemploClaseGenerica<Integer> ecg1 = new EjemploClaseGenerica<>(numeros);
		EjemploClaseGenerica<Double> ecg2 = new EjemploClaseGenerica<>(decimales);
		EjemploClaseGenerica<String> ecg3 = new EjemploClaseGenerica<>(palabras);
		EjemploClaseGenerica<Integer> ecg4 = new EjemploClaseGenerica<>(5);
		
		int a = ecg1.min();
		double b =ecg2.min();
		String c = ecg3.min();
		
		System.out.println("El menor es "+a);
		System.out.println("El menor es "+b);
		System.out.println("El menor es "+c);
		System.out.println(ecg4.largo());
		

	}

}
