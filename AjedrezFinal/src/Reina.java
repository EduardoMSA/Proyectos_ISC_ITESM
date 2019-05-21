import java.util.ArrayList;

public class Reina extends Ficha {
	public Reina(int color) {
		super(color,1);
	}
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles = new ArrayList<Celda>();
		for(int i=celdaorigen.getY()+1;i<8;i++) {
			if(tablero.getCelda(celdaorigen.getX(), i).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX(), i).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), i));
				}
				break;
			}
			posibles.add(tablero.getCelda(celdaorigen.getX(), i));
		}
		for(int i=celdaorigen.getY()-1;i>=0;i--) {
			if(tablero.getCelda(celdaorigen.getX(), i).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX(), i).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), i));
				}
				break;
			}
			posibles.add(tablero.getCelda(celdaorigen.getX(), i));
		}
		for(int i=celdaorigen.getX()+1;i<8;i++) {
			if(tablero.getCelda(i, celdaorigen.getY()).tieneFicha()) {
				if(tablero.getCelda(i, celdaorigen.getY()).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(i, celdaorigen.getY()));
				}
				break;
			}
			posibles.add(tablero.getCelda(i, celdaorigen.getY()));
		}
		for(int i=celdaorigen.getX()-1;i>=0;i--) {
			if(tablero.getCelda(i, celdaorigen.getY()).tieneFicha()) {
				if(tablero.getCelda(i, celdaorigen.getY()).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(i, celdaorigen.getY()));
				}
				break;
			}
			posibles.add(tablero.getCelda(i, celdaorigen.getY()));
		}
		int destinox = celdaorigen.getX() + 1, destinoy = celdaorigen.getY() + 1;
		while (destinox < 8 && destinox >= 0 && destinoy < 8 && destinoy >= 0) {
			if (tablero.getCelda(destinox, destinoy).tieneFicha()) {
				if (tablero.getCelda(destinox, destinoy).getFicha().getColor() != celdaorigen.getFicha().getColor()) {
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
				if (tablero.getCelda(destinox, destinoy).getFicha().getColor() != celdaorigen.getFicha().getColor()) {
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
				if (tablero.getCelda(destinox, destinoy).getFicha().getColor() != celdaorigen.getFicha().getColor()) {
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
				if (tablero.getCelda(destinox, destinoy).getFicha().getColor() != celdaorigen.getFicha().getColor()) {
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
