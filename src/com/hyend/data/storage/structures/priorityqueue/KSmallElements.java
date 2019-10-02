package com.hyend.data.storage.structures.priorityqueue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import com.hyend.data.storage.search.FindKthSmallestElement;

/**
 * Find the K smallest elements from an unsorted array.  
 * @author gopi_karmakar
 */
public class KSmallElements {

	public static void main(String[] args) {
		
		int[] arr = {5, -1, 7, 2, 4, 3, 9, 8, 1, 10, -2, 6};
		System.out.println(kSmallest(4, arr));
		//System.out.println(kSmall(4, arr));
	}
	
	/**
	 * An O(n Log k) solution with extra O(k) space
	 * since, It doesn't change the original array.
	 * Max priority queue never guarantees sortedness. 
	 */
	private static Collection<Integer> kSmallest(int k, int...arr) {
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(k, Collections.reverseOrder());
		
		for(int x : arr) {
			
			maxPQ.add(x);	
			
			if(maxPQ.size() > k)
				maxPQ.remove();					
		}		
		return maxPQ;
	}
	
	/**
	 * An O(n) solution with O(1) extra space
	 * Since it modifies the original array.
	 * It doesn't guarantee the sortedness of final output.
	 */
	private static void kSmall(int k, int...arr) {
		
		FindKthSmallestElement.findKth(k, arr);
		
		for(int x : Arrays.copyOfRange(arr, 0, k)) {
			System.out.println(x);
		}
	}
}
