public class Prueba {
	public static void main(String[] args) {
		
		
		Vertex v1 = new Vertex(0,0);
		Vertex v2 = new Vertex(0, 3);
		Vertex v3 = new Vertex(4,0);
		
		Triangle x = new Triangle(v1,v2,v3);
		
		
		System.out.println(x.name);
		System.out.println("Area: " + x.getArea());
	}
}
