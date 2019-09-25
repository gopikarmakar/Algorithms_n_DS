package com.hyend.data.storage.arrays;

/**
 * Find maximum sum such that no two elements are adjacent
 * For e.g: 
 * {3, 2, 7, 10} = 3+10 = return 13
 * {3, 2, 5, 10, 7} = 3+5+7 = return 15
 * {1, 20, 3} = return 20
 * 
 * @author gopi_karmakar
 */
public class MaxSumWithNoAdjacents {

	public static void main(String[] args) {
		
		//int[] arr = {5, 5, 10, 100, 10, 5};
		//int[] arr = {3, 2, 7, 10};
		//int[] arr = {3, 2, 5, 10, 7};
		int[] arr = {1, 20, 3};
		System.out.println("Max Sum With No Two Adjacent = " + findMax(arr));
	}
	
	/**
	 * O(n) Time complexity.
	 */
	private static int findMax(int...arr) {
		
		int incl = arr[0], excl = 0, exclNew;
		
		for(int i = 1; i < arr.length; ++i) {
			
			//Current max excluding
			exclNew = (incl > excl) ? incl : excl;
			
			//Current max including
			incl = excl + arr[i];
			excl = exclNew;
		}
		
		return (incl > excl) ? incl : excl;
	}
}
	