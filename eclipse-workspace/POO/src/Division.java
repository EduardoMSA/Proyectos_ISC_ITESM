/* Eduardo Méndez Santa Ana
 * A01632947
 */

import javax.swing.JOptionPane;

public class Division {
	public int division(int num, int den) {
		return num/den;
	}
	public int Den() throws ArithmeticException {
		int den = Integer.parseInt(JOptionPane.showInputDialog("Introduce el denominador"));
		return den;
		
	}
	public int Num() {
		return Integer.parseInt(JOptionPane.showInputDialog("Introduce el numerador"));
	}
	public static void main(String[] args) {
		int num,
			den;
		Division div=new Division();
		boolean repetir = true;
		while(repetir) {
			try {
				num= div.Num();
				den= div.Den();
				JOptionPane.showMessageDialog(null, "El resultado de dividir " +num+"/"+den+" es "+div.division(num, den));
				repetir=false; // Esta linea no se ejecuta si existe una excepción
			}
			catch(ArithmeticException ex) {
				JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingresa únicamente enteros");
				
			}
		}
	}
}
