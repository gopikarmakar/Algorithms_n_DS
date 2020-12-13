package com.hyend.data.storage.search;

/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Find the first missing number.
 * 
 * Note: All the numbers of nums are unique.
 * 
 * @author gopi_karmakar
 */
public class FindMissingNumber {

	public static void main(String[] args) {
		
		int[] arr1 = {0, 1};
		int[] arr2 = {-1, -3};
		int[] arr3 = {3, 0, 1};		
		int[] arr4 = {0, 1, 2, 3};		
		int[] arr5 = {1, 3, 6, 4, 2, 0};
		int[] arr6 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		
		System.out.println(find(arr5));
		
		System.out.println(missingNumber(arr5));
	}
	
	/**
	 * 1st solution: An efficient and easy to understand
	 * 
	 * Faster than 100% and Memory usage less than 
	 * 71.06% Java submissions on LeetCode.
	 * 
	 * Time complexity O(n)
	 * Space Complexity O(1)
	 */
	public static int missingNumber(int[] arr) {
		
        int sum  = (arr.length * (arr.length + 1)) / 2;
        
        for(int i = 0; i < arr.length; i++){
            sum = sum - arr[i];
        }
        
        return sum;
    }
	
	/**
	 * 2nd solution: Faster than 28.45% and Memory usage
	 * less than 11.36% of Java submissions on LeetCode.
	 * 
	 * Time complexity O(n)
	 * Space Complexity O(1)
	 */
	private static int find(int[] arr) {
		
		int i = 0;				
		while(i < arr.length) {
			
			if(arr[i] >= 0 && arr[i] < arr.length && arr[arr[i]] != arr[i]) {
				int t = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = t;
			}
			else i++;
		}	
		for(i = 1; i < arr.length; i++) {
			
			if(arr[i] != i)
				return i;
		}		
		return arr[arr.length-1] + 1;
	}
}
