package com.hyend.data.storage.arrays;

/**
 * Given a binary array, find the maximum number of consecutive 1's
 * in this array if you can flip at most one 0.
 * 
 * for e.g: {1, 0, 1, 1, 0} return 4
 * if we flip the first 0 to 1 then it makes 4 consecutive 1's
 * 
 * @author gopi_karmakar
 */
public class MaxConsecutiveOnesAfterFlippingOneZero {

	public static void main(String[] args) {
		
		int[] arr = {1, 0, 1, 1, 0};
		System.out.println(getMaxOnes(arr));
	}
	
	/**
	 * O(n) time complexity O(1) space
	 */
	public static int getMaxOnes(int[] arr) {

		int max = 0, zeroLeft = 0, zeroRight = 0;
		
		for(int x : arr) {
			
			zeroRight++;
	         if (x == 0) {
	             zeroLeft = zeroRight;
	             zeroRight = 0;
	         }
	         max = Math.max(max, zeroLeft+zeroRight); 
		}	
		return max;
	}	
}
