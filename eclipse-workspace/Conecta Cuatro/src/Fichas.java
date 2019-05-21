
public class Fichas {
//	Atributos
	private String color;
	private int columna;
//	M�todos de Acceso
	public String getColor() {
		return color;
	}
	public String setColor(String color) {
		this.color = color;
		return color;
	}
	public int getColumna() {
		return columna;
	}
	public int setColumna(int columna) {
		this.columna = columna;
		return columna;
	}
//	Constructores
	public Fichas(String color) {
		setColor(color);
	}
	
	
}
