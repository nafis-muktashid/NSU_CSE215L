package LabTask_12_1;

public abstract class Polygon {
	int numSide;

	Polygon(int i) {
		this.numSide = i;
	}

	public int getNumSide() {
		return numSide;
	}

	public void setNumSide(int i) {
		this.numSide = i;
	}
	
	
	public abstract double area();
	public abstract double perimeter();
}
