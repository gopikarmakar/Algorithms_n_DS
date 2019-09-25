package com.hyend.data.storage.arrays;

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
		
		int[] arr1 = {2, 3, 7, 8};
		int[] arr2 = {1, 4, 6, 9, 10};
		System.out.println("Kth Element = " + findKth(arr1, arr2, 5));
	}	
	
	/**
	 * O(log k) time complexity with O(1) extra space.
	 * Initializing proper lower and upper bounds are very important.
	 */
	private static int findKth(int[] a, int[] b, int k) {
		
		//Lower bound of elements we will choose in a.
		int l = Math.max(0, k - b.length);
		
		//Upper bound of elements we will choose in a.
		int u = Math.min(a.length, k);
		
		while(l < u) {
			
			int x = l + ((u -l)/2);
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
		
		int ab1 = (l <= 0) ? Integer.MIN_VALUE : a[l-1];
		int bxkb1 = (k - l - 1 < 0) ? Integer.MIN_VALUE : b[k-l-1];
		
		return Math.max(ab1, bxkb1);
	}
	
	/**
	 * A Naive solution with O(K) time and extra space complexity. 
	 */
	private static int find(int[] arr1, int[] arr2, int k) {
				
		int[] merged = new int[k];
		int i = 0, j = 0, m = arr1.length, n = arr2.length, writeIdx = 0;
		
		if(k > n+m) return k;
		
		/**
		 * It fails if k = m+n. Needs to take care of this condition 
		 */
		while(writeIdx < k) {
			
			if(i < m && arr1[i] < arr2[j]) {
				merged[writeIdx++] = arr1[i++];
			}
			else if(j < n && arr2[j] < arr1[i]) {
				merged[writeIdx++] = arr2[j++];
			}			
		}
		
		return merged[k-1];
	}
}
