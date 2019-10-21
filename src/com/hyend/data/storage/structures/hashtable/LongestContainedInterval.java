package com.hyend.data.storage.structures.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Find the longest contained interval such that
 * if two integers are in the subset, then so are all integers between them
 * For e.g: {3,-2,7,9,8,1,2,0,-1,5,8} 
 * then Subset {-2,-1,0,1,2,3} there're all values present between -2 and 3
 * return the length of such a subset, in this case it's 6.
 * 
 * @author gopi_karmakar
 */
public class LongestContainedInterval {

	public static void main(String[] args) {
		
		Integer[] arr = {3, -2, 7, 9, 8, 1, 2, 0, -1, 5, 8};
		System.out.println("Maximum Length = " + find(arr));		
	}
	
	/**
	 * Since we add and remove array elements in the hash table no more than once.
	 * The time complexity of this approach is O(n), where n is the array length.
	 */
	public static int find(Integer...arr) {
		
		int maxIntervalSize = 0;
		Set<Integer> set = new HashSet<>(Arrays.asList(arr));
		
		Queue<Queue<Integer>> subsets = new LinkedList<>();
				
		for(int x: arr) {
			
			LinkedList<Integer> subset = new LinkedList<>();
			subset.add(x);
			set.remove(x);
			
			int lowerBound = x - 1;
			while(set.contains(lowerBound)) {
				subset.add(lowerBound);
				set.remove(lowerBound);
				lowerBound -= 1;
			}
			
			int upperBound = x + 1;
			while(set.contains(upperBound)) {
				subset.add(upperBound);
				set.remove(upperBound);
				upperBound += 1;
			}
			
			maxIntervalSize = Math.max(maxIntervalSize, upperBound - lowerBound - 1);
			subsets.add(subset);
		}
		print(subsets);		
		return maxIntervalSize;
	}
	
	private static void print(Queue<Queue<Integer>> subsets) {		
		
		subsets.forEach(x -> {
			System.out.println(x);
		});		
	}
}