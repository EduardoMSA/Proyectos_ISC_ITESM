public class Naipe{
	private int valor; //	 0->As, 1->Dos, 2->Tres,..., 9->Diez, 10->Joto, 11->Reina, 12->Rey
	private int palo; // 	0->Picas, 1->Corazones, 2->Treboles, 3->Diamantes

	private static final String[] VALORES = {"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho",	//Static -> Una copia por clase y no por objeto; Final -> No se puede modificar
				    		 "Nueve","Diez","Joto","Reina","Rey"};
	private static final String[] PALOS = {"Picas", "Corazones", "Treboles", "Diamantes"};			// Así se declaran las constantes (Suele estar en mayuscula)

	public Naipe(int valor, int palo){
		this.valor=valor; 
		this.palo=palo;
	}

	public String toString(){
		// return this.valores[this.valor] + " de " + this.palos[this.palo]; No es necesario poner this.valores; porque no hace referencia al objeto, sino a la calse.
		return VALORES[this.valor] + " de " + PALOS[this.palo];
	}

	public static void main(String[] args){
		Naipe carta= new Naipe(4,2);	
		System.out.println(carta);


	}
	
}