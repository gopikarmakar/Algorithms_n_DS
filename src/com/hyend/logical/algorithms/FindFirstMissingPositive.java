package com.hyend.logical.algorithms;

import java.util.PriorityQueue;

/**
 * 
 * Given an unsorted array of unique integer values. 
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
	
	/**
	 * It's 100% full proof but a huge space consuming an inefficient solution.
	 * A quite less space consuming more efficiently can be solved with min heap. 
	 */	 
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
	
	/**
	 * Very Efficient solution for all unique values.
	 * 
	 * @param arr
	 * @return
	 */
	public int findFirstPositive(int[] arr) {
		
		if(arr.length == 0)
			return 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > 0)
				pq.add(arr[j]);
		}
		
		int min = 1;
		while(!pq.isEmpty()) {
			
			int x = pq.poll();
			if(x != min) {
				break;
			}
			else min += 1;				
		}		
		return min;
	}	
}
