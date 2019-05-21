
public class Test {
	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(3,0);
		Point p3 = new Point(0,4);
		Triangle t1 = new Triangle(p1, p2, p3);
		System.out.println("El area del " + t1.getName() + " es: " + t1.getArea());
	}
}
