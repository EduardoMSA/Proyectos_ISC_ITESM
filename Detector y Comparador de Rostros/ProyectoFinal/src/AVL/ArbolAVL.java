package AVL;

import java.io.IOException;
import java.util.Stack;

import DetectarCaras.Rostro;
import jssim.SsimException;

public class ArbolAVL {

    private NodoAVL raiz;

    // Constructor
    public ArbolAVL() {
	this.raiz = null;
    }

    // Verifica si esta vacio el arbol
    public boolean isEmpty() {
	return this.raiz == null;
    }

    // Reinicia el arbol
    public void vaciarArbol() {
	this.raiz = null;
    }

    // Obtiene la altura delnodo

    private int altura(NodoAVL nodo) {
	return nodo == null ? -1 : nodo.getAltura();
    }

    // Obtiene la altura mayor de sus ramas

    private int max(int izq, int der) {
	return izq > der ? izq : der;
    }

    // Funcion de insercion recursiva

    public void insertar(Rostro rostro) {
	this.raiz = insertar(rostro, this.raiz);
    }

    private NodoAVL insertar(Rostro rostro, NodoAVL nodo) {
	if(nodo == null) {

	    nodo = new NodoAVL(rostro);
	}
	else if(rostro.getIndiceNC() < nodo.getDato()) {

	    nodo.setIzq(this.insertar(rostro, nodo.getIzq()));

	    if(this.altura(nodo.getIzq()) - this.altura(nodo.getDer()) == 2)

		if(rostro.getIndiceNC() < nodo.getIzq().getDato()) {
		    nodo = this.rotacionDer(nodo);
		}
		else {
		    nodo = this.rotacionIzqDer(nodo);
		}
	}

	else if(rostro.getIndiceNC() > nodo.getDato()) {

	    nodo.setDer(this.insertar(rostro, nodo.getDer()));

	    if(this.altura(nodo.getDer()) - this.altura(nodo.getIzq()) == 2) {

		if(rostro.getIndiceNC() > nodo.getDer().getDato()) {

		    nodo = this.rotacionIzq(nodo);
		}

		else {

		    nodo = this.rotacionDerIzq(nodo);
		}
	    }
	}

	nodo.setAltura(this.max(this.altura(nodo.getIzq()), this.altura(nodo.getDer())) + 1);

	return nodo;

    }

    // Rotaciones
    private NodoAVL rotacionDer(NodoAVL n1) {

	NodoAVL n2 = n1.getIzq();

	n1.setIzq(n2.getDer());

	n2.setDer(n1);

	n1.setAltura(this.max(this.altura(n1.getIzq()), this.altura(n1.getDer())) + 1);

	n2.setAltura(this.max(this.altura(n2.getIzq()), n1.getAltura()) + 1);

	return n2;

    }

    private NodoAVL rotacionIzq(NodoAVL n1) {

	NodoAVL n2 = n1.getDer();

	n1.setDer(n2.getIzq());

	n2.setIzq(n1);

	n1.setAltura(this.max(this.altura(n1.getIzq()), this.altura(n1.getDer())) + 1);

	n2.setAltura(this.max(this.altura(n2.getDer()), n1.getAltura()) + 1);

	return n2;

    }

    private NodoAVL rotacionIzqDer(NodoAVL nodo) {
	nodo.setIzq(this.rotacionIzq(nodo.getIzq()));
	return this.rotacionDer(nodo);

    }

    private NodoAVL rotacionDerIzq(NodoAVL nodo) {

	nodo.setDer(this.rotacionDer(nodo.getDer()));
	return this.rotacionIzq(nodo);
    }

    // Obtener total de elementos
    public int cuentaNodos() {
	return cuentaNodos(this.raiz);
    }

    private int cuentaNodos(NodoAVL nodo) {
	if(nodo == null) {
	    return 0;
	}
	else {
	    int cuenta = 1;
	    cuenta += this.cuentaNodos(nodo.getIzq());
	    cuenta += this.cuentaNodos(nodo.getDer());

	    return cuenta;
	}
    }

    // Busqueda de elementos especificos
    public boolean busca(Rostro rostro) {
	return busca(this.raiz, rostro);
    }

    private boolean busca(NodoAVL nodo, Rostro rostro) {

	boolean encontrado = false;

	while((nodo != null) && !encontrado) {

	    double datoActual = nodo.getDato();

	    if(rostro.getIndiceNC() < datoActual) {

		nodo = nodo.getIzq();
	    }
	    else if(rostro.getIndiceNC() > datoActual) {

		nodo = nodo.getDer();
	    }
	    else {

		encontrado = true;

		break;

	    }

	    encontrado = busca(nodo, rostro);

	}

	return encontrado;

    }

