
public class mamalon {
	
	private int mamada;
	
	public mamalon() {
	}

	public int getMamada() {
		return this.mamada;
	}
	
	public void nullpointer() {
		throw new NullPointerException();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mamalon mamada = new mamalon();
		System.out.println(mamada.getMamada());
		mamada.nullpointer();

	}

}
