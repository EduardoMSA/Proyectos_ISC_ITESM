import java.io.*;
import javax.swing.JOptionPane;

public class CopyFile {
	
	public void copy(String archivobase, String archivocopia) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivobase));
		PrintWriter pw = new PrintWriter(new FileWriter(archivocopia));
		String linea = br.readLine();
		while(linea!=null) {
			pw.println(linea);
			linea = br.readLine();
		}
		pw.close();
		br.close();
	}
	
	public static void main(String[] args) {
		try {
			CopyFile cf = new CopyFile();
			String archivobase = JOptionPane.showInputDialog("Escribe la direccion del archivo que desees copiar: ");
			String archivocopia = JOptionPane.showInputDialog("Escribe la direccion del archivo a donde desees pegar lo copiado: ");
			cf.copy(archivobase, archivocopia);
		}
		catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Error I/O: " + ex);
		}
	}
}
