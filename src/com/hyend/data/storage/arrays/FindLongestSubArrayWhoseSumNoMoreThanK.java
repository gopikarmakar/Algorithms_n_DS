package com.hyend.data.storage.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the longest subarray whose sum is no more than K.
 * 
 * @author gopi_karmakar
 */
public class FindLongestSubArrayWhoseSumNoMoreThanK {

	public static void main(String[] args) {
		
		//int[] arr = {31, -15, 639, 342, -14, 565, -924, 635, 167, -70};	
		//int k = 184;
		
		int[] arr = {1, 2, 1, 0, 1, 1, 0};
		
		int[] arr2 = {1, 2 ,-1};
		
		int k = 2;
				
		System.out.println(find(k, arr2));
	}
	
	/**
	 * An O(n) solution.
	 */
	private static int find(int k, int...arr) {
		
		List<Integer> prefixSum = new ArrayList<>();
		
		int sum = 0;
		for(int x : arr) {
			sum += x;
			prefixSum.add(sum);
		}
		
		if(prefixSum.get(prefixSum.size()-1) <= k)
			return arr.length;
		
		System.out.println(prefixSum);
					
		List<Integer> minPrefixSum = new ArrayList<>(prefixSum);
		
		for(int i = prefixSum.size()-2; i >= 0; --i) {
			minPrefixSum.set(i, Math.min(prefixSum.get(i), prefixSum.get(i+1)));
		}
		System.out.println(minPrefixSum);
		
		int a = 0, b = 0, maxLength = 0;
		
		while(a < arr.length && b < arr.length) {
			
			int minCurrentSum = (a > 0) ? minPrefixSum.get(b) - prefixSum.get(a-1) : minPrefixSum.get(b);
			
			if(minCurrentSum <= k) {
				int currentLength = b - a + 1;
				if(currentLength > maxLength)
					maxLength = currentLength;
				
				b++;
			}
			else {
				// minCurrentSum > k
				a++;
			}
		}
		//System.out.println("Indices = {" + (b-(a+1)) + ", " + (a) + "}");
		return maxLength; 
	}
}
