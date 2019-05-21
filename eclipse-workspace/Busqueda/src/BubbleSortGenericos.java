/*
 * Eduardo Méndez Santa Ana A01632947
 * BubbleSortGenericos
 * 19/01/18 
 */
public class BubbleSortGenericos {
	
	public static <E extends Comparable<E>> void bubbleSort(E[] lista) {
		for(int i=0;i<lista.length;i++) {
			for(int j=0;j<lista.length-1-i;j++) {
				if(lista[j].compareTo(lista[j+1])>0) {
					swap(lista, j, j+1);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> void swap(E[] lista, int i, int j) {
		E tmp=lista[i];
		lista[i]=lista[j];
		lista[j]=tmp;
	}

}
