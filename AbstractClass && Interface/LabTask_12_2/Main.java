package LabTask_12_2;

package pack1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Enter Product price: ");
		Scanner in = new Scanner(System.in);
		double price = in.nextDouble();

		
		System.out.println("Set percentage for Percentage Discount");
		double perDis = in.nextDouble();
		PercentageDiscount p1 = new PercentageDiscount(perDis);
		System.out.println("Percentage Discounted Price: "+p1.discountedPrice(price));
		
		
		System.out.println("Enter Threshold for Discount:");
		double thrsDis = in.nextDouble();
		System.out.println("Enter Discount amount:");
		double disAmnt = in.nextDouble();
		
		ThresholdDiscount t1 = new ThresholdDiscount(thrsDis, disAmnt);
		double disPrice = t1.discountedPrice(price);
		if(disPrice == 0) System.out.println("Threshold did not met for Threshold Discount");
		else System.out.println("Threshold Discoundet price: "+disPrice); 
		
		
		System.out.println("Enter Discount Amount for Best price: ");
		double discountAmnt = in.nextDouble();
		System.out.println("Enter Discount Percentage for Best Price: ");
		double percenAmnt = in.nextDouble();
		System.out.println("Enter Threshold Amount for Best price");
		double threshAmnt = in.nextDouble(); 
		BestForCustomer b1 = new BestForCustomer(percenAmnt, threshAmnt, discountAmnt );
		System.out.println(b1.discountedPrice(price));

	}

}
