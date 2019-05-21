class ComplejoDemo{
	public static void main(String[] args){
		Complejo uno = new Complejo(25,42);
		Complejo dos = new Complejo(41,13);
		
		uno.imprimir();
		dos.imprimir();
		
		uno.agregar(-10,-30);
		uno.imprimir();
		dos.agregar(uno);
		dos.imprimir();

		Complejo tres = dos.suma(uno);
		tres.imprimir();
		
		Complejo cuatro = uno.multiplicacion(3);
		cuatro.imprimir();
		
		Complejo cinco = cuatro.resta(tres);
		cinco.imprimir();
		
		Complejo seis = cinco.multiplicacion(uno);
		seis.imprimir();

		Complejo siete = seis.conjugado();
		siete.imprimir();
	}
}