public class PruebaArreglos{
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

	public static void main(String[] args){
		PruebaArreglos ea=new PruebaArreglos();
		int[] arreglo1={7,8,9};
		System.out.println(ea.suma(arreglo1));
		int[] arreglo2={-2,-8,-15,-16,-23};
		System.out.println(ea.maximo(arreglo2));
	
	}

}