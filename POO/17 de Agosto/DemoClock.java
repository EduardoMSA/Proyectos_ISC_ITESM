class DemoClock{
	public static void main(String[] args){
		Clock gda=new Clock(23,59,59);
		Clock tij=new Clock(8,53,30);
		Clock tkt=new Clock(-4567,98345,9834894);
		
		gda.printTime();
		tij.printTime();

		//gda.incrementHours();
		//gda.incrementMinutes();
		gda.incrementSeconds();
		tij.setTime(9,00,00);

		gda.printTime();
		tij.printTime();
		tkt.printTime();

	}
}