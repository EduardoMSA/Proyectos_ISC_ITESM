import java.util.NoSuchElementException;

public class Stack<E> {
	private ListaEnlazada<E> lista;

	public Stack() {
		this.lista = new ListaEnlazada<E>();
	}

	public int size() {
		return this.lista.getTamaño();
	}

	public boolean isEmpty() {
		return this.lista.estaVacia();
	}

	public void push(E dato) {
		this.lista.insertarInicio(dato);
	}

	public E pop() {
		try {
			return this.lista.borrarInicio();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede hacer un pop de una stack vacío");
		}
	}

	public void flush() {
		this.lista = new ListaEnlazada<>();
		System.gc(); // Garbage Collector
	}

	public E top() {
		try {
			return this.lista.getInicio();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede hacer un top de una stack vacío");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack sk = new Stack<String>();
		String[] nombres = {"Eduardo","Mariana","Andres","Gabriel","José","Paola"};
		for(String nombre:nombres) {
			sk.push(nombre);
		}
		
		while(!sk.isEmpty()) {
			System.out.println(sk.pop());
		}

	}

}
