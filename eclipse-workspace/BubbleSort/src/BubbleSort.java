/*
 * Eduardo Méndez Santa Ana
 * A01632947
 */
public class BubbleSort {
	public <E extends Comparable<E>>void bubbleSort(E[] arreglo) {
		boolean ordenado;
		E tmp;
		do {
			ordenado = true;
			for(int i = 0; i<arreglo.length-1;i++) {
				if(arreglo[i].compareTo(arreglo[i+1])>0) {
					ordenado=false;
					tmp=arreglo[i];
					arreglo[i]=arreglo[i+1];
					arreglo[i+1]=tmp;
				}
			}
		} while(!ordenado);
	}
	
	//Metodo para facilitar la comprobacion de los arreglos, No es necesario para el funcionamiento del ordenamiento.
	public <E>void imprimir(E[] arreglo){
		for(int i=0;i<arreglo.length-1;i++) {
			System.out.print(arreglo[i]+", ");
		}
		System.out.print(arreglo[arreglo.length-1]);
		System.out.println();
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		Integer[] arregloNumeros = {5,6,7,1,2,3,10,25,8};
		bs.bubbleSort(arregloNumeros);
		bs.imprimir(arregloNumeros);
			
		String[] arregloPalabras = {"Tres","Tristes","Tigres","Tragaban","Trigo","En","Un","Trigal"};
		bs.bubbleSort(arregloPalabras);
		bs.imprimir(arregloPalabras);
		
		Double[] arregloDecimales = {1.2,5.6,0.5,8.4,75.0,5.0,0.122};
		bs.bubbleSort(arregloDecimales);
		bs.imprimir(arregloDecimales);
		
	}
}

