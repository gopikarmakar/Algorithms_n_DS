package com.hyend.data.storage.arrays;

import com.hyend.data.storage.search.FindKthElementInTwoSortedArrays;
import com.hyend.data.storage.search.FindKthSmallestElement;

/**
 * Find Median of two sorted arrays.
 * 
 * @author gopi_karmakar
 */
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		//int[] a = {1, 3, 4, 9};
		int[] a = {1, 3, 4, 9, 11};
		int[] b = {2, 5, 6, 8, 10};
		
		System.out.println(findMedian(a, b));
		System.out.println(median(a, b));
	}
    
    /**
     * An efficient O(n) solution but with extra O(m+n) space.    
     */
    private static double findMedian(int[] a, int[] b) {
    	
    	int m = a.length;
    	int n = b.length;
    	int s = (m+n);
    	int k = s/2;
    	
    	int[] merged = new int[(n + m)];
    	
    	for(int x = 0; x < m; x++) merged[x] = a[x];
    	for(int y = 0; y < n; y++) merged[(m+y)] = b[y];
    	
    	return (s%2 == 0) ? (FindKthSmallestElement.findKth(k, merged) +
    						FindKthSmallestElement.findKth(k+1, merged)) * 0.5 :
    						FindKthSmallestElement.findKth(k, merged);    	
    }
    
    /**
	 * A more efficient O(log k) solution with O(1) extra space
	 */
	private static double median(int[] a, int[] b) {
		
		int m = a.length, n = b.length;
		int s = (m+n);
		int k = s/2;
		
		return (s%2 == 0) ? (FindKthElementInTwoSortedArrays.findKth(a, b, k) + 
							FindKthElementInTwoSortedArrays.findKth(a, b, k + 1)) * 0.5 : 
							FindKthElementInTwoSortedArrays.findKth(a, b, k);
	}
}
