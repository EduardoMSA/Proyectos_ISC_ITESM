import java.util.ArrayList;

public class Peon extends Ficha{
	public Peon(int color) {
		super(color,5);
	}
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles =new ArrayList<Celda>();
		if (this.color == "CLARO") {
			try {
				if (!tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() - 1).tieneFicha()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() - 1));
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			try {
				if (tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() - 1).tieneFicha()) {
					if (tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() - 1).getFicha()
							.getColor() != "CLARO") {
						posibles.add(tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() - 1));
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			try {
				if (tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() - 1).tieneFicha()) {
					if (tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() - 1).getFicha()
							.getColor() != "CLARO") {
						posibles.add(tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() - 1));
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			
			if (celdaorigen.getY() == 6 && !tablero.getCelda(celdaorigen.getX(), 5).tieneFicha()) {
				posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() - 2));
			}
		} else if (this.color == "OSCURO") {
			try {
				if (!tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() + 1).tieneFicha()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() + 1));
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			try {
				if (tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() + 1).tieneFicha()) {
					if (tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() + 1).getFicha()
							.getColor() != "OSCURO") {
						posibles.add(tablero.getCelda(celdaorigen.getX() - 1, celdaorigen.getY() + 1));
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			try {
				if (tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() + 1).tieneFicha()) {
					if (tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() + 1).getFicha()
							.getColor() != "OSCURO") {
						posibles.add(tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY() + 1));
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {

			}
			
			if (celdaorigen.getY() == 1 && !tablero.getCelda(celdaorigen.getX(), 2).tieneFicha()) {
				posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY() + 2));
			}
		}
		return posibles;
	}
}
