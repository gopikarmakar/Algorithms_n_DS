package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an Array of integers find Three values
 * (not necessarily distinctive) whose product is the maximum.
 * 
 * @author gopi_karmakar
 */
public class FindTripletsForMaximumProduct {

	public static void main(String[] args) {
		
		//int[] arr = {100, 2, 7, -20, -30, 5, -40};
		int[] arr = {100, 2, 7, 20, 30, 5, -40};
		System.out.println(maxProduct(arr));
	}
	
	/**
	 * Time complexity will be dominated by sort O(n log n)
	 */
	public static List<Integer> maxProduct(int...arr) {		
		List<Integer> list = new ArrayList<>();
		List<Integer> headList = new ArrayList<>();
		List<Integer> tailList = new ArrayList<>();				
		
		if(arr.length > 3) {
			
			Arrays.sort(arr);
			int headMax = 1, tailMax = 1;		
			
			for(int i = 0; i < 3-1; i++) {
				headMax *= arr[i];
				headList.add(arr[i]);					
			}				
			headMax *= arr[arr.length-1]; 
			headList.add(arr[arr.length-1]);
			
			for(int i = (arr.length)-3; i < arr.length; i++) {
				tailMax *= arr[i];
				tailList.add(arr[i]);
			}								
			list = (headMax > tailMax) ? headList : tailList; 
		}				
		return list;
	}
}
