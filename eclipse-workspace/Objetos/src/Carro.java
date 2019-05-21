
public class Carro {
	private String color;
	private Boolean encendido;
	private int velocidad;
	
	public Carro(String color) {
		this.color = color;
		this.encendido = false;
		this.velocidad = 0;
	}
	
	public void encender() {
		this.encendido=true;
	}
	
	public void acelerar(int velocidad){
		this.velocidad+=velocidad;
	}
	
	public void frenar(int velocidad) {
		this.velocidad-=velocidad;
		if(this.velocidad<0) {
			this.velocidad=0;
		}
	}
	
	public String comprobar() {
		if(this.encendido) {
			return "Tu carro esta encendido y va a " + this.velocidad + "Km/h";
		}
		else {
			return "Tu carro está Apagado";
		}
	}
	
	public int getVel() {
		return this.velocidad;
	}
	
	public void setVel(int velocidad) {
		this.velocidad=velocidad;
	}
	
	public static void main(String[] args) {
		Carro meche = new Carro("plata");
		meche.encender();
		meche.acelerar(50);
		System.out.println(meche.comprobar());
		
	}
	
}
