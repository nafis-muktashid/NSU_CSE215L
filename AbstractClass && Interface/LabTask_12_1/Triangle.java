package LabTask_12_1;
import java.lang.*;

public class Triangle extends Polygon {

	private double sideA;
	private double sideB;
	private double sideC;
	
	Triangle(double a, double b, double c) {
		super(3);
		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
	}
	
	

	public double getSideA() {
		return sideA;
	}



	public void setSideA(double sideA) {
		this.sideA = sideA;
	}



	public double getSideB() {
		return sideB;
	}



	public void setSideB(double sideB) {
		this.sideB = sideB;
	}



	public double getSideC() {
		return sideC;
	}



	public void setSideC(double sideC) {
		this.sideC = sideC;
	}



	@Override
	public double area() {
		double peri = perimeter()/2;
		return Math.sqrt(peri*(peri-sideA)*(peri-sideB)*(peri-sideC));
	}

	@Override
	public double perimeter() {
		return this.sideA+this.sideB+this.sideC;
	}

}
