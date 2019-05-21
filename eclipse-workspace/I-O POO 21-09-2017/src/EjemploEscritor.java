import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploEscritor {
	public static void main(String[] args) {
		try {
		//FileWriter fw=new FileWriter("C:\\Users\\eduar\\Desktop\\Ejemplos Escritura\\nuevo.txt");
		//PrintWriter pw=new PrintWriter(fw);
		PrintWriter pw=new PrintWriter(new FileWriter("C:\\Users\\eduar\\Desktop\\Ejemplos Escritura\\nuevo.txt"));
		pw.println("Hola");
		pw.print("¿Qué tal?");
		pw.println(" ¿Qué es eso?");
		pw.println("Se acabó");
		pw.close();
		}
		catch(IOException ex) {
			System.out.println("Error "+ex);
		}
	}
}
