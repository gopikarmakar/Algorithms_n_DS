package com.hyend.data.storage.search;

/**
 * Find the longest consecutive sequence.
 * for e.g: arr = {100. 4, 200, 1, 3, 2}
 * Then the longest consecutive sequence is:
 * {1, 2, 3, 4} so return the length 4
 * 
 * Assume all the numbers are positive
 * 
 * NOTE: The solution should execute in an O(n) time. 
 * 
 * @author gopi_karmakar
 */
public class FindLongestConsecutiveSequence {

	public static void main(String[] args) {
		
		int[] arr = {100, 4, 200, 98, 97, 2, 99, 3, 1, 0};
		System.out.println("Longest = " + find(arr));
	}	
	
	/**
	 * O(n) time and O(1) space complexity
	 */
	private static int find(int...arr) {
		
		int result = 0;
		
		int i = 0;
		
		while(i < arr.length) {
						
			if(arr[i] >= 0 && arr[i] <= arr.length && arr[arr[i]] != arr[i]) {
				
				int temp = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = temp;
 			}
			else i++;
		}
		
		for(i = 0; i < arr.length; i++) {
			
			System.out.println(arr[i]);
			if(arr[i] == i)
				result += 1;
		}		
		return result;
	}
}
