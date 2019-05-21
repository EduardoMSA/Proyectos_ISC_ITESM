
public class EjemploExcepcion {
	public void metodoA() {
		metodoB();
	}
	public void metodoB() {
		metodoC();
	}
	public void metodoC() {
		metodoD();
	}
	public void metodoD () {
		throw new MyException("Ocurrio un error fatal!!!");
	}
	public static void main(String[] args) {
		try {
		EjemploExcepcion a = new EjemploExcepcion();
		a.metodoA();
		}
		catch(MyException ex) {
			System.out.println("Voy a terminar el programa, "+ex.getMessage());
		}
	}
}
