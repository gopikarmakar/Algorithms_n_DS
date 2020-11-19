package com.hyend.data.storage.structures.priorityqueue;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Sort a K-increasing-decreasing array. 
 *  
 * @author gopi_karmakar
 */
public class SortAnIncreasingDecreasingArray {

	public static void main(String[] args) {
		
		Integer[] arr = {57, 131, 493, 294, 221, 339, 418, 452, 442, 190};
		System.out.println(sort(Arrays.asList(arr)));
	}
	
	private static enum SubArrayType {		
		INCREASING,
		DECREASING;
	}
	
	/**
	 * The fetching of increasing & decreasing SubArray takes O(n) and 
	 * reversing the decreasing SubArray takes O(n), in total fetching
	 * of SubArrays roughly takes O(n^2)
	 * 
	 * Time taken to merge sorted SubArrays is O(n log k) and that's the
	 * total time complexity for the solution.
	 */
	private static List<Integer> sort(List<Integer> list) {
		
		int subIdx = 0;
		List<List<Integer>> lists = new ArrayList<>();		
		SubArrayType subArrayType = SubArrayType.INCREASING;
		
		for(int i = 1; i <= list.size(); ++i) {
			
			if(i == list.size() || 
				(list.get(i-1) < list.get(i) && subArrayType == SubArrayType.DECREASING) ||
				(list.get(i-1) >= list.get(i) && subArrayType == SubArrayType.INCREASING)) {
				
				List<Integer> subList = list.subList(subIdx, i);
				
				if(subArrayType == SubArrayType.DECREASING)
					Collections.reverse(subList);
				
				lists.add(subList);
				
				subIdx = i;
				subArrayType = (subArrayType == SubArrayType.INCREASING) ? 
								SubArrayType.DECREASING : SubArrayType.INCREASING;
			}
		}		
		return new MergeKSortedArrays<Integer>().mergeKSortedLists(lists);
	}		
}