package com.hyend.data.storage.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * For e.g: consider the following sequence of stock prices:  
 * (12,11,13,9,12,8,14,13,15)
 * Compute the max profit by buying and selling the share at most twice.
 * 
 * @author gopi_karmakar
 */
public class BuySellStockTwice {

	public static void main(String[] args) {
		double[] prices = {12,11,13,9,12,8,14,13,15};
		System.out.println("Max Profit = " + buySellTwice(prices));		
	}
	
	/**
	 * Solution: First we compute the profit by selling once.
	 * Then we again calculate profit backwards over selling once's 
	 * stock prices and combine these two. This yields the max profit
	 * by selling a stock twice. 
	 * 
	 * @param prices
	 * @return
	 */
	public static double buySellTwice(double...prices) {
		
		double maxTotalProfit = 0.0;
		double minPriceSoFar = Double.MAX_VALUE;		
		List<Double> firstBuySellProfits = new ArrayList<>();
		
		for(double price : prices) {			
			minPriceSoFar = Math.min(minPriceSoFar, price);			
			maxTotalProfit = Math.max(maxTotalProfit, price - minPriceSoFar);			
			firstBuySellProfits.add(maxTotalProfit);
		}
		
		/**
		 * Compute Backwards
		 */
		double maxPriceSoFar = Double.MIN_VALUE;
		for(int i = prices.length-1; i > 0; --i) {
			maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
			maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices[i] + firstBuySellProfits.get(i-1));
		}
				
		return maxTotalProfit;
	}
}
