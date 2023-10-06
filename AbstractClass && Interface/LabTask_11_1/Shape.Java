package LabTask_11_1;

public abstract class Shape {
	String name;
	
	Shape(){}
	Shape(String s){
		this.name = s;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String s) {
		this.name = s;
	}
	
	public abstract double area();
	public abstract double perimeter();
	
}
