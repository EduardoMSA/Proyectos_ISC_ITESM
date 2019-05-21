import javax.swing.JOptionPane;

/*	Eduardo Méndez Santa Ana A01632947
 * 	Hector Eduardo Martínez Alcántara A01632340
 */

public class Principal {
	static void imprimeMenu() {
		JOptionPane.showMessageDialog(null,	  "1) Agregar Contacto \n"
							+ "2) Buscar Contacto \n"
							+ "3) Borrar Contacto \n"
							+ "4) Salir");
	}
	
	static Contacto pideContacto() {
		String 	nombre,
				apellidos, 
				categoria, 
				correo, 
				telefono, 
				celular, 
				direccion, 
				nota;
		
		nombre = JOptionPane.showInputDialog("Introduce el Nombre");
		
		apellidos = JOptionPane.showInputDialog("Introduce los Apellidos");
		
		categoria = JOptionPane.showInputDialog("Introduce la Categoria");
		
		correo = JOptionPane.showInputDialog("Introduce el Correo");
		
		telefono = JOptionPane.showInputDialog("Introduce el Telefono");
		
		celular = JOptionPane.showInputDialog("Introduce el Celular");
		
		direccion = JOptionPane.showInputDialog("Introduce la Direccion");
		
		nota = JOptionPane.showInputDialog("Introduce una nota");
		
		return new Contacto(nombre, apellidos, categoria, correo, telefono, celular, direccion, nota);
	}

	public static void main(String[] args) {
		boolean continuar = true;
		int opcion;
		Agenda agenda = new Agenda();
		
		while(continuar) {
			imprimeMenu();
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Selecciona la opcion deseada"));
			switch (opcion) {
			case 1:
				agenda.agregarContacto(pideContacto());
				break;
				
			case 2:
				String busqueda;
				busqueda = JOptionPane.showInputDialog("Inserta la palabra a buscar");
				agenda.buscarContacto(busqueda);
				break;
				
			case 3:
				int contacto;
				contacto = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número del contacto que desees borrar"));
				if(agenda.borrarContacto(contacto)) {
					JOptionPane.showMessageDialog(null, "El contacto se ha eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "No se ha encontrado el contacto a borrar");
				}
				break;
				
			case 4:
				
				continuar=false;
				break;

			default:
				break;
			}
		}

	}

}

