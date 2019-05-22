//Autor: Luis Antonio García Miramontes; A01540063
//Clase: Mergesort
//Fecha: 2 de febrero de 2019
//Comentarios u observaciones: No puedo tener un atributo generico de clase

public class Mergesort {
	
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
		int centro = (min+max) / 2;
		int mitad1 = centro - min + 1; 
        int mitad2 = max - centro; 
    
        E[] izq = (E[])new Comparable[mitad1];
		E[] der = (E[])new Comparable[mitad2];
  
        for (int i=0; i<mitad1; ++i) 
            izq[i] = datos[min + i]; 
        for (int j=0; j<mitad2; ++j) 
            der[j] = datos[centro + 1+ j]; 
  
        int i = 0, j = 0; 
        int pos = min;

        while (i < mitad1 && j < mitad2) 
        { 
            if (izq[i].compareTo(der[j])<=0) 
            { 
                datos[pos] = izq[i]; 
                i++; 
            } 
            else
            { 
                datos[pos] = der[j]; 
                j++; 
            } 
            pos++; 
        } 
  
        while (i < mitad1) 
        { 
            datos[pos] = izq[i]; 
            i++; 
            pos++; 
        } 
  
        while (j < mitad2) 
        { 
            datos[pos] = der[j]; 
            j++; 
            pos++; 
        }
	}
	
	public static <E> void imprimeArreglo(E[] arreglo) {
		for(int i=0; i<arreglo.length; i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] palabras= {"A","D","C","E","B","Z","J","K"};
		imprimeArreglo(palabras);
		System.out.println();
		
		mergesort(palabras);
		imprimeArreglo(palabras);
	}
	
}
