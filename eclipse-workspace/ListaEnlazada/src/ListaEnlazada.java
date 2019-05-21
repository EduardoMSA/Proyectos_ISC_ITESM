/*
 * Eduardo Méndez Santa Ana A01632947
 * ListaEnlazada
 * 05/02/2018
 */

import java.util.NoSuchElementException;

public class ListaEnlazada<E> {
	private Nodo<E> inicio, fin;
	private int tamaño;

	public ListaEnlazada() {
		this.inicio = this.fin = null;
		this.tamaño = 0; // size
	}

	public ListaEnlazada(E[] datos) {
		// Tarea
		this();
		for(int i=0;i<datos.length;i++) {
			this.insertaFin(datos[i]);
		}
	}

	public E getInicio() {
		try {
			return this.inicio.getDato();
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("La lista está vacía");
		}
	}

	public E getFinal() {
		try {
			return this.fin.getDato();
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("La lista está vacía");
		}
	}

	public int getTamaño() {
		return this.tamaño;
	}
	
	public int getSize() { //No recuerdo si el nombre de este metodo estaba en ingles o en español, así que cree ambos; aunque utilizo el que está en espaol pricipalmente.
		return this.tamaño;
	}

	public boolean estaVacia() {
		return this.tamaño == 0;
	}

	public void insertarInicio(E dato) {
		Nodo<E> nuevo = new Nodo(dato, this.inicio);
		this.inicio = nuevo;
		if (this.estaVacia()) {
			this.fin = nuevo;
		}
		this.tamaño++;

	}

	public void insertaFin(E dato) {
		if (this.estaVacia()) {
			this.insertarInicio(dato);
		} else {
			Nodo<E> nuevo = new Nodo(dato);
			this.fin.setSiguiente(nuevo);
			this.fin = nuevo;
			this.tamaño++;
		}
	}

	public void insertaEn(int pos, E dato) {
		if (pos > 0 && pos < this.tamaño) {
			Nodo<E> nuevo = new Nodo(dato);
			Nodo<E> current = this.inicio;
			for (int i = 0; i < pos - 1; i++) {
				current = current.getSiguiente();
			}
			nuevo.setSiguiente(current.getSiguiente());
			current.setSiguiente(nuevo);
			this.tamaño++;
		} else if (pos == 0) {
			this.insertarInicio(dato);
		} else if (pos == this.tamaño) {
			this.insertaFin(dato);
		} else {
			throw new IllegalArgumentException("La posición de lista " + pos + " es invalida para una lista de tamaño "
					+ this.tamaño + " en el metodo insertaEn()");
		}

	}

	public E borrarInicio() throws NoSuchElementException {
		try {
			E tmp = this.getInicio();
			this.inicio = this.inicio.getSiguiente();
			this.tamaño--;
			if (this.tamaño == 1) {
				this.fin = null;
			}
			return tmp;
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("La lista Esta vacia");
		}
	}

	public E borrarFin() throws NoSuchElementException {
		try {
			if (this.tamaño == 1) {
				return this.borrarInicio();
			} else {
				E tmp = this.getFinal();
				Nodo<E> current = this.inicio;
				for (int i = 0; i < this.tamaño - 2; i++) {
					current = current.getSiguiente();
				}
				current.setSiguiente(null);
				this.fin = current;
				this.tamaño--;
				return tmp;
			}
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("No se puede borrar una lista vacia");
		}
	}
	
	public E borrarEn(int pos) {
		if(pos>0 && pos<this.tamaño) {
			Nodo<E> current = this.inicio;
			for(int i = 0; i<pos-1;i++) {
				current = current.getSiguiente();
			}
			Nodo<E> tmp = current;
			current = current.getSiguiente();
			tmp.setSiguiente(current.getSiguiente());
			this.tamaño--;
			return current.getDato();
		} else if(pos==0) {
			return this.borrarInicio();
		} else {
			throw new NoSuchElementException("No existe ningún valor en la posición "+pos+" de la lista");
		}
	}

	public void setAt(int pos, E dato) {
		if (pos >= 0 && pos < this.tamaño) {
			Nodo<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current = current.getSiguiente();
			}
			current.setDato(dato);
		} else {
			throw new IllegalArgumentException("La posicisón " + pos + " de una lista de tamaño " + this.tamaño
					+ " es invalida en el metodo setAt()");
		}
	}

	public String toString() {
		Nodo<E> current = this.inicio;
		String resultado = " ";
		for (int i = 0; i < this.tamaño - 1; i++) {
			resultado += current + ", ";
			current = current.getSiguiente();
		}
		resultado += current;
		return resultado;
	}
	/* Main
	
	public static void main(String[] args) {
		Integer[] numeros = {1,2,9,4,5,8,7};
		ListaEnlazada<Integer> lista = new ListaEnlazada<>(numeros);
		System.out.println(lista+ " Tamaño= "+ lista.getTamaño());
		lista.borrarFin();
		System.out.println(lista);
		
	}*/

}

class Nodo<E> {
	private E dato;
	private Nodo<E> siguiente;

	public Nodo(E dato, Nodo<E> siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public Nodo(E dato) {
		this(dato, null);
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public Nodo<E> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}

	public String toString() {
		return this.dato.toString();
	}
}
