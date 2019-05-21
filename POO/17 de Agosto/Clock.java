public class Clock{
	private int hr,
		    min,
		    sec;
	public Clock(){
		this(10,0,0);
	}	
	public Clock(int hr, int min, int sec){
		this.setTime(hr, min, sec);
	}

	public void setTime(int hr, int min, int sec){
		if(hr>=0 && hr<24){
			this.hr = hr;
		}
		else{
			this.hr = 10;
		}
		if(min>=0 && min<60){
			this.min = min;	
		}
		else{
			this.min = 0;
		}
		if(sec>=0 && sec<60){		
			this.sec = sec;
		}
		else{
			this.sec = 0;
		}
	}	
	public void printTime(){
		System.out.println(this.hr + ":" + this.min + ":" + this.sec);
	}
		
	public int getHours(){
		return this.hr;
	}
	
	public int getMinutes(){
		return this.min;
	}

	public int getSeconds(){
		return this.sec;
	}
	
	public void incrementHours(){
		//this.hr=this.hr<23?this.hr++:0; OPERADOR TERNARIO
		this.hr=++this.hr%24;
	}

	public void incrementMinutes(){
		this.min=++this.min%60;
		if(this.min==0){
			incrementHours();
		}
	}

	public void incrementSeconds(){
		this.sec=++this.sec%60;
		if(this.sec==0){
			incrementMinutes();
		}
	}
	public boolean equals(Clock reloj){
		/*if(this.hr==reloj.hr && this.min==reloj.min && this.sec==reloj.sec){
			return true;
		}
		else{
			return false;
		}
		*/
		return this.hr==reloj.hr && this.min==reloj.min && this.sec==reloj.sec;
	}
	public void makeCopy(Clock reloj){
		//this.setTime(reloj.hr, reloj.min, reloj.sec); No hace falta comprobar, pero igual vale
		this.hr = reloj.hr;
		this.min = reloj.min;
		this.sec = reloj.sec;
	}

	public Clock getCopy(){
		return new Clock(this.hr, this.min, this.sec);
	}
	
}