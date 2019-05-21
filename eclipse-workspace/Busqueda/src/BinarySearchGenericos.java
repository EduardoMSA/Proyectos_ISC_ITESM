/*
 * Eduardo Méndez Santa Ana A01632947
 * BinarySearchGenericos
 * 19/01/18
 */


public class BinarySearchGenericos {

	public static <E extends Comparable<E>> int binarySearch(E valor, E[] valores) {
		int min=0,
			max=valores.length-1,
			avg;
		
		while(min<=max) {
			avg=(max+min)/2;
			if(valores[avg].compareTo(valor)==0) {
				return avg;
			}
			else if(valor.compareTo(valores[avg])<0) {
				max = avg-1;
			}
			else {
				min = avg+1;
			}
			
		}
		
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearchRec(E valor,E[] valores) {
		return binarySearchRec(valor, valores, 0, valores.length-1);
	}
	
	public static <E extends Comparable<E>> int binarySearchRec(E valor,E[] valores,int min, int max) {
		if(min<max) {
			int avg = (min+max)/2;
			if(valor.compareTo(valores[avg])<0) {
				return binarySearchRec(valor, valores, min, avg-1);
			}
			else if(valor.compareTo(valores[avg])>0) {
				return binarySearchRec(valor, valores, avg+1, max);
			}
			else {
				return avg;
			}
		}
		return -1;
	}
}
