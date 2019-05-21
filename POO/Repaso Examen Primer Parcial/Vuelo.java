import java.util.*;
class Vuelo{
	static Scanner scan = new Scanner(System.in);
	private Pasajero[] asientos;

	public Vuelo(){
		this.asientos=new Pasajero[20];	
	}

	public boolean asignarAsiento(boolean clase, Pasajero pasajero){
		int x=(clase)?0:10;
		for(int i=0;i<10;i++){
			if(this.asientos[i+x]==null){
				this.asientos[i+x]=pasajero;
				return true;
			}
		}
		return false;
	}

	public boolean comprar(int asiento, double cantidad){
		if(this.asientos[asiento]!=null){
			return this.asientos[asiento].comprar(cantidad);
		}
		else{
			System.out.println("Asiento Vacio /n");
			return false;
		}
	}
	
	public void imprimirListado(){
		for(int i=0;i<this.asientos.length;i++){
			String clase=(i<10)?"Primera Clase":"Económica";
			System.out.println((i+1)+ ") " + this.asientos[i] + ", " + clase);
		}
	}
	
	public Pasajero generaPasajero(){
		String nombre;
		int edad;
		String sgenero;
		double saldo;
		boolean genero;
		
		System.out.println("Ingresa tu nombre: ");
		nombre = scan.nextLine();
		System.out.println("Ingresa tu edad: ");
		edad = scan.nextInt();
		System.out.println("Ingresa tu genero (masculino/femenino): ");
		sgenero = scan.nextLine();
		genero=((sgenero.toUpperCase()).equals("MASCULINO"))?true:false;
		System.out.println("Ingresa tu saldo: ");
		saldo = scan.nextDouble();
		
		return new Pasajero(nombre,edad,genero,saldo);

	}
	
	public static void main(String[] args){
		int opcion = 0;
		while(opcion!=9){
			System.out.println("Bienvenido al Sistema para Manejo de Vuelos \n" +
				   	   "Elija la opcion deseada \n" +
				   	   "1) Comprar boleto primera clase \n" +
				  	   "2) Comprar boleto económico \n" +
				  	   "3) Imprimir Listado \n" +
				  	   "4) Realizar Compra \n" +
				  	   "9) Salir \n");
			opcion = scan.nextInt();
			System.out.println();
			switch(opcion){
				case 1:	



		}



	}



	
}