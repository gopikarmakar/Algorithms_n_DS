package com.hyend.data.storage.structures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author gopi_karmakar
 */
public class FindLongestConsecutiveSequence {

	public static void main(String[] args) {
		
		//int[] arr = {100, 4, 200, 1, 3, 2};
		int[] arr = {-1, 0};
		System.out.println(find(arr));
	}
	
	/**
	 * O(n) time complexity
	 */
	private static int find(int[] arr) {
		
		int maxLength = 1;
		
		Set<Integer> set = new HashSet<>();
		
		for(int x : arr)
			set.add(x);
		
		for(int e : set) {
			
			int count = 0;
			
			if(set.contains(e - 1)) continue;
			
			while(set.contains(e)) {
				count++;
				e++;
			}
			maxLength = Math.max(maxLength, count);
		}		
		return maxLength;
	}
}
