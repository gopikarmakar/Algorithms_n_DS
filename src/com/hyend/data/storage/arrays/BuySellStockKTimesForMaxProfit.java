package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.ArrayList;

/**
 * Compute the maximum profit by buying and selling 
 * the stocks up to K transactions. 
 * 
 * @author gopi_karmakar
 */
public class BuySellStockKTimesForMaxProfit {

	public static void main(String[] args) {
		 
		int[] arr = {5, 11, 3, 50, 60, 90}; 
		System.out.println(maxProfit(2, arr));
	}
	
	/**
	 * O(kn) time complexity with extra O(k*2) space complexity.
	 */
	private static double maxProfit(int k, int...arr) {
		
		List<Double> kSum = new ArrayList<>();
		for(int i = 0; i < k*2; ++i) {
			kSum.add(Double.NEGATIVE_INFINITY);
		}			
		
		for(int i = 0; i < arr.length; ++i) {
					
			List<Double> preKSum = new ArrayList<>(kSum);
			
			for(int j = 0, sign = -1; j < kSum.size() && j <= i; ++j, sign *= -1) {
				
				double diff = sign * arr[i] + (j == 0 ? 0 : preKSum.get(j-1));
				kSum.set(j, Math.max(diff, preKSum.get(j)));
			}
		}		
		return kSum.get(kSum.size()-1);
	}
}
