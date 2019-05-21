/*
 * Eduardo Méndez
 * Luis Miramontes
 */
public class TiroParabolico {
	private Double[] y, x, tp, ecuacionX, ecuacionY;
	private Double v, vx, vy, angulo,ultimoTiempo,tiempoDeVuelo,tiempoParaInterseccion,px,py;
	private boolean posible;
	
	
	public TiroParabolico(Double[] x, Double[] y, Double[] ultimoTiempo) {
		this.x = x;
		this.y = y;
		this.tp=ultimoTiempo;
		
		this.posible = (this.y[this.y.length-1]<=0.0)?false:true;
		
		this.ultimoTiempo= this.tp[this.tp.length-1];
		
		MinimosCuadrados eqX = new MinimosCuadrados(this.tp,this.x);
		MinimosCuadrados eqY = new MinimosCuadrados(this.tp,this.y);
		this.ecuacionX=eqX.resolver(1);
		this.ecuacionY=eqY.resolver(2);
		//System.out.println(ecuacionY[0] + " - "+ecuacionY[1] + " - "+ecuacionY[2]);
		double tmp = this.tiempoEnPosicion(0.0);
		this.tiempoDeVuelo = (tmp-this.ultimoTiempo)/2;
		this.tiempoParaInterseccion = (double)this.ultimoTiempo + (double)this.tiempoDeVuelo;
		this.px = this.ecuacionX[0] + this.ecuacionX[1]*this.tiempoParaInterseccion;
		this.py = this.ecuacionY[0] + this.ecuacionY[1]*this.tiempoParaInterseccion + this.ecuacionY[2]*(this.tiempoParaInterseccion*this.tiempoParaInterseccion);
		
		
		
		
		
	}
	
	private Double tiempoEnPosicion(Double pos) {
		//System.out.println(this.ecuacionY[0] + " - " + this.ecuacionY[1] + " - " + this.ecuacionY[2]);
		Double ultimoTiempo = 0.0;
		ultimoTiempo = -((Math.sqrt(-(4*this.ecuacionY[0]*this.ecuacionY[2])+Math.pow(this.ecuacionY[1],2)+(4*this.ecuacionY[2]*pos))+this.ecuacionY[1])/(2*this.ecuacionY[2]));		
		return  ultimoTiempo;
	}
	
	public void interseccionEnUltimo() {
		this.vx = (this.x[this.x.length-1] / this.tp[this.tp.length-1]);
		this.vy = (this.y[this.y.length-1] / this.tp[this.tp.length-1]) + (4.9*this.tp[this.tp.length-1]);
		this.angulo = Math.toDegrees(Math.atan(Math.toRadians(this.vy) / Math.toRadians(this.vx)));
		this.ultimoTiempo = this.tp[this.tp.length-1];
		this.px = this.x[this.x.length-1];
		this.py = this.y[this.y.length-1];
		this.tiempoDeVuelo = this.ultimoTiempo; //Tiempo que dura para interceptar
		this.tiempoParaInterseccion = this.ultimoTiempo; //Tiempo en donde se intersecta
		this.ultimoTiempo = 0.0; //Tiempo para disparar
		this.v = Math.sqrt(Math.pow(this.vx, 2) + Math.pow(this.vy, 2));
	}
	
	public void interseccionEnUltimo2() {
		this.vx = (this.px / this.tiempoDeVuelo);
		this.vy = (this.py / this.tiempoDeVuelo) + (4.9*this.tiempoDeVuelo);
		System.out.println("V = " + this.vx);
		System.out.println("V = " + this.vy);
		this.angulo = Math.toDegrees(Math.atan(Math.toRadians(this.vy) / Math.toRadians(this.vx)));
		this.v = Math.sqrt(Math.pow(this.vx, 2) + Math.pow(this.vy, 2));
		
	}
	/*public static void main(String[] args) {
		Double[] x = {(double)5,(double)4,(double)3};
		Double[] y = {(double)3,(double)4,(double)3};
		Double[] ultimoTiempo = {(double)0,(double)1,(double)2};	
		
		TiroParabolico tp = new TiroParabolico(x, y, ultimoTiempo);
		tp.interseccionEnUltimo2();
		System.out.println(tp.getTiempoDeVuelo());
		System.out.println("Tiempo" + tp.tiempoParaInterseccion);
		System.out.println(tp.getVx());
		System.out.println(tp.getVy());
		System.out.println(tp.getPx());
		System.out.println(tp.getPy());
	}*/
	
	public double getPx() {
		return this.px;
	}
	
	public double getPy() {
		return this.py;
	}

	public double getV() {
		return this.v;
	}

	public double getVx() {
		return this.vx;
	}

	public double getVy() {
		return this.vy;
	}

	public double getAngulo() {
		return this.angulo;
	}
	
	public double getUltimoTiempo() {
		return this.ultimoTiempo;
	}
	
	public double getTiempoDeVuelo() {
		return this.tiempoDeVuelo;
	}
	
	public double getTiempoParaIntercepcion() {
		return this.tiempoParaInterseccion;
	}

	public void setY(Double[] y) {
		this.y = y;
	}

	public void setX(Double[] x) {
		this.x = x;
	}

	public void setTp(Double[] tp) {
		this.tp = tp;
	}
	
	public boolean getPosible() {
		return this.posible;
	}
}
