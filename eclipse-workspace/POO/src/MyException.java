
public class MyException extends RuntimeException {
	public MyException() {
		super("Error de MyException");
	}
	public MyException(String msj) {
		super(msj);
	}
}
