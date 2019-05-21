/*
-Eduardo M�ndez Santa Ana
-A01632947
*/

import javax.swing.*;

public class Bisiesto{
	public static Boolean consulta(int a�o){
		Boolean esBisiesto;
		if(a�o%4==0){
			if(a�o%100==0){
				if(a�o%400==0){
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
		int a�o = Integer.parseInt(JOptionPane.showInputDialog("Inserta un a�o:"));
		if(consulta(a�o)){
			JOptionPane.showMessageDialog(null, "El a�o " + a�o + " es bisiesto.");
		}
		else{
			JOptionPane.showMessageDialog(null, "El a�o " + a�o + " no bisiesto.");
		}
	}
}