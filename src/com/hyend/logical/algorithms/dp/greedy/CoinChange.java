package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int[] coins = {2, 1, 5};
		int[] coins2 = {186, 419, 83, 408};		
		System.out.println(change(coins, 11));
	}	
	
	private static int change(int[] coins, int amount) {
		
		Arrays.sort(coins);
		
		int totalCoins = 0;
		
		for(int i = coins.length-1; i >= 0; --i) {
			
			totalCoins += amount / coins[i];
			amount %= coins[i];			
		}				
		return (amount > 0) ? -1 : totalCoins;
	}
}
