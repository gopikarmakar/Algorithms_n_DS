package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author gopi_karmakar
 */
public class BuySellStockMoreThanOnceForMaxProfit {
	
	public static void main(String[] args) {
				
		//double[] prices = {7, 1, 5, 3, 6, 4};
		double[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
		
		System.out.println("Max Profit By Many Times = " + buySellManyTimes(prices));
	}

	public static double buySellManyTimes(double[] prices) {
		
		if (prices.length < 1) {
            return 0;
        }
        
		double maxProfilt = 0, minPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
        	
            if (prices[i] < minPrice) {
            	
                minPrice = prices[i];
                
            } else {
            	
                maxProfilt = maxProfilt + (prices[i] - minPrice);
                minPrice = prices[i];
            }
        }
        return maxProfilt;
	}
}
