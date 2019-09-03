package com.hyend.data.storage.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find intersection over two arrays.
 * For e.g: 
 * a[] = {2,3,3,5,5,6,7,7,8,12}
 * b[] = {5,5,6,8,8,9,10,10} 
 * return {5, 6, 8}
 * 
 * @author gopi_karmakar
 */
public class ComputeIntersectionOfTwoSortedArrays {

	public static void main(String[] args) {
		Integer[] a = {2,3,3,5,5,6,7,7,8,12};
		Integer[] b = {5,5,6,8,8,9,10,10};
		//System.out.println(findIntersection(Arrays.asList(a), Arrays.asList(b)));
		System.out.println(findIntersection(a, b));
	}
	
	/**
	 * As long as we iterate over the shorter array  
	 * and binary search for the element over longer array
	 * the time complexity will be O(m log n).
	 * Where n = a.size() and m = b.size()	 
	 */
	private static List<Integer> findIntersection(List<Integer> a, List<Integer> b) {
	
		List<Integer> intersection = new ArrayList<>();
			
		for(int i = 0; i < b.size(); ++i) {
			
			if((i == 0 || b.get(i) != b.get(i-1)) &&
				Collections.binarySearch(a, b.get(i)) >= 0 ) {
				intersection.add(b.get(i));
			}
		}
		return intersection;
	}
	
	/**
	 * An O(n+m) time complexity solution.
	 * Where n = a.size() and m = b.size()
	 */
	private static List<Integer> findIntersection(Integer[] a, Integer[] b) {
		
		List<Integer> intersection = new ArrayList<>();
		
		int i = 0, j = 0;
		
		while(i < a.length && j < b.length) {
			
			if((a[i] == b[j]) && (i == 0 || a[i] != a[i-1])) {				
				intersection.add(a[i]);
				++i;
				++j;
			}
			else if(a[i] < b[j]) 	++i;
			else					++j;
		}
		return intersection;
	}
}
