/*
-Eduardo Méndez Santa Ana
-A01632947
*/

import javax.swing.*;

public class Bisiesto{
	public static Boolean consulta(int año){
		Boolean esBisiesto;
		if(año%4==0){
			if(año%100==0){
				if(año%400==0){
					esBisiesto = true;
				}
				else{
					esBisiesto = false;
				}
			}
			else{
				esBisiesto = true;
			}
		}
		else{
			esBisiesto = false;
		}	
		return esBisiesto;
	}

	public static void main(String[] args){
		int año = Integer.parseInt(JOptionPane.showInputDialog("Inserta un año:"));
		if(consulta(año)){
			JOptionPane.showMessageDialog(null, "El año " + año + " es bisiesto.");
		}
		else{
			JOptionPane.showMessageDialog(null, "El año " + año + " no bisiesto.");
		}
	}
}