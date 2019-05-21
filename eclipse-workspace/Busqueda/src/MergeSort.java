/*
 * Eduardo Méndez Santa Ana A0632947
 * MergeSort
 * 28/01/2018
 */
public class MergeSort {

	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length-1);
	}
	public static <E extends Comparable<E>> void mergesort(E[] datos, int primero, int ultimo) {
		if(primero<ultimo) {
			int medio=(primero+ultimo)/2;
			mergesort(datos, primero, medio);
			mergesort(datos, medio+1, ultimo);
			mezcla(datos, primero, ultimo);
			//DoMerge(datos, primero, medio, ultimo);
		}
		
	}	
	public static <E extends Comparable<E>> void mezcla(E[] datos, int primero, int ultimo) {
		
		E[] datosAux = (E[]) new Comparable[datos.length];
		
		for(int i=primero;i<=ultimo;i++) {
			datosAux[i]=datos[i];
		}
		int medio = (primero+ultimo)/2;
		int indiceUno = primero;
		int indiceDos = medio+1;
		int indiceAux = primero;
		
		while(indiceUno<=medio&&indiceDos<=ultimo) {
			if(datos[indiceUno].compareTo(datos[indiceDos])<=0) {
				datos[indiceAux]=datosAux[indiceUno];
				indiceUno++;
			} else {
				datos[indiceAux]=datosAux[indiceDos];
				indiceDos++;
			}
			indiceAux++;
		}
		while(indiceUno<=medio) {
			datos[indiceAux]=datosAux[indiceUno];
			indiceUno++;
			indiceAux++;
		}
		
	}
	
	
	public static void main(String[] args) {
		Integer[] nombres = {5,3,4,7,8,5,2,1,4};
		mergesort(nombres);
		for(Integer nombre:nombres) {
			System.out.print(nombre + " ");
		}
		System.out.println();
		
	}
}
