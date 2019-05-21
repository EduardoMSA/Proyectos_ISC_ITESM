import java.util.ArrayList;
import java.util.Iterator;

public class Alfil extends Ficha {
	public Alfil(int color) {
		super(color,2);
	}
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles = new ArrayList<Celda>();
		
		int destinox = celdaorigen.getX() + 1, destinoy = celdaorigen.getY() + 1;
		while (destinox < 8 && destinox >= 0 && destinoy < 8 && destinoy >= 0) {
			if (tablero.getCelda(destinox, destinoy).tieneFicha()) {
				if(tablero.getCelda(destinox, destinoy).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(destinox, destinoy));
				}
				break;
			}
			posibles.add(tablero.getCelda(destinox, destinoy));
			destinox++;
			destinoy++;
		}
		destinox = celdaorigen.getX() + 1;
		destinoy = celdaorigen.getY() - 1;
		while (destinox < 8 && destinox >= 0 && destinoy < 8 && destinoy >= 0) {
			if (tablero.getCelda(destinox, destinoy).tieneFicha()) {
				if(tablero.getCelda(destinox, destinoy).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(destinox, destinoy));
				}
				break;
			}
			posibles.add(tablero.getCelda(destinox, destinoy));
			destinox++;
			destinoy--;
		}
		destinox = celdaorigen.getX() - 1;
		destinoy = celdaorigen.getY() + 1;
		while (destinox < 8 && destinox >= 0 && destinoy < 8 && destinoy >= 0) {
			if (tablero.getCelda(destinox, destinoy).tieneFicha()) {
				if(tablero.getCelda(destinox, destinoy).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(destinox, destinoy));
				}
				break;
			}
			posibles.add(tablero.getCelda(destinox, destinoy));
			destinox--;
			destinoy++;
		}
		destinox = celdaorigen.getX() - 1;
		destinoy = celdaorigen.getY() - 1;
		while (destinox < 8 && destinox >= 0 && destinoy < 8 && destinoy >= 0) {
			if (tablero.getCelda(destinox, destinoy).tieneFicha()) {
				if(tablero.getCelda(destinox, destinoy).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(destinox, destinoy));
				}
				break;
			}
			posibles.add(tablero.getCelda(destinox, destinoy));
			destinox--;
			destinoy--;
		}
		
		return posibles;
	}
}
