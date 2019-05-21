import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CalculaNomina {
	public static void main(String[] args) {
		try {
			StringTokenizer st;
			BufferedReader bf = new BufferedReader(new FileReader("horasTrabajadas.txt"));
			PrintWriter pw=new PrintWriter(new FileWriter("nominaSemanal.csv"));
			String 	linea,
					nombre,
					apellido;
			int hrs;
			double tabulador;
			bf.readLine();
			pw.println("Nombre completo, Pago");
			while((linea=bf.readLine())!=null) {
				st=new StringTokenizer(linea);
				nombre=st.nextToken();
				apellido=st.nextToken();
				hrs=Integer.parseInt(st.nextToken());
				tabulador=Double.parseDouble(st.nextToken());
				pw.println(nombre+" "+apellido+","+hrs*tabulador);
			}
			bf.close();
			pw.close();
		}
		catch(FileNotFoundException ex){
			System.out.println(ex);
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
}
