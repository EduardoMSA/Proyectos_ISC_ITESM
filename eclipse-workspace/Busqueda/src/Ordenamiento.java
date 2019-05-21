import java.net.DatagramPacket;

public class Ordenamiento {
	
	public static void bubbleSort(int[] valores) {
		for(int i=0; i<valores.length;i++) {
			for(int j=0; j<valores.length-1-i;j++) {
				if(valores[j]>valores[j+1]) {
					swap(valores, j, j+1);
				}
			}
		}
	}
	
	private static void swap(int[] valores, int i, int j) {
		int tmp = valores[i];
		valores[i] = valores[j];
		valores[j] = tmp;
	}
	
	public static void imprimir(int[] valores) {
		for(int i = 0; i<valores.length-1;i++) {
			System.out.print(valores[i] + ", ");
		}
		System.out.print(valores[valores.length-1]);
	}
	
	public static void main(String[] args) {
		int[] arreglo = {2,1};
		imprimir(arreglo);
		System.out.println();
		mergesort(arreglo);
		imprimir(arreglo);
	}
	
	public static void mergesort(int[] datos) {
		mergesort(datos, 0, datos.length-1);
	}
	public static void mergesort(int[] datos, int primero, int ultimo) {
		if(primero<ultimo) {
			int medio=(primero+ultimo)/2;
			mergesort(datos, primero, medio);
			mergesort(datos, medio+1, ultimo);
			mezcla(datos, primero, ultimo);
			//DoMerge(datos, primero, medio, ultimo);
		}
		
	}	
	public static void mezcla(int[] datos, int primero, int ultimo) {
		int[] datosAux = new int[datos.length];
		for(int i=primero;i<=ultimo;i++) {
			datosAux[i]=datos[i];
		}
		int medio = (primero+ultimo)/2;
		int indiceUno = primero;
		int indiceDos = medio+1;
		int indiceAux = primero;
		
		while(indiceUno<=medio&&indiceDos<=ultimo) {
			if(datos[indiceUno]<=datos[indiceDos]) {
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
}

