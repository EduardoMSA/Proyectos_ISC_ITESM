
public class EjemploMetodoGenerico {
	
	public <T>void imprimeArreglo(T[] arreglo) { //Solo trabajan con datos referenciados //El <> es para crear una variable generica
		for(int i=0;i<arreglo.length-1;i++) {
			System.out.print(arreglo[i]+",");
		}
			System.out.println(arreglo.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EjemploMetodoGenerico emg = new EjemploMetodoGenerico();
		Integer[] numeros = {10,15,1,8,9,3,7}; //Integer es equivalente a int
		emg.imprimeArreglo(numeros);
		
		Double[] decimales= {10.1,15.4,1.0,8.9,9.2,3.5,7.6}; //Double es equivalente a double
		
		emg.imprimeArreglo(decimales);
		
		String[] palabras= {"hola","que","tal","como","estas","espero","que","bien","bye"};
		
		emg.imprimeArreglo(palabras);
		

	}

}
