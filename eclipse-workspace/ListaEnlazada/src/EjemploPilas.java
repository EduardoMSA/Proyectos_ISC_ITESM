/*
 * Eduardo Méndez A01632947
 * EjemploPilas
 * 13/02/18
 */
public class EjemploPilas {
	
	public static Stack<Integer> clonarPila(Stack<Integer> pila){
		Stack<Integer> nuevo = new Stack<>();
		Integer[] tmp = new Integer[pila.size()];
		for(int i = 0; i<tmp.length;i++) {
			tmp[i]=pila.pop();
		}
		for(int i = tmp.length-1; i>=0;i--) {
			pila.push(tmp[i]);
			nuevo.push(tmp[i]);
		}
		return nuevo;
	}
	
	public static void borrarValor(Stack<Integer> pila, int valor) {
		Integer[] tmp = new Integer[pila.size()];
		for(int i = 0; i<tmp.length;i++) {
			tmp[i]=pila.pop();
		}
		for(int i = tmp.length-1; i>=0;i--) {
			if(tmp[i]!=valor) {
				pila.push(tmp[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Stack<Integer> x = new Stack<>();
		x.push(1);
		x.push(2);
		x.push(3);
		Stack<Integer> y= new Stack<>();
		y = clonarPila(x);
		borrarValor(y, 2);
		borrarValor(y, 1);
		borrarValor(y, 5);
		borrarValor(y, 7);
		while(!y.isEmpty()) {
			System.out.println(y.pop() + " ");
		}

	}

}
