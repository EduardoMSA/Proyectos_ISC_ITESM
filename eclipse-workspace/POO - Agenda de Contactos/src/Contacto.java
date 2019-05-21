/*	Eduardo Méndez Santa Ana A01632947
 * 	Hector Eduardo Martínez Alcántara A01632340
 */

public class Contacto {
	private String nombre;
	private String apellidos;
	private String categoria;
	private String correo;
	private String telefono;
	private String celular;
	private String direccion;
	private String nota;
	
	public Contacto(String nombre, String apellidos, String categoria, String correo, String telefono, String celular, String direccion, String nota) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		this.correo = correo;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.nota = nota;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	public String getCategoria() {
		return this.categoria;
	}
	public String getCorreo() {
		return this.correo;
	}
	public String getTelefono() {
		return this.telefono;
	}
	public String getCelular() {
		return this.celular;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public String getNota() {
		return this.nota;
	}
	
	public String toString() { 
		String x = "";
		if(this.getNombre()!="") {
			x+="Nombre: " + this.getNombre() + "\n";
		}
		if(this.getApellidos()!="") {
			x+= "Apellidos: " + this.getApellidos() + "\n";
		}
		if(this.getCategoria()!="") {
			x+= "Categoria: " + this.getCategoria() + "\n";
		}
		if(this.getCorreo()!="") {
			x+= "Correo: " + this.getCorreo() + "\n";
		}
		if(this.getTelefono()!="") {
			x+="Telefono: " + this.getTelefono() + "\n";
		}
		if(this.getCelular()!="") {
			x+="Celular: " + this.getCelular() + "\n";
		}
		if(this.getDireccion()!="") {
			x+="Direccion: " + this.getDireccion() + "\n";
		}
		if(this.getNota()!="") {
			x+="Nota: " + this.getNota() + "\n";
		}
		return x;
	}
	
	public boolean contiene(String con) {
		if(	this.getNombre().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getApellidos().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getCategoria().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getCorreo().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getTelefono().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getCelular().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getDireccion().toUpperCase().indexOf(con.toUpperCase())>=0||
			this.getNota().toUpperCase().indexOf(con.toUpperCase())>=0) {
			
			return true;
		}
		
		return false;
	}
	
}
