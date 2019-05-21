import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;
public class AlterantingSum {
	static Scanner scan = new Scanner(System.in);
	static int aSum(int n, int a, int b,int k) throws IOException {
		int sum=0;
		int[] kValues = new int[k];
		String kIn = scan.nextLine();
		for(int i = 0; i < kValues.length; i++) {
			/*if(kIn.charAt(i%kIn.length())!='+'&&kIn.charAt(i%kIn.length())!='-') {
				throw new IOException("Se ingresaron operadores no válidos");
			}*/
			kValues[i] = (kIn.charAt(i%kIn.length())=='+')?1:-1;
		}
		for(int i =0; i<=n; i++) {
			sum+= kValues[i%k]*Math.pow(a, n-i)*Math.pow(b, i);
		}
		if(sum%Math.pow(10, 9)+9<0) {
			sum+=Math.pow(10, 9)+9;
		}else {
			sum = (int) (sum%Math.pow(10, 9)+9);
		}
		
		return sum;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String num = scan.nextLine();
		try {
			/*if(num.length()!=4 || !Character.isDigit(num.charAt(0)) || !Character.isDigit(num.charAt(1)) || !Character.isDigit(num.charAt(2)) || !Character.isDigit(num.charAt(3))) {
				throw new IOException();
			}*/
			
			//System.out.println(aSum(Character.getNumericValue(num.charAt(0)),Character.getNumericValue(num.charAt(1)),Character.getNumericValue(num.charAt(2)),Character.getNumericValue(num.charAt(3))));
			
			System.out.print("N");
			int n = scan.nextInt();
			System.out.print("A");
			int a = scan.nextInt();
			System.out.print("B");
			int b = scan.nextInt();
			System.out.print("K");
			int k = scan.nextInt();
			System.out.println(aSum(n,a,b,k));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
