package com.hyend.data.storage.search;

/**
 * Given two sorted arrays of size m and n respectively, 
 * Find the k’th positioned element in the final sorted array.
 * For e.g : 
 * a[] = {2, 3, 7, 8}
 * b[] = {1, 4, 6, 9, 10}
 * k = 5
 * {1,2,3,4,6,7,8,9,10} = return 6 
 */
public class FindKthElementInTwoSortedArrays {

	public static void main(String[] args) {
		
		int[] a = {2, 3, 7, 8};		
		int[] b = {1, 4, 6, 9, 10};
		int k = 5;
		
		//int[] a = {1, 3, 4, 9, 11};
		//int[] b = {2, 5, 6, 8};
		//int k = 4;
		
		//int[] a = {1, 3, 4};
		//int[] b = {2};
		//int k = 2;
		
		System.out.println("Kth Element = " + findKth(a, b, k));
	}	
	
	/**
	 * O(log k) time complexity with O(1) extra space.
	 * Initializing proper lower and upper bounds are very important.
	 */
	public static int findKth(int[] a, int[] b, int k) {
		
		//Lower bound of elements we will choose in a.
		int l = Math.max(0, k - b.length);
		
		//Upper bound of elements we will choose in a.
		int u = Math.min(a.length, k);
		
		while(l < u) {
			
			int x = l + ((u - l)/2); //Adding of l is to be under b.length
			
			int ax1 = (x <= 0) ? Integer.MIN_VALUE : a[x-1];
			
			int ax = (x >= a.length) ? Integer.MAX_VALUE : a[x];
			
			int bkx1 = (k-x <= 0) ? Integer.MIN_VALUE : b[k-x-1];
			
			int bkx = (k-x >= b.length) ? Integer.MAX_VALUE : b[k-x];
			
			if(ax < bkx1) {
				l = x+1;				
			}
			else if(ax1 > bkx) {
				u = x-1;
			}
			else {
				//b[k-x-1] <= a[x] && a[x-1] < b[k-x]
				return Math.max(ax1, bkx1);
			}
		}
		
		/**
		 * Handling the cases like:
		 * if (ax < bkx1) || (ax1 > bkx) and l >= u then,
		 */
		int ab1 = (l <= 0) ? Integer.MIN_VALUE : a[l - 1];
		int bxkb1 = (k - l - 1 < 0) ? Integer.MIN_VALUE : b[k-l-1];
		
		return Math.max(ab1, bxkb1);
	}
}
