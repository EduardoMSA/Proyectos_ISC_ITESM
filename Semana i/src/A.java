import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	final int MOD = 1000000007;
	int[][] com = new int[1001][1001];

	void run() {
		int k = sc.nextInt();
		int[] c = new int[k];
		for (int i = 0; i < k; i++) c[i] = sc.nextInt();
		pascal();
		long res = 1;
		int sukima = c[0];
		for (int i = 1; i < k; i++) {
			res = (res * com[sukima + c[i] - 1][c[i] - 1]) % MOD;
			sukima += c[i];
		}
		System.out.println(res);
	}

	void pascal() {
		com[0][0] = 1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j <= 1000; j++) {
				if (j == 0 || j == i) com[i][j] = 1;
				else com[i][j] = (com[i - 1][j - 1] + com[i - 1][j]) % MOD;
			}
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}