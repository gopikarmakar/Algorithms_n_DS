package com.hyend.logical.algorithms.dp;

/**
 * Compute the maximum profit by buying and selling 
 * the stocks up to K transactions.
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * @author gopi_karmakar
 */
public class BuySellStockKTimesForMaxProfit {

	public static void main(String[] args) {
		 
		//int[] prices = {2, 4, 1};
		//int[] prices = {3, 2, 6, 5, 0, 3};
		int[] prices = {5, 11, 3, 50, 60, 90}; 			
		
		System.out.println(maxProfit(prices, 4));			
	}
	
	/**
	 * O(K * N) time complexity with extra O(K * N) space complexity.
	 */
	private static int maxProfit(int[] prices, int k) {
		
		/**
		 * If the k >= prices.length/2 then in such cases k actually doesn't matter
		 * because, since buying and selling a stock consider to be as one transaction. 
		 * So we need to buy and sell every stock if (k == prices.length/2) and
		 * in case of (k > prices.length/2) then we just need to calculate the max profit.
		 * So, here just selling a stock when currentStockPrice > buyingPrice and
		 * accumulating the profit and returning it as a result.
		 */
		if(k >= prices.length/2) {
			
			int res = 0;
			for(int i = 1; i < prices.length; ++i) {
				
				if(prices[i] > prices[i-1])
					res += Math.max(0,  prices[i] - prices[i - 1]);						
			}
			return res;			
		}
		
		int[][] dp = new int[k+1][prices.length];
		
		for(int i = 1; i <= k; ++i) {
			
			int max = -prices[0];
			
			for(int j = 1; j < prices.length; ++j) {
				
				dp[i][j] = Math.max(dp[i][j-1], max + prices[j]);
				max = Math.max(max, dp[i-1][j-1] - prices[j]);
			}
		}
		return dp[k][prices.length-1];
	}
}
