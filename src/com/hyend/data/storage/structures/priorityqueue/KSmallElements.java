package com.hyend.data.storage.structures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
		kSmall(4, arr);
	}
	
	/**
	 * An optimal O(n Log K) time complexity solution.
	 * But it uses extra O(K) space since It stores K value in 
	 * a priority queue and doesn't modify the original array.
	 * 
	 * NOTE: The sortedness won't be guaranteed for final output.
	 */
	private static Collection<Integer> kSmallest(int k, int...arr) {
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(k, Collections.reverseOrder());
		
		for(int x : arr) {
			
			maxPQ.add(x);	
			
			if(maxPQ.size() > k)
				maxPQ.remove();					
		}		
		List<Integer> list = new ArrayList<>(maxPQ);
		Collections.sort(list);
		return list;
	}
	
	/**
	 * An O(n) solution with O(1) extra space
	 * Since it modifies the original array.
	 * 
	 * NOTE: The sortedness won't be guaranteed for final output.
	 */
	private static void kSmall(int k, int...arr) {
		
		FindKthSmallestElement.findKth(k, arr);
		
		for(int x : Arrays.copyOfRange(arr, 0, k)) {
			System.out.println(x);
		}
	}
}
