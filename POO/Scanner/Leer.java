import java.util.Scanner;

public class Leer {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cúal es tu nombre?");
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre);
		
	}
}