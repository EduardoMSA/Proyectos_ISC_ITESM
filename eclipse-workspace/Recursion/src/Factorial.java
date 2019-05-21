
public class Factorial {
	
	public long factorial(int numero) {
		if(numero<=0) {
			return 1;
		}
		else {
			return numero*factorial(numero-1);
		}
	}
	
	public static void main(String[] args) {
		Factorial n = new Factorial();
		System.out.println(n.factorial(5));
	}

}
