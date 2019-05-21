
public class Experimentos {
	public static void main(String[] args) {
		String[] a= new String[10];
		int num=3;
		a[0]="a";
		a[1]="b";
		a[2]="c";
		
		System.out.println(a[2]);
		
		for(int i = num; i>1; i--) {
			a[i]=a[i-1];
		}
		
		System.out.println(a[1]);
		
	}

}
