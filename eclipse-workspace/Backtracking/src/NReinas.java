public class NReinas {

	private boolean valido(int[] reinas, int f, int c) {
		for(int i=0; i<f; i++) {
			if(reinas[i]==c) {
				return false;
			}
			else if(Math.abs(f-i)==Math.abs(c-reinas[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void imprimeTablero(int[] reinas) {
		for(int i=0; i<reinas.length-1; i++) {
			System.out.print(reinas[i]+", ");
		}
		System.out.print(reinas[reinas.length-1]);
		System.out.println();
	}
	
	//Añadido por mi/////////////////////////////
	public void nReinas(int tamaño) {
		int[] reinas = new int[tamaño];
		for(int i=0;i<reinas.length;i++) {
			reinas[i]=-1;
		}
		this.nReinas(0, reinas);
		
	}
	////////////////////////////////////////////
	
	public void nReinas(int n, int[] reinas) {
		for(int i=0; i<reinas.length; i++) {
			if(this.valido(reinas, n, i)) {
				reinas[n]=i;
				if(n==reinas.length-1) {
					imprimeTablero(reinas);
				}
				else {
					this.nReinas(n+1, reinas);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NReinas nr=new NReinas();
		//int[] reinas = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		//nr.nReinas(0, reinas);
		nr.nReinas(8);

	}
}