/*Eduardo Méndez A01632947
 * Potencias
 * 11/01/17
 */


import javax.swing.JOptionPane;

public class Potencias {
	public static double potencia(int base, int exponente) {
		if(exponente==0) {
			return 1;
		}
		else if(exponente>0) {
			return base*potencia(base, exponente-1);
		}
		else {
			return (1/(double)base)*potencia(base,exponente+1);
		}
	}
	
	public static void main(String[] args) {
		int base,
			exponente,
			continuar;
		while(true) {
			try {
				base=Integer.parseInt(JOptionPane.showInputDialog("Inserta el numero base"));
				exponente=Integer.parseInt(JOptionPane.showInputDialog("Inserta el exponente"));
				JOptionPane.showMessageDialog(null, "El resultado es: " + potencia(base, exponente));
				continuar = JOptionPane.showConfirmDialog(null, "¿Desea calcular otra potencia?","Potencias",JOptionPane.YES_NO_OPTION);
				if(continuar== JOptionPane.NO_OPTION) {
					break;
				}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ingresa únicamente numeros enteros");
			}
		}
	}
	
	
	
}
