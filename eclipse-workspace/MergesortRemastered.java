// no puedo tener un atributo generico de clase

public class MergesortRemastered {
	
	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length-1);
	}
	
	private static <E extends Comparable<E>> void mergesort(E[] datos, int min, int max) {
		if(min<max) {
			int centro = (min+max) / 2;
			mergesort(datos,min,centro);
			mergesort(datos, centro+1,max);
			merge(datos,min,max);
		}
	}
	
	private static <E extends Comparable<E>> void merge(E[] datos, int min, int max) {
		E[] temp = (E[])new Comparable[max-min+1];
		int centro = (min+max) / 2;
		int x = 0;
		int y = 0;
		int z = 0;

		System.out.println("z: "+z);
		System.out.println("min: "+min);
        while (x < centro-min+1 && y < max-centro) { 
            if (datos[x].compareTo(datos[centro+1+y])<=0) { 
                temp[z] = datos[x]; 
                x++; 
            } 
            else{ 
                temp[z] = datos[centro+1+y]; 
                y++; 
            } 
            z++; 
        } 
  
        while (x < centro-min+1) { 
            temp[z] = datos[x]; 
            x++; 
            z++; 
        } 
 
        while (y < max-centro) { 
            temp[z] = datos[y+1+centro]; 
            y++; 
            z++; 
        }
        
        for(int i=0; i<temp.length; i++) {
        	datos[i] = temp[i];
        }
        
	}
	public static <E> void imprimeArreglo(E[] arreglo) {
		for(int i=0; i<arreglo.length; i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] palabras= {"A","D","C","E","B","Z"};
		imprimeArreglo(palabras);
		System.out.println();
		
		mergesort(palabras);
		imprimeArreglo(palabras);
	}
}
