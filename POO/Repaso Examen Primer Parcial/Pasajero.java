class Pasajero{
	private String nombre;
	private int edad;
	private boolean genero;
	private double saldo;
	
	public Pasajero(String nombre, int edad, boolean genero, double saldo){
		this.nombre=nombre;
		this.edad=edad;
		this.genero=genero;
		this.saldo=(saldo>0)?saldo:0;
	}
	
	public boolean comprar(double precio){
		if(precio>=0){
			if(precio<=this.saldo){
				this.saldo-=precio;
				return true;
			} 
			else{
				return false;
			}
		} 
		else{
			return false;
		}

	}

	public String getNombre(){
		return this.nombre;
	}

	public String toString(){
		String genero=(this.genero)?"masculino":"femenino";
		return this.nombre + ", " + this.edad + ", " + genero + ", " + this.saldo;
	}










}