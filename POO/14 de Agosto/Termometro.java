import javax.swing.*;

public class Termometro{
	private int temp;
	public Termometro(){
		temp=0;
	}
	public Termometro(int temperatura){
		temp = temperatura;
	}
	public void setTemp(int temperatura){
		temp = temperatura;
	}
	public int getTemp(){
		return temp;
	}
}

	