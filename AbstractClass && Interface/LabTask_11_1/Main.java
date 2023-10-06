
public class Main {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle("Square", 5.0, 5.0);
		System.out.println("Name: " + r1.name + 
								"\tArea: " + r1.area() +
									"\tPerimeter: " + r1.perimeter());

	}
}
