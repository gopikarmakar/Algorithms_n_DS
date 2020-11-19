package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * As an example, consider the following sequence of stock prices: 
 * (310,315,275,295,260,270,290,230,255,250). 
 * The maximum profit that can be made with one buy and one sell is 30.
 * Buy at 260 and sell at 290.
 * Note that 260 is not the lowest price, nor 290 the highest price.
 * 
 * Solution Accepted with the 99.21% runtime.
 *
 * @author gopi_karmakar
 */
public class BuySellStockOnceForMaxProfit {
	
	public static void main(String...args) {	
		
		double[] stockPrices = {310,315,275,295,260,270,290,230,255,250};		
		printMSG("Max Profit = " + computeMaxProfit(stockPrices));
	}
	
	private static Double computeMaxProfit(double...prices) {
		
		double maxProfit = 0.0;		
		double minPrice = Double.MAX_VALUE;
		
		for(double price : prices) {
			
			minPrice = Math.min(price, minPrice);
			maxProfit = Math.max(maxProfit, (price - minPrice));			
		}
		
		return maxProfit;
	}
	
	private static void printMSG(String msg) {		
		System.out.println(msg);
	}
}