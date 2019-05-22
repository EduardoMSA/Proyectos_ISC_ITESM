/*Andres Aguirre Alvarez
  A01228159
  .java
*/

public class BusquedaBinaria {
//	public static int binarySearch(int valor,int[] datos) {
//		int min=0,
//			max=datos.length-1,
//			avg;
//		
//		while(min<=max) {
//			avg=(min+max)/2;
//			if(datos[avg]==valor) {
//				return avg;
//			} else if(datos[avg]<valor){
//				min=avg+1;
//			} else {
//				max=avg-1;
//			}
//		}
//		return -1;
//	}
	
//	public static int binarySearch(String valor,String[] datos) {
//		int min=0,
//			max=datos.length-1,
//			avg;
//		
//		while(min<=max) {
//			avg=(min+max)/2;
//			if(datos[avg].equals(valor)) {
//				return avg;
//			} else if(valor.compareTo(datos[avg])<0){
//				max=avg-1;
//			} else {
//				min=avg+1;
//			}
//		}
//		return -1;
//	}
	
	public static <E extends Comparable<E>> int binarySearch(E valor,E[] valores) {
		return binarySearch(valor, valores, 0, valores.length-1);
	}
	
	
	private static <E extends Comparable<E>> int binarySearch(E valor,E[] valores,int min,int max) {
		if(min<=max) {
			if(valores[(min+max)/2].equals(valor)) {
				return (min+max)/2;
			} else if(valor.compareTo(valores[(min+max)/2])<0){
				return binarySearch(valor,valores,min,((min+max)/2)-1);
			} else {
				return binarySearch(valor,valores,((min+max)/2)+1,max);
			}
		}
		else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int[] x= {1,2,3,4,5};
//		System.out.println(binarySearch(5, x));
		String[] palabras= {"Andres","Daniel","Luis"};
		System.out.println(binarySearch("Daniel", palabras));
		Object[] arg =new Object[10];
		for (int i = 0; i < x.length; i++) {
			arg[i]=(Integer) x[i];
		}
		System.out.println(binarySearch(arg[2],arg));
	}

}
