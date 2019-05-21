import java.util.Scanner;
import java.util.TreeSet;

public class ReberlandLinguistics {
	Scanner sc = new Scanner(System.in);
	private String s;
	private int n;
	private boolean[][] v;
	private boolean[][] m;
	private TreeSet<String> set;

	public ReberlandLinguistics(String s) {
		this.s = s;
		this.n = this.s.length();
		this.set = new TreeSet<>();
		this.v = new boolean[this.n + 5][5];
		this.m = new boolean[this.n + 5][5];
		for (int i = 5; i < this.n; i++) {
			evaluar(i, 2);
			evaluar(i, 3);
		}
		System.out.println(this.set.size());
		for (String str : this.set) {
			System.out.println(str);
		}
	}

	boolean evaluar(int i, int j) {
		if (i + j > this.n) {
			return false;
		}
		if (i + j == this.n) {
			this.set.add(this.s.substring(i, i + j));
			return true;
		}
		if (this.v[i][j]) return this.m[i][j];
		this.v[i][j] = true;
		boolean r = false;
		int nxt = i + j;
		if (j == 2) {
			if (evaluar(nxt, 3) || (nxt + 2 <= this.n && !this.s.substring(i, i + 2).equals(this.s.substring(nxt, nxt + 2)) && evaluar(nxt, 2))) {
				r = true;
			}
		} else {
			if (evaluar(nxt, 2) || (nxt + 3 <= this.n && !this.s.substring(i, i + 3).equals(this.s.substring(nxt, nxt + 3)) && evaluar(nxt, 3))) {
				r = true;
			}
		}
		if (r) {
			this.set.add(this.s.substring(i, i + j));
		}
		return this.m[i][j] = r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabra = sc.nextLine();
		new ReberlandLinguistics(palabra);
	}
}
