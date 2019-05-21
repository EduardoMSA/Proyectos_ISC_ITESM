import java.awt.Dimension;

import javax.swing.*;

/*	Eduardo Méndez Santa Ana A01632947
 * 	Hector Eduardo Martínez Alcántara A01632340
 */

public class Agenda {
	
	private Contacto[] contactos;
	private int numContactos;
	
	public Agenda(){
		this.contactos = new Contacto[10];
		this.numContactos = 0;
	}
	
	public Agenda(int num) {
		this.contactos = new Contacto[num];
		this.numContactos = 0;
	}
	
	public void agregarContacto(Contacto contacto) {
		
		
		if(this.numContactos==this.contactos.length-1) {
			Contacto[] tmp = new Contacto[contactos.length+10];
			for(int i=0;i<contactos.length;i++) {
				tmp[i]=contactos[i];
			}
			contactos=tmp;
		}
		
		for(int i=0; i<this.contactos.length; i++) {
			if(contactos[i]==null) {
				contactos[i]=contacto;
				break;
			}
			if(contacto.getApellidos().compareToIgnoreCase(contactos[i].getApellidos())<0) {
				for(int j = this.numContactos; j>=i; j--) {
					contactos[j+1]=contactos[j];
				}
				contactos[i]=contacto;
				break;
			}
			if(contacto.getApellidos().compareToIgnoreCase(contactos[i].getApellidos())==0) {
				if(contacto.getNombre().compareToIgnoreCase(contactos[i].getNombre())<0) {
					for(int j = this.numContactos; j>=i; j--) {
						contactos[j+1]=contactos[j];
					}
					contactos[i]=contacto;
					break;
				}
			}
			
		}
		this.numContactos+=1;
	}
	
	public boolean borrarContacto(int contacto) {
		if(contacto<=this.numContactos) {
			for(int i = contacto-1; i<this.contactos.length;i++) {
				if(this.contactos[i]!=null) {
					this.contactos[i]=this.contactos[i+1];
				}
			}
			this.numContactos-=1;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void buscarContacto(String palabra) {
		String acumulador = "";
		for(int i = 0; i<this.numContactos; i++) {
			boolean condicion = this.contactos[i].contiene(palabra);
			if(condicion) {
				acumulador+=i+1 + "\n" + this.contactos[i] + "\n";
			}
		}
		JTextArea textArea = new JTextArea(acumulador);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Busqueda",  
		                                       JOptionPane.NO_OPTION);
	}
	
	

}
