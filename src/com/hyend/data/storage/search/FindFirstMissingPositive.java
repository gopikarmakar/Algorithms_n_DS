package com.hyend.data.storage.search;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/first-missing-positive/
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
 * @author gopi_karmakar
 */
public class FindFirstMissingPositive {
	
	public FindFirstMissingPositive() {}
	
	public static void main(String[] args) {
		
		int[] arr = {8, 12, 1, 7, 9, 11, 10, 2};
		
		int val = findFirstMissingPositive(arr);
		
		System.out.println("First Missing Positive = " + val);
	}
	
	/**
	 * Solution 1: A full proof and most efficient O(n) solution.
	 * 
	 * The time complexity is O(n)
	 */
	private static int findFirstMissingPositive(int...arr) {
			
		int i = 0;
		while(i < arr.length) {
					
			if(arr[i] > 0 && arr[i] <= arr.length && arr[arr[i]-1] != arr[i]) {
				
				int x = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = x;
			}
			else i++;
		}
		
		for(int x : arr)
			System.out.println(x);
		
		for(i = 0; i < arr.length; i++) {
			if(arr[i] != i+1)
				return i+1;
		}
		return arr.length+1;
	}
	
	private static int getMax(int[] arr) {
		int max = 0;
		
		for(int x = 0; x < arr.length; x++) {			
			max = (arr[x] > max) ? arr[x] : max;					
		}
		System.out.println("Max = " + max);
		return max;
	}
	
	/**
	 * Solution 2: A huge space consuming inefficient O(n) solution  
	 */	 
	private static int findFirstMinPositive(int[] arr) {			
						
		int[] array = new int[getMax(arr)+1];
		
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
	 * Solution 3: Most inefficient O(n)log(n) solution.
	 * 
	 * @param arr
	 * @return
	 */
	private static int findFirstPositive(int[] arr) {
		
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
