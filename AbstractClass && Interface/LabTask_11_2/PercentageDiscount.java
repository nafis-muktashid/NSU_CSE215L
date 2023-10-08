package LabTask_11_2;
public class PercentageDiscount implements Discountable {
	private double percentage;
	
	PercentageDiscount() {}
	PercentageDiscount(double d) {
		this.percentage = d;
	}
	

	public double getPercentage() {
		return this.percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}


	@Override
	public double discountedPrice(double price) {
		return price-price*(this.percentage/100);
	}
}
