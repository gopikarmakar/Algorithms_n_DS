package com.hyend.data.storage.arrays;

/**
 * Given two sorted arrays of size m and n respectively, 
 * you are tasked with finding the element that would be 
 * at the k’th position of the final sorted array.
 */
public class FindKthSmallestElementInTwoSortedArrays {

	public static void main(String[] args) {
		
	}	
	
	/**
	 * A Naive solution with O(m+n) extra space. 
	 * 
	 * @param arr1
	 * @param arr2
	 * @param l1
	 * @param l2
	 * @param k
	 * @return
	 */
	private static int find(int[] arr1, int[] arr2, int l1, int l2, int k) {
		
		int[] common = new int[l1+l2];
		int i = 0, j = 0, x = 0;
		
		while(true) {
			
			if(i < l1) {
				if(arr1[i] < arr2[j]) common[x++] = arr1[i++];
			}			
			if(j < l2) {
				if(arr1[i] > arr2[j]) common[x++] = arr2[j++];
			}
			if((i+j) == (l1+l2)) return common[k-1];
		}
	}
}
