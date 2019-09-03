package com.hyend.data.storage.structures.priorityqueue;

import java.util.Arrays;
import java.util.Collections;

import java.util.PriorityQueue;

/**
 * Not so efficient solutions since it uses extra space.
 * An O(n log n) solution with O(m+n) extra space.
 * 
 * The most efficient solution will be in place binary search.  
 *
 * @author gopi_karmakar
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		
		int[] arr1 = {1,3,5,9,10,11,16};
		int[] arr2 = {2,4,6,8,15};
		
		int n1 = arr1.length, n2 = arr2.length;
				
		if(n2 < n1) {			
			int temp = n1;
			n1 = n2;
			n2 = temp;			
		}
		
		int i;
		for(i = 0; i < n1; i++) {
			add(arr1[i]);
			add(arr2[i]);
		}
		
		int[] left;
		if(i == arr1.length)
			left = Arrays.copyOfRange(arr1, i, arr2.length);
		else 
			left = Arrays.copyOfRange(arr1, i, arr1.length);
		
		for(i = 0; i < left.length; i++)
			add(left[i]);
		
		System.out.println(getMedian());
	}	
	
	private static PriorityQueue<Integer> minPQ = new PriorityQueue<>();
	private static PriorityQueue<Integer> maxPQ = new PriorityQueue<>(16, Collections.reverseOrder());
	
	private static void add(int x) {
		
		if(minPQ.isEmpty()) {
			minPQ.add(x);			
		}
		else {
			if(x >= minPQ.peek()) {				
				minPQ.add(x);
			}
			else 
				maxPQ.add(x);
		}
		
		if(minPQ.size() > maxPQ.size()+1) {
			maxPQ.add(minPQ.remove());
		}
		else if(maxPQ.size() > minPQ.size())
			minPQ.add(maxPQ.remove());			
	}
	
	private static double getMedian() {	
		
		System.out.println(minPQ);
		System.out.println(maxPQ);
		
		return (minPQ.size() == maxPQ.size()) ? (minPQ.peek() + maxPQ.peek()) * 0.5 : minPQ.peek();
	}
}
	
