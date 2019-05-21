/*
-Eduardo Méndez Santa Ana
-A01632947
*/

import javax.swing.*;

public class DesviacionEstandar{
	public static double calculaDesviacion(){
		double suma = 0;
		double sumaCuadrados = 0;
		for(int i=0; i<10; i++){
			double numero = Double.parseDouble(JOptionPane.showInputDialog("Inserta el número " + (i+1) + "/10"));
			suma = suma + numero;
			sumaCuadrados = sumaCuadrados + Math.pow(numero,2);
		}
		double desviacion = Math.sqrt((sumaCuadrados - (Math.pow(suma,2)/10))/9);
		return desviacion;
	}

	public static void main(String[] args){
		JOptionPane.showMessageDialog(null, "La desviación estándar calculada fue: \n" + calculaDesviacion());
	}
}