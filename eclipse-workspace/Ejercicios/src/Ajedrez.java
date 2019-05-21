import javax.swing.JOptionPane;
//Metodo Sebastian
public class Ajedrez {
	
	static boolean ColorTablero(String celda) {
		int fila=(celda.charAt(1));
		int columna=(celda.charAt(0));
		return (columna+fila)%2==0;
	}

	public static void main(String[] args) {
		
		String celda = JOptionPane.showInputDialog("Introduce la celda: ");
		if(ColorTablero(celda)) {
			JOptionPane.showMessageDialog(null, "Es Blanco");
		}
		else {
			JOptionPane.showMessageDialog(null, "Es Negro");
		}
		

	}                        

}
