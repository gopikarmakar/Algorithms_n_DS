package com.hyend.logical.algorithms.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 * 
 * @author gopi_karmakar
 */
public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = {2, 1, 5};
		int[] coins2 = {186, 419, 83, 408};		
		System.out.println(coinChange(coins2, 6249));
	}
	
	/**
	 * 
	 */
	private static int coinChange(int[] coins, int amount) {
		
		int max = amount + 1;
		int[] dp = new int[max];
		
		Arrays.fill(dp, max);
		
		dp[0] = 0;
		
		for(int i = 1; i <= amount; ++i) {
			
			for(int j = 0; j < coins.length; ++j) {
				
				if(coins[j] <= i) {
					
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