    // Busqueda que devuelve el camino para encontrar un valor
    public Stack<NodoAVL> buscaSimilares(Rostro rostro) {
	Stack<NodoAVL> nodosSimilares = new Stack<NodoAVL>();
	return buscaSimilares(this.raiz, rostro, nodosSimilares);
    }

    private Stack<NodoAVL> buscaSimilares(NodoAVL nodo, Rostro rostro, Stack<NodoAVL> nodosSimilares) {
	while((nodo != null)) {

	    double datoActual = nodo.getDato();
	    nodosSimilares.push(nodo);

	    if(rostro.getIndiceNC() < datoActual) {

		nodo = nodo.getIzq();
	    }
	    else if(rostro.getIndiceNC() > datoActual) {

		nodo = nodo.getDer();
	    }
	    else {
		break;
	    }
	}

	return nodosSimilares;

    }

    // Recorridos

    public NodoAVL[] inorder() {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.inorder(this.raiz, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private NodoAVL[] inorder(NodoAVL nodo) {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.inorder(nodo, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private void inorder(NodoAVL nodo, Stack<NodoAVL> nodos) {

	if(nodo != null) {
	    this.inorder(nodo.getIzq(), nodos);
	    // System.out.print(nodo.getDato() + " ");
	    nodos.push(nodo);
	    this.inorder(nodo.getDer(), nodos);
	}
    }

    public NodoAVL[] preorder() {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.preorder(this.raiz, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private NodoAVL[] preorder(NodoAVL nodo) {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.preorder(nodo, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private void preorder(NodoAVL nodo, Stack<NodoAVL> nodos) {

	if(nodo != null) {
	    // System.out.print(nodo.getDato() + " ");
	    nodos.push(nodo);
	    this.preorder(nodo.getIzq(), nodos);
	    this.preorder(nodo.getDer(), nodos);
	}
    }

    public NodoAVL[] postorder() {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.postorder(this.raiz, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private NodoAVL[] postorder(NodoAVL nodo) {
	NodoAVL[] nodos;
	Stack<NodoAVL> stack = new Stack<>();
	this.postorder(nodo, stack);
	nodos = stack.toArray(new NodoAVL[stack.size()]);
	return nodos;
    }

    private void postorder(NodoAVL nodo, Stack<NodoAVL> nodos) {
	if(nodo != null) {
	    this.postorder(nodo.getIzq(), nodos);
	    this.postorder(nodo.getDer(), nodos);
	    // System.out.print(nodo.getDato() + " ");
	    nodos.push(nodo);
	}
    }

    public Rostro rostroSimilar(Rostro rostro) throws SsimException, IOException {
	Rostro rostroSimilar = this.raiz.getRostro();
	NodoAVL[] rostrosPosibles = (rostro.getIndiceNC() < rostroSimilar.getIndiceNC())
		? this.inorder(this.raiz.getIzq())
		: this.inorder(this.raiz.getDer());
	for(NodoAVL i : rostrosPosibles) {
	    if(rostro.compareTo(i.getRostro()) > (rostro.compareTo(rostroSimilar))) {
		rostroSimilar = i.getRostro();
	    }
	}
	return rostroSimilar;
    }

    public Rostro rostroSimilarProfundo(Rostro rostro) throws SsimException, IOException {
	Rostro rostroSimilar = this.raiz.getRostro();
	NodoAVL[] rostrosPosibles = this.inorder(this.raiz);
	for(NodoAVL i : rostrosPosibles) {
	    if(rostro.compareTo(i.getRostro()) > (rostro.compareTo(rostroSimilar))) {
		rostroSimilar = i.getRostro();
	    }
	}
	return rostroSimilar;
    }

    public static void main(String[] args) {
	ArbolAVL avl = new ArbolAVL();

	try {
	    avl.insertar(new Rostro("IMGS/freeman.jpg"));
	    avl.insertar(new Rostro("IMGS/NC.jpg"));
	    avl.insertar(new Rostro("IMGS/SLJ.jpg"));
	    avl.insertar(new Rostro("IMGS/taylorL.jpg"));
	    avl.insertar(new Rostro("IMGS/krisH.jpg"));

	    // Stack<NodoAVL> nodos = avl.buscaSimilares(new Rostro("IMGS/kgy.jpg"));
	    // while(!nodos.isEmpty()) {
	    // System.out.println(nodos.pop().getDato());
	    // }
	    // System.out.println(avl.busca(new Rostro("IMGS/kgy.jpg")));
	    Rostro rostro = avl.rostroSimilar(new Rostro("IMGS/NC.jpg"));
	    System.out.println(rostro.getIndiceNC());
	}
	catch(SsimException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	catch(IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// avl.preorder();
    }
}
