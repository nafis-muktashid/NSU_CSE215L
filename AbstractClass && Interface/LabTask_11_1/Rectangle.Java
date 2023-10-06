
public class Rectangle extends Shape {
	private double length;
	private double width;
	
	Rectangle(){}
	Rectangle(String s, double l, double w){
		super(s);
		this.length = l; 
		this.width = w;
	}
	
	
	public double getLength() {
		return this.length;
	}
	public void setLength(double l) {
		this.length = l;
	}
	public double getWidth() {
		return this.width;
	}
	public void setWidth(double w) {
		this.width = w;
	}
	
	public String name() {
		return super.name;
	}
	public double area() {
		return this.length*this.width;
	}
	public double perimeter() {
		return 2*(this.length+this.width);
	}
	
	
}
