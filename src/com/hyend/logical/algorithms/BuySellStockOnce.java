package com.hyend.logical.algorithms;

/**
 * 
 * @author gopi_karmakar
 * As an example, consider the following sequence of stock prices: 
 * (310,315,275,295,260,270,290,230,255,250). 
 * The maximum profit that can be made with one buy and one sell is 30.
 * Buy at 260 and sell at 290.
 * Note that 260 is not the lowest price, nor 290 the highest price.
 * 
 * The same question asked by many different ways in Amazon and Google interview Like:
 * Calculate the min or max difference of the coldest or hottest days from 
 * the list of given temperatures of days.
 *
 */
public class BuySellStockOnce {
	
	public static void main(String...args) {		
		double[] stockPrices = {310,315,275,295,260,270,290,230,255,250};
		printMSG("Max Profit = " + computeMaxProfit(stockPrices));
	}
	
	private static Double computeMaxProfit(double...prices) {
		
		double maxProfit = 0.0;		
		double minPrice = Double.MAX_VALUE;
		
		for(double price : prices) {
			
			maxProfit = Math.max(maxProfit, (price - minPrice));
			minPrice = Math.min(price, minPrice);
		}
		
		return maxProfit;
	}
	
	private static void printMSG(String msg) {		
		System.out.println(msg);
	}
}