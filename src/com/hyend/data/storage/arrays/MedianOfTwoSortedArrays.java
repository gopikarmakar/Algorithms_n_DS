package com.hyend.data.storage.arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Find Median of two sorted arrays.
 * 
 * @author gopi_karmakar
 */
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		
		//int[] a = {1, 3, 4, 9};
		//int[] a = {1, 3, 4, 9, 11};
		//int[] b = {2, 5, 6, 8, 10};
		
		int[] a = {1, 3};
		int[] b = {2, 4};
		
		System.out.println(findMedian(a, b));		
		System.out.println(findMedian2(a, b));
	}
	
	/**
	 * 1st solution:
	 * A very efficient O(n) solution but takes O(m+n) extra space.
	 * 
     * Solution accepted in Leetcode with 2ms 99.68% runtime       
     */
    private static double findMedian(int[] nums1, int[] nums2) {
    	
    	int l1 = nums1.length;
    	int l2 = nums2.length;
    	
    	int len = l1 + l2;
    	int[] nums = new int[len];
    	
    	int i = 0, j = 0, k = 0;
    	
    	while(i < l1 && j < l2) {
    		
    		nums[k++] = (nums[i] < nums[j]) ? nums1[i++] : nums2[j++];    		
    	}    	
    	
    	while(i < nums1.length) nums[k++] = nums1[i++];
    	
    	while(j < nums2.length) nums[k++] = nums2[j++];    
    	
    	return (len % 2 == 0) ? (nums[len/2] + nums[(len/2)-1]) * 0.5 : nums[len/2];    	
    }
	
    /**
     * 2nd Solution without extra space
     * Also accepted in Leetcode with 99.68% runtime
     */
	private static double findMedian2(int[] nums1, int[] nums2) {
		
		int totalLength = nums1.length + nums2.length;
		
		boolean isEven = (totalLength % 2 == 0) ? true : false;
		
		int target = (isEven) ? totalLength/2 : (totalLength-1)/2;
				
		double sum = 0;
		int index1 = 0;
		int index2 = 0;
		
		for(int i = 0; i <= target; i++) {
			
			boolean isNums1Changed = false;
			
			if(index1 == nums1.length) {
				index2++;
			}			
			else if (index2 == nums2.length) {
				
				index1++;
				isNums1Changed = true;				
			}
			else if(nums1[index1] < nums2[index2]) {
				
				index1++;
				isNums1Changed = true;				
			}
			else {
				index2++; //if(nums1[index1] >= nums2[index2])
			}
			
			if(i == target) {
				sum += (isNums1Changed) ? nums1[index1-1] : nums2[index2-1];
			}
			else if(isEven && (i == target-1)) {
				sum += (isNums1Changed) ? nums1[index1-1] : nums2[index2-1];
			}							
		}
		return isEven ? sum/2 : sum;
	}        
}
