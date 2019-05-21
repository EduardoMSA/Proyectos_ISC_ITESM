import java.io.IOException;

public class generador {
	public static void main(String[] args) {
		System.out.println("Hello");
		for(int i = 0; i<10000000; i++) {
			System.out.print("j");
		}
		System.out.println("Bye");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
