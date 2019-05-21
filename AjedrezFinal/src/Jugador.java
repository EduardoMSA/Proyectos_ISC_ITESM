
public class Jugador {
	private boolean tieneRey;
	public Jugador() {
		this.reiniciarJugador();
	}
	public void reiniciarJugador() {
		this.tieneRey=true;
	}
	
	public boolean getTieneRey() {
		return this.tieneRey;
	}	
	
	public void setTieneRey(boolean tieneRey) {
		this.tieneRey=tieneRey;
	}
}
