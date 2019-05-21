public class UsaTermometro{
	public static void main(String[] args){
		Termometro gda=new Termometro(21);
		Termometro chi=new Termometro();

		System.out.println(gda.getTemp());
		System.out.println(chi.getTemp());

		gda.setTemp(22);
		chi.setTemp(-5);

		System.out.println(gda.getTemp());
		System.out.println(chi.getTemp());
	}
}