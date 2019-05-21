import javax.swing.JOptionPane;

/*
 * Eduardo Méndez
 * Luis Miramontes
 */

public class MinimosCuadrados {
	private Double[] x,
					 y;
	private int n;
	
	
	public MinimosCuadrados(Double[] x, Double[] y) {
		this.x=x;
		this.y=y;
		this.n=x.length;
	}
	
	public Double[] resolver(int orden) {
		Double[] matriz = new Double[(orden+1)*(orden+2)];
		int c = 0;
		for(int i = 0; i<orden+1; i++) {
			for(int j = 0; j<orden+1;j++) {
				matriz[c]=this.sumatoriaX(j+i);
				c++;
			}
			matriz[c]=this.sumatoriaXY(i);
			c++;
		}
		
		Double[] result = new Matrix(orden+1, orden+2, matriz).getValues();
		
		return result;
		
		}
	
	private double sumatoriaX(int exponente) {
		double result=0;
		for(int i = 0; i<x.length; i++) {
			result+=Math.pow(x[i], exponente);
		}
		System.out.println(result);
		return result;
	}
	
	private double sumatoriaXY(int exponenteX) {
		double result=0;
		for(int i = 0; i<x.length; i++) {
			result+=(Math.pow(x[i], exponenteX)*y[i]);
		}
		System.out.println(result);
		return result;
	}
	/*
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce el numero total de valores discretos:\n");
		int n = scan.nextInt();
		Double[] x = new Double[n],
				 y = new Double[n];
		System.out.println("\n---------------------------\n"
				+ "Introduce los valores de X:\n");
		for(int i = 1; i<=n;i++) {
			System.out.print(i+" - ");
			x[i-1]=scan.nextDouble();
		}
		System.out.println();
		System.out.println("\n---------------------------\n"
				+ "Introduce los valores de Y:\n");
		for(int i = 1; i<=n;i++) {
			System.out.print(i+" - ");
			y[i-1]=scan.nextDouble();
		}
		System.out.println();
		System.out.println("\n---------------------------\n"
				+ "Introduce el orden del\npolinomio a ajustar:\n");
		int m = scan.nextInt();
		
		MinimosCuadrados mc = new MinimosCuadrados(x,y);
		Double[] result = mc.resolver(m);
		System.out.println();
		
		System.out.println("\n---------------------------\n"
				+ "Resultado:\n");
		
		for(int i = 0; i<result.length;i++) {
			System.out.println("a" + i + " = " + result[i]);
		}
		
		System.out.println();
		System.out.print("y = ");
		for(int i = result.length-1; i>0;i--) {
			double f = result[i];
			System.out.printf("(%.2f x^" + i+") + ",f);
		}
		double f = result[0];
		System.out.printf("(%.2f)",f);
		
	}*/
	
	public static Double[][] ingresar(int num) {
		Double[] x = new Double[num];
		Double[] y = {-20.0,-10.0,0.0,10.0,20.0};
		
		for(int i = 0; i<num;i++) {
			x[i] = Double.parseDouble(JOptionPane.showInputDialog("Punto x - " + (i+1)));
		}
		
		Double[][] result = {x,y};
		return result;
		
	}
	
	public static void main(String[] args) {
		Double[] x = {-20.0,-10.0,0.0,10.0,20.0};
		Double[] y = {98.0,99.0,100.0,101.0,102.0};
		Double[][] puntos = ingresar(3);
		MinimosCuadrados mc = new MinimosCuadrados(x, y);
		Double[] result = mc.resolver(1);
		System.out.println("---------");
		System.out.println(result[1] + "+ x "+result[0]);
		
	}
}

