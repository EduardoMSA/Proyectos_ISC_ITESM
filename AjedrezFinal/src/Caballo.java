import java.util.ArrayList;

public class Caballo extends Ficha {
	public Caballo(int color) {
		super(color,3);
	}
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles = new ArrayList<Celda>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((Math.abs(celdaorigen.getX() - tablero.getCelda(i, j).getX()) == 1
						&& Math.abs(celdaorigen.getY() - tablero.getCelda(i, j).getY()) == 2
						|| Math.abs(celdaorigen.getY() - tablero.getCelda(i, j).getY()) == 1
								&& Math.abs(celdaorigen.getX() - tablero.getCelda(i, j).getX()) == 2)) {
					if(tablero.getCelda(i, j).tieneFicha()) {
						if(tablero.getCelda(i, j).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
							posibles.add(tablero.getCelda(i, j));
						}
					}
					else {
						posibles.add(tablero.getCelda(i, j));
					}
				}
			}
		}
		return posibles;
	}
}
