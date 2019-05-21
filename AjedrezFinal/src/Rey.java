import java.util.ArrayList;

public class Rey extends Ficha {
	public Rey(int color) {
		super(color, 0);
	}

	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero) {
		ArrayList<Celda> posibles = new ArrayList<Celda>();
		
		if((celdaorigen.getX()+1)>=0&&(celdaorigen.getX()+1)<8) {
			if (tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY()).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY()).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY()));
				}
			} else {
				posibles.add(tablero.getCelda(celdaorigen.getX() + 1, celdaorigen.getY()));
			}
		}
		if((celdaorigen.getX()-1)>=0&&(celdaorigen.getX()-1)<8) {
			if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()));
			}
		}
		if((celdaorigen.getY()+1)>=0&&(celdaorigen.getY()+1)<8) {
			if(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()+1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()+1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()+1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()+1));
			}
		}
		if((celdaorigen.getY()-1)>=0&&(celdaorigen.getY()-1)<8) {
			if(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()-1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()-1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()-1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX(), celdaorigen.getY()-1));
			}
		}
		
		if((celdaorigen.getX()+1)>=0&&(celdaorigen.getX()+1)<8&&(celdaorigen.getY()+1)>=0&&(celdaorigen.getY()+1)<8) {
			if(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()+1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()+1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()+1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()+1));
			}
		}
		if((celdaorigen.getX()+1)>=0&&(celdaorigen.getX()+1)<8&&(celdaorigen.getY()-1)>=0&&(celdaorigen.getY()-1)<8) {
			if(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()-1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()-1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()-1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX()+1, celdaorigen.getY()-1));
			}
		}
		if((celdaorigen.getX()-1)>=0&&(celdaorigen.getX()-1)<8&&(celdaorigen.getY()+1)>=0&&(celdaorigen.getY()+1)<8) {
			if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()+1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()+1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()+1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()+1));
			}
		}
		if((celdaorigen.getX()-1)>=0&&(celdaorigen.getX()-1)<8&&(celdaorigen.getY()-1)>=0&&(celdaorigen.getY()-1)<8) {
			if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()-1).tieneFicha()) {
				if(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()-1).getFicha().getColor()!=celdaorigen.getFicha().getColor()) {
					posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()-1));
				}
			}
			else {
				posibles.add(tablero.getCelda(celdaorigen.getX()-1, celdaorigen.getY()-1));
			}
		}
		
		return posibles;
	}
}
