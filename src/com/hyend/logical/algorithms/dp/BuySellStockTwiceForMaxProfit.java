package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Amazon Interview question:
 * Compute max profit by buying and selling stocks twice
 * 
 * For e.g: consider the following sequence of stock prices:  
 * (12,11,13,9,12,8,14,13,15)
 * Compute the max profit by buying and selling the share at most twice.
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * @author gopi_karmakar
 */
public class BuySellStockTwiceForMaxProfit {

	public static void main(String[] args) {
		
		double[] prices = {12,11,13,9,12,8,14,13,15};
		//double[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
		//double[] prices = {1,2,3,4,5};
		//double[] prices = {7,6,4,3,1};
		System.out.println("Max Profit = " + buySellTwice(prices));	
		
		System.out.println("Max Profit = " + buySell(prices));
	}
	
	/**
	 * Accepted in LeetCode with Memory Usage >86%
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
	
	/**
	 * Accepted in LeetCode with Runtime >57%
	 */
	private static double buySell(double[] prices) {
		
		double profitOne = 0;
		double profitTwo = 0;
		double buyOne = Integer.MAX_VALUE;
		double buyTwo = Integer.MAX_VALUE;
		
		for(double price : prices) {
			
			buyOne = Math.min(buyOne, price);
			profitOne = Math.max(profitOne, (price - buyOne));
			buyTwo = Math.min(buyTwo, (price - profitOne));
			profitTwo = Math.max(profitTwo, (price - buyTwo));
		}
		return profitTwo;
	}
}
