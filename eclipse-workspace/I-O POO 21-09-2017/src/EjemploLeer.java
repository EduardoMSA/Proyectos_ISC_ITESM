import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLeer {
	public static void main(String[] args) {
		try {
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\eduar\\Desktop\\Ejemplos Escritura\\nuevo.txt"));
		String linea=br.readLine();//Lee la primera linea.
		System.out.println(linea);
		br.readLine(); //Lee la segunda linea y, al no tener donde guardarla, se la salta.
		linea=br.readLine();//Lee la tercera linea.
		System.out.println(linea);
		br.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("No se encontró el archivo: " + ex);
		}
		catch(IOException ex) {
			System.out.println("Error I/O: " + ex);
		}
			
	}
}
