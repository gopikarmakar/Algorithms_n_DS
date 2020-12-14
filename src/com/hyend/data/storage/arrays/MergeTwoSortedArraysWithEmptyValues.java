package com.hyend.data.storage.arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Merge two sorted arrays which can contain empty entries:
 * For e.g:
 * a[] = {5, 13, 17, 19, 0, 0, 0, 0}
 * b[] = {3, 7, 11, 0}
 * return a[] = {3, 5, 7, 11, 13, 17, 19, 0}
 * 
 * NOTE: Always assume a.length > b.length and 0 means an empty entry.
 * @author gopi_karmakar
 */
public class MergeTwoSortedArraysWithEmptyValues {

	public static void main(String[] args) {
		
		//int[] nums1 = {5, 13, 17, 19, 0, 0, 0, 0};
		//int[] nums2 = {3, 7, 11, 0};
		
		int[] nums1 = {4, 5, 6, 0, 0, 0};
		int[] nums2 = {1, 2, 3};
		
		//int[] nums1 = {0};
		//int[] nums2 = {1};
		
		merge(nums1, nums2);
		
		for(int e : nums1) 
			System.out.print(e+ " ");
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime.
	 * O(n) time complexity
	 */
	private static void merge(int[] nums1, int[] nums2) {			
		
		int p1 = getNonZeroElementsLen(nums1);
		int p2 = getNonZeroElementsLen(nums2);
		
		int writeIdx = p1 + p2 + 1;
		
		while(p1 >= 0 && p2 >= 0) {			
			
			nums1[writeIdx--] = ((nums1[p1] > nums2[p2])) ? nums1[p1--] : nums2[p2--];			
		}
		
		// if we have elements remaining in nums2 array, copy those!
		while(p2 >= 0) {
			
			nums1[writeIdx--] = nums2[p2--];
		}
	}
	
	private static int getNonZeroElementsLen(int[] arr) {
		
		int l = arr.length-1;
		
		for(int i = l; i >= 0; --i) {
			
			if(arr[i] != 0) break;
			l--;
		}
		return l;
	}
}
