import java.util.*;

public class Baraja{
	private Naipe[] cartas;
	
	private static Random ran=new Random();

	public Baraja(){
		this.cartas=new Naipe[52];
		int c=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				this.cartas[c++]=new Naipe(j,i);
			}
		}	
	}
	
	public String toString(){
		String resultado="";
		for(int i=0;i<this.cartas.length;i++){
			resultado+=this.cartas[i]+"\n";
		}
		return resultado;
		
	}
	
	public void mezclar(){  //Swap de cartas
		int aleatorio;
		Naipe tmp;  //Objeto Temporal
		for(int i=0;i<this.cartas.length;i++){
			aleatorio=ran.nextInt(52);
			tmp=this.cartas[i];
			this.cartas[i]=this.cartas[aleatorio];
			this.cartas[aleatorio]=tmp;
		}


	}
	
	public static void main(String[] args){
		Baraja baraja=new Baraja();
		System.out.println(baraja);
		System.out.println("----------------------------------------");
		baraja.mezclar();
		System.out.println(baraja);

	}

}