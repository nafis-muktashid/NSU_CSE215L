package LabTask_12_2;
package pack1;

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
		PercentageDiscount p11 = new PercentageDiscount(this.percentage);
		ThresholdDiscount p12 = new ThresholdDiscount(this.threshold, this.discount);
		double p1 = p11.discountedPrice(price);
		double p2 = p12.discountedPrice(price);
		if(price>this.threshold) p2 = price - this.discount;
		
		if(p1<p2) {
			System.out.print("From Percentage Discount ");
			return p1;
		}
		else {
			System.out.print("From Threshold Discount ");
			return p2;
		}
	}
	
	
}
