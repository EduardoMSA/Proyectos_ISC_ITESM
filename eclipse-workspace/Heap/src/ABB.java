/*
 * Eduardo Méndez A01632947
 * ABB
 * 06/03/18
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ABB<E extends Comparable<E>> {
	private NodoABB<E> raiz;
	private int size;

	public ABB() {
		this.raiz = null;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}
	
	public void insertar(E dato) {
		NodoABB<E> nuevo = new NodoABB<E>(dato);
		this.size++;
		if (this.raiz==null) {
			this.raiz = nuevo;
			this.size++;
		} else {
			NodoABB<E> current = this.raiz,
					   parent = null;
			while (current != null) {
				parent = current;
				if (dato.compareTo(parent.getValor()) > 0) {
					current = parent.getDer();
					if(current==null) {
						parent.setDer(nuevo);
						break;
					}
				} else if (dato.compareTo(parent.getValor()) < 0) {
					current = parent.getIzq();
					if(current==null) {
						parent.setIzq(nuevo);
						break;
					}
				}
			}
		}
	}

	public NodoABB<E> getRaiz() {
		return this.raiz;
	}
	
	public void preorden() {
		this.preorden(this.raiz);
		System.out.println();
	}
	
	private void preorden(NodoABB<E> nodo) {
		if(nodo!=null) {
			System.out.println(nodo.getValor());
			this.preorden(nodo.getIzq());
			this.preorden(nodo.getDer());
		}
	}
	
	private void inorden(NodoABB<E> nodo) {
		if(nodo!=null) {
			this.inorden(nodo.getIzq());
			System.out.println(nodo.getValor());
			this.inorden(nodo.getDer());
		}
	}
	
	public void inorden() {
		this.inorden(this.raiz);
		System.out.println();
	}
	
	private void postorden(NodoABB<E> nodo) {
		if(nodo!=null) {
			this.postorden(nodo.getIzq());
			this.postorden(nodo.getDer());
			System.out.println(nodo.getValor());
		}
	}
	
	public void postorden() {
		this.postorden(this.raiz);
		System.out.println();
	}
	
	public void nivel() {
		Queue<NodoABB<E>> cola = new LinkedList<NodoABB<E>>();
		cola.add(this.raiz);
		NodoABB<E> tmp = null;
		while(!cola.isEmpty()) {
			tmp = cola.poll();
			if(tmp.getIzq()!=null) {
				cola.add(tmp.getIzq());
			}
			if(tmp.getDer()!=null) {
				cola.add(tmp.getDer());
			}
			System.out.println(tmp);
		}
	}
	
	public E buscar(E dato) {
		NodoABB<E> current = this.raiz;
		while(current!=null && dato.compareTo(current.getValor())!=0) {
			if(dato.compareTo(current.getValor())<0) {
				current=current.getIzq();
			} else {
				current=current.getDer();
			}
		}
		if(current!=null) {
			return current.getValor();
		} else {
			return null;
		}
	}
	
	private NodoABB<E> predecesor(NodoABB<E> nodo){
		NodoABB<E> current = nodo.getIzq();
		while(current.getDer()!=null) {
			current=current.getDer();
		}
		return current;
	}
	
	public E eliminar(E dato) {
		NodoABB<E> current = this.raiz;
		NodoABB<E> parent = null;
		boolean lado = true; //Lado en donde se encuentra el nodo current con respecto a el nodo parent true=izq/false=der
		
		//Encontrar el nodo que contiene el dato a borrar
		while(current!=null && dato.compareTo(current.getValor())!=0) {
			parent=current;
			if(dato.compareTo(current.getValor())<0) {
				current=current.getIzq();
				lado=true;
			} else {
				current=current.getDer();
				lado=false;
			}
		}
		if(current==null) {
			throw new NoSuchElementException("No se encontró el elemento a borrar");
		}
		
		//Eliminar nodo sin hijos
		if(current.getIzq()==null && current.getDer()==null) { 
			if(current.equals(this.raiz)) {
				this.raiz=null;
			}
			
			if(lado) {
				parent.setIzq(null);
				
			} else {
				parent.setDer(null);
			}
		} 
		
		//Eliminar nodo con un solo hijo
		else if(current.getIzq()==null || current.getDer()==null) {
			if(current.equals(this.raiz)) {
				if(current.getIzq()==null) {
					this.raiz=current.getDer();
				} else {
					this.raiz=current.getIzq();
				}
			}
			if(current.getIzq()==null) {
				if(lado) {
					parent.setIzq(current.getDer());
				} else {
					parent.setDer(current.getDer());
				}
			} else {
				if(lado) {
					parent.setIzq(current.getIzq());
				} else {
					parent.setDer(current.getIzq());
				}
			}
		} 
		
		//Eliminar nodo con dos hijos
		else {
			NodoABB<E> nodoPredecesor = new NodoABB<E>(this.predecesor(current).getValor());
			nodoPredecesor.setDer(current.getDer());
			nodoPredecesor.setIzq(current.getIzq());
			this.eliminar(this.predecesor(current).getValor()); //Elimina el nodo predecesor al nodo current para que no se repita
			if(current.equals(this.raiz)) {
				this.raiz=nodoPredecesor;
			} else {
				if (lado) {
					parent.setIzq(nodoPredecesor);
				} else {
					parent.setDer(nodoPredecesor);
				}
			}
		}
		
		this.size--;
		return current.getValor();
	}
	
	public static void main(String[] args) {
		ABB<Integer> abb = new ABB<Integer>();
		abb.insertar(5);
		abb.insertar(2);
		abb.insertar(7);
		abb.insertar(3);
		abb.insertar(1);
		abb.insertar(6);
		abb.insertar(8);
		abb.insertar(4);
		abb.insertar(10);
		abb.insertar(9);
		
		ABB<Integer> abbB = new ABB<Integer>();
		abbB.insertar(21);
		abbB.insertar(13);
		abbB.insertar(33);
		abbB.insertar(10);
		abbB.insertar(18);
		abbB.insertar(25);
		abbB.insertar(40);
		abbB.insertar(29);
		abbB.insertar(27);
		abbB.insertar(30);
		//System.out.println(abb.raiz.getDer().getIzq());
		abbB.eliminar(21);
		
		abbB.nivel();

	}

}

class NodoABB<E> {
	private E valor;
	private NodoABB<E> izq, der;

	public NodoABB(E valor) {
		this(valor, null, null);
	}

	public NodoABB(E valor, NodoABB<E> izq, NodoABB<E> der) {
		this.valor = valor;
		this.izq = izq;
		this.der = der;
	}

	public E getValor() {
		return valor;
	}

	public void setValor(E valor) {
		this.valor = valor;
	}

	public NodoABB<E> getIzq() {
		return izq;
	}

	public void setIzq(NodoABB<E> izq) {
		this.izq = izq;
	}

	public NodoABB<E> getDer() {
		return der;
	}

	public void setDer(NodoABB<E> der) {
		this.der = der;
	}

	public String toString() {
		return this.valor.toString();
	}
}
