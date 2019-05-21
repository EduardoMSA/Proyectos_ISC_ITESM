import java.util.NoSuchElementException;

public class Cola<E> {
	private ListaEnlazada<E> lista;
	
	public Cola() {
		this.lista = new ListaEnlazada<E>();
	}
	
	public int size() {
		return this.lista.getTamaño();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void enqueue(E dato) {
		this.lista.insertaFin(dato);
	}
	
	public E dequeue() {
		try {
			return this.lista.borrarInicio();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacía");
		}
	}
	
	public void flush() {
		this.lista=new ListaEnlazada<>();
		System.gc(); //Garbage Collector
	}
	
	public E next() {
		try {
			return this.lista.getInicio();
		} catch(NoSuchElementException ex) {
			throw new NoSuchElementException("No se puede obtener el next de una cola vacía");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola cola = new Cola<String>();
		cola.enqueue("Elías");
		cola.enqueue("Kevin");
		cola.enqueue("Juan");
		cola.enqueue("Eduardo");
		System.out.println(cola.dequeue());
		System.out.println(cola.next());
		System.out.println(cola.dequeue());
		System.out.println(cola.next());
		System.out.println(cola.dequeue());
		System.out.println(cola.next());
		System.out.println(cola.dequeue());
		System.out.println(cola.next());
		System.out.println(cola.dequeue());

	}

}
