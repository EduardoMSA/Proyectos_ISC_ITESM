
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {
		Fichas[][] tablero = new Fichas[7][7];
		Fichas vacio = new Fichas("Vacio");
		Fichas red = new Fichas("  Red");
		Fichas blue = new Fichas(" Blue");
		int row = 0, fila = 0;
		public void setTablero() {
			tablero[3][4] = new Fichas("3,4");
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					tablero[i][j] = vacio;
				}
			}
		}
		public void addFicha() {
			int contador = 1;
			boolean change = false, game = true;
			Fichas turno;
			while (game == true) {
				if(contador % 2 == 0) {
					turno = red;
				} else {
					turno = blue;
				}
				System.out.println("");
				System.out.println("Es turno de " + turno.getColor());
				System.out.print("Bienvenido a Conecta 4, escoje una columna para poner tu Ficha: ");
				Scanner sc = new Scanner(System.in);
				
				try {
					row = sc.nextInt() - 1;
				} catch (InputMismatchException e) {
					System.out.println("Por favor selecciona un numero de columna valido");
					row = 8;
				} catch (NullPointerException e) {
					StringBuilder ab = new StringBuilder(e.getMessage());
					ab.delete(0, 17);
					System.out.println("El valor introducido " + ab + " no es valido");
				}
				if (row > 6 || row < 0) {
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("Por favor selecciona un numero de columna valido");
					showTablero();
				} else {
				
					for (int j = 6; j >= 0; j--) {
							if(tablero[j][row].getColor().equals(vacio.getColor())) {
								tablero[j][row] = turno;
								fila = j;
								j = -1;
								change = true;
							}
					}
	//				Fichas jugada = new Fichas(input);
		//			tablero[3][4] = new Fichas("4,5    ");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					showTablero();
					
					playWin(turno);
					checkFull();
					contador++;
				}
			}
		}
		public void showTablero(){
			System.out.println("  1      2      3      4      5      6      7");
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j].getColor() + ", ");
				}
				System.out.println("");
			}
		}
		public void playWin(Fichas next) {
			int streak = 0;
//			any win
//			vertical
			for (int i = fila; i < tablero.length; i++) {
				if(tablero[i][row].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
//			Horizontal
			for (int i = 0; i < tablero.length; i++) {
				if(tablero[fila][i].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
//			Diagonal hacia abajo derecha
			for (int i = fila, j = row; i < tablero.length && j < tablero.length; i++, j++) {
				if(tablero[i][j].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
//			Diagonal hacia arriba derecha
			for (int i = fila, j = row; i >= 0 && j < tablero.length; i--, j++) {
				if(tablero[i][j].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
//			Diagonal hacia abajo izquierda
			for (int i = fila, j = row; i < tablero.length && j >= 0; i++, j--) {
				if(tablero[i][j].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
//			Diagonal hacia arriba izquierda
			for (int i = fila, j = row; i >= 0 && j >= 0; i--, j--) {
				if(tablero[i][j].getColor().equals(next.getColor())) {
					streak++;
				} else { streak = 0; }
				if(streak == 4) {
					System.out.println("Gano " + next.getColor());
					System.exit(0);
				}		
			}
			streak = 0;
		}
		public void checkFull() {
			boolean full = true;
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero.length; j++) {
					if(tablero[i][j].getColor().equals(vacio.getColor())) {
						full = false;
					}
				}
			}
			if (full == true) {
				System.out.println("El juego ha terminado en empate");
				System.exit(0);
			}
		}
		public Tablero() {
		}
//	Los turnos se manejan a la hora de introducir la siguiente ficha por el metodo columna, habr� un contador
//	que dictara el color de la ficha que sera puesta, ej; contador en num par: color "blue" y en impares color "red"
	
	
}
