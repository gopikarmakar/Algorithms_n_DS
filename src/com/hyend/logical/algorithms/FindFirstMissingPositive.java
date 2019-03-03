package com.hyend.logical.algorithms;

/**
 * An inefficient solution. Can be solved with min heap.
 * 
 * Given an unsorted integer array, 
 * find the smallest missing positive integer.
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * Input: [8, 9, 2, 7, 12, 11, 10, 1]
 * output: 3
 * 
 * It was a hard level LeetCodequestion 
 * Code has been submitted and accepted to LeetCode in one shot.
 *  
 * @author gopi_karmakar
 *
 */
public class FindFirstMissingPositive {

	int[] array;
	
	public FindFirstMissingPositive() {}
	
	private int getMax(int[] arr) {
		int max = 0;
		
		for(int x = 0; x < arr.length; x++) {			
			max = (arr[x] > max) ? arr[x] : max;					
		}
		System.out.println("Max = " + max);
		return max;
	}
	
	public int findFirstMinPositive(int[] arr) {	
						
		this.array = new int[getMax(arr)+1];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) 
				array[arr[i]] = arr[i];			
		}
		
		int min = 1;
		for(;min < array.length; min++) {			
			if(min != array[min]) {			
				break;
			}			
		}				
		return min;		
	}
}
