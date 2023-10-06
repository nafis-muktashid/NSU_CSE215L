package LabTask_11_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PercentageDiscount p1 = new PercentageDiscount(10.0);
		System.out.println("Percentage Discounted Price: "+p1.discountedPrice(100.0));
		
		
		
		ThresholdDiscount t1 = new ThresholdDiscount(100, 25);
		
		Scanner in = new Scanner(System.in);
		double price = in.nextDouble();
		
		double disPrice = t1.discountedPrice(price);
		if(disPrice == 0) System.out.println("Threshold did not met for Threshold Discount");
		else System.out.println("Threshold Discoundet price: "+disPrice); 
		
		

	}

}
