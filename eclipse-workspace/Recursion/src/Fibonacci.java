
public class Fibonacci {
	public static long fibonacci(int n) {
		if(n==0||n==1){
			return 1;
		}
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	
	
	
	public static long fibonacciTabla(int n, long[] valores) {
		if(valores[n]!=0) {
			return valores[n];
		}
		else {
			valores[n]=fibonacciTabla(n-1,valores)+fibonacciTabla(n-2,valores);
			return valores[n];
		}
	}
	public static long fibonacciTabla(int n) {
		long[] tabla = new long[n+1];
		tabla[0]=tabla[1]=1;
		return fibonacciTabla(n,tabla);
	}
	public static void main(String[] args) {
		System.out.println(fibonacciTabla(50));
	}
	
	
	
}
