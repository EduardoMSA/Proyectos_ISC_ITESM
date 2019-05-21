
public class Hanoi {
	static int i = 1;
	
	public static void resolver(int n, int origen, int auxiliar, int destino) {
		if(n == 1) {
			System.out.println(i + " - Mueve de torre " + origen + " a torre " + destino);
			i++;
		} else {
			resolver(n-1, origen, destino, auxiliar);
			System.out.println(i + " - Mueve de torre " + origen + " a torre " + destino);
			i++;
			resolver(n-1, auxiliar, origen, destino);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		resolver(3, 1, 2, 3);
	}

}
