package LabTask_12_2;

public class BestForCustomer implements Discountable{
	private double percentage;
	private double threshold;
	private double discount;
	
	public BestForCustomer(double percentage, double threshold, double discount) {
		this.percentage = percentage;
		this.threshold = threshold;
		this.discount = discount;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public double discountedPrice(double price) {
		double p1 = price-price*(this.percentage/100);
		double p2 = 0;
		if(price>this.threshold) p2 = price - this.discount;
		
		if(p1>p2) return p1;
		else return p2;
	}
	
	
}
