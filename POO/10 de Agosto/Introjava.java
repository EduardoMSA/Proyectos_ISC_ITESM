import javax.swing.*;

public class Introjava{
	public static void calificacion(){
		String sNota=JOptionPane.showInputDialog("Dime una nota");
		int nota=Integer.parseInt(sNota);
		if(nota>=70){
			System.out.println("Aprobado");
		} 
		else {
			System.out.println("Reprobado");
		}
	}
	public static void main(String[] args){
		calificacion();
	}
}