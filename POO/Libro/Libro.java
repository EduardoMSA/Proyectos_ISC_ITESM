/*
-Eduardo Méndez Santa Ana
-A01632947
*/

public class Libro{
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	public Libro(){
		titulo="Pilares de la Tierra";
		autor="Ken Follet";
		editorial="Debolsillo";
		isbn="9788499086514";
	}
	public Libro(String titulo, String autor, String editorial, String isbn){
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public void setAutor(String autor){
		this.autor = autor;
	}
	public void setEditorial(String editorial){
		this.editorial = editorial;
	}
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	public String getTitulo(){
		return titulo;
	}
	public String getAutor(){
		return autor;
	}
	public String getEditorial(){
		return editorial;
	}
	public String getIsbn(){
		return isbn;
	}

	public static void main(String[] args){
	Libro uno=new Libro();
	Libro dos=new Libro();
	Libro tres=new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Literatura Random House", "9788439732471");
	
	
	uno.setTitulo("El Cuervo");
	uno.setAutor("Edgar Allan Poe");
	uno.setEditorial("El Tucán de Virginia");
	uno.setIsbn("9789686756371");
	
	System.out.println("\nLibro 1:\n" + "Titulo: " + uno.getTitulo() + "\nAutor: " + uno.getAutor() + "\nEditorial: " + uno.getEditorial() + "\nISBN: " + uno.getIsbn());
	System.out.println("\nLibro 2:\n" + "Titulo: " + dos.getTitulo() + "\nAutor: " + dos.getAutor() + "\nEditorial: " + dos.getEditorial() + "\nISBN: " + dos.getIsbn());
	System.out.println("\nLibro 3:\n" + "Titulo: " + tres.getTitulo() + "\nAutor: " + tres.getAutor() + "\nEditorial: " + tres.getEditorial() + "\nISBN: " + tres.getIsbn());
	}
}