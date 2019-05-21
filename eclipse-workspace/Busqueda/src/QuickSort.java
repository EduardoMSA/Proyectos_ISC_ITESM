/*
 * Eduardo Méndez Sata Ana A01632947
 * QuickSort
 * 28/01/18
 */

import java.util.Random;

public class QuickSort {
	
	
	public static void quicksort(int[] arreglo) {
		quicksort(arreglo, 0, arreglo.length-1);
	}
	public static void quicksort(int[] arreglo, int min, int max) {
		if(min<max) {
			int posPivote=particionar(arreglo, min, max);
			quicksort(arreglo, min, posPivote-1);
			quicksort(arreglo, posPivote+1, max);
		}
	}
	private static int particionar(int[] arreglo, int min, int max) {
		Random rand = new Random();
		swap(arreglo, min+rand.nextInt(max-min), max);
		int pivote=max;
		max--;
		
		while(min<=max) {
			if(arreglo[min]<arreglo[pivote]) {
				min++;
			} else {
				swap(arreglo, min, max);
				max--;
			}
		}
		swap(arreglo, min, pivote);
		return min;
	}
	
	private static void swap(int[] arreglo, int origen, int destino) {
		int tmp=arreglo[origen];
		arreglo[origen]=arreglo[destino];
		arreglo[destino]=tmp;
	}
	
	public static void main(String[] args) {
		int[] nombres = {1,4,6,3,5};
		for(int nombre:nombres) {
			System.out.print(nombre+ " ");
		}
		System.out.println();
		quicksort(nombres);
		for(int nombre:nombres) {
			System.out.print(nombre + " ");
		}
		System.out.println();
		
	}

}
