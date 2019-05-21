import java.util.ArrayList;

public class Torre extends Ficha{
	public Torre(int color) {
		super(color,4);
		
	}
	public ArrayList<Celda> movible(Celda celdaorigen, Tablero tablero){
		ArrayList<Celda> posibles=new ArrayList<Celda>();
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
		return posibles;
	}
}
