package AVL;

import DetectarCaras.Rostro;

public class NodoAVL {

    private int	    altura;
    private double  dato;
    private Rostro  rostro;
    private NodoAVL izq, der;

    public NodoAVL() {
	this.rostro = null;
	this.izq = null;
	this.der = null;
	dato = 0;
	altura = 0;
    }

    public NodoAVL(Rostro rostro) {
	this.rostro = rostro;
	this.izq = null;
	this.der = null;
	this.dato = this.rostro.getIndiceNC();
	this.altura = 0;
    }

    public Rostro getRostro() {
	return this.rostro;
    }

    public double getDato() {
	return this.dato;
    }

    public void setDato(int dato) {
	this.dato = dato;
    }

    public int getAltura() {
	return this.altura;
    }

    public void setAltura(int altura) {
	this.altura = altura;
    }

    public NodoAVL getIzq() {
	return this.izq;
    }

    public void setIzq(NodoAVL izq) {
	this.izq = izq;
    }

    public NodoAVL getDer() {
	return this.der;
    }

    public void setDer(NodoAVL der) {
	this.der = der;
    }
}
