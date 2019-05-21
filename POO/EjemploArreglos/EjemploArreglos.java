/*
-Eduardo Méndez Santa Ana
-A01632947
*/

public class EjemploArreglos{
	/*
	public EjemploArreglos(){
	}
	public int suma(int[] valores){
		int suma=0;
		for(int i=0;i<valores.length;i++){
			suma+=valores[i];
		}
		return suma;
	}
	public int maximo(int[] valores){
		int max=valores[0];
		for(int i=0;i<valores.length;i++){
			if(max<valores[i]){
				max=valores[i];
			}
		}
		return max;
		
	}
	public int minimo(int[] valores){
		int min=valores[0];
		for(int i=0;i<valores.length;i++){
			if(min>valores[i]){
				min=valores[i];
			}		
		}
	}
	public double promedio(int[] valores){
		
		
	}		
	*/

	public static void main(String[] args){
	// int indice = 2;
	String[][] arreglo = new String[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
	for(int i=0; i<arreglo.length; i++){
		for(int j=0; j<arreglo[i].length; j++){
			System.out.print((arreglo[i][j] = "x") + " ");
			//indice ++;
		}
		System.out.println();
	}
	}
}