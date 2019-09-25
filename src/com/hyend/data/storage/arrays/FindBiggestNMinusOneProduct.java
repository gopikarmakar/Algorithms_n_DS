package com.hyend.data.storage.arrays;

/**
 * FInd the maximum product of all elements except one.
 * For e.g: {3, 2, -1, 4, -1, 6}
 * 3 X -1 X 4 X -1 X 6 = 72 
 * 
 * @author gopi_karmakar
 */
public class FindBiggestNMinusOneProduct {

	public static void main(String[] args) {
		
		//int[] arr = {3, 2, 5, 4};
		//int[] arr = {3, 2, -1, 4};
		int[] arr = {3, 2, -1, 4, -1, 6};
		System.out.println(" = " + findNMinusOneMaxProduct(arr));
	}
	
	/**
	 * O(n) time complexity and O(1) space
	 */
	private static int findNMinusOneMaxProduct(int...arr) {
		
		int totalNegatives = 0;
		int smallestPositiveIdx = -1;
		int smallestNegativeIdx = -1, largeestNegativeIdx = -1;
		
		for(int i = 0; i < arr.length; ++i) {
			
			if(arr[i] < 0) {
				
				totalNegatives += 1;
				if(smallestNegativeIdx == -1 || arr[smallestNegativeIdx] < arr[i]) {
					smallestNegativeIdx = i;
				}
				if(largeestNegativeIdx == -1 || arr[i] < arr[largeestNegativeIdx]) {
					largeestNegativeIdx = i;
				}
			}
			else if(arr[i] > 0) {
				
				if(smallestPositiveIdx == -1 || arr[i] < arr[smallestPositiveIdx])
					smallestPositiveIdx = i;
			}
		}
		
		int idxToSkip = (totalNegatives % 2 != 0) ? smallestNegativeIdx : 
						(smallestPositiveIdx != -1) ? smallestPositiveIdx : largeestNegativeIdx;  
		
		int product = 1;
		System.out.print("{");
		for(int i = 0; i < arr.length; ++i) {			
			if(i != idxToSkip) {
				System.out.print(arr[i] + ", ");
				product *= arr[i];
			}
		}
		System.out.print("}");
		return product;
	}
}