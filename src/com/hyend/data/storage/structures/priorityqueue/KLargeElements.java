package com.hyend.data.storage.structures.priorityqueue;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import com.hyend.data.storage.search.FindKthLargestElement;

/**
 * Find K Large Elements from an unsorted array.
 * 
 * @author gopi_karmakar
 */
public class KLargeElements {

	public static void main(String[] args) {
		
		int[] arr = {5, -1, 7, 2, 4, 3, 9, 8, 1, 10, -2, 6};
		System.out.println(kLargest(4, arr));
		kLarge(4, arr);
	}
	
	/**
	 * An optimal O(n Log K) time complexity solution.
	 * But it uses extra O(K) space since It stores K value in 
	 * a priority queue and doesn't modify the original array.	
	 * 
	 * The sortedness won't be guaranteed for final output.
	 */
	private static Collection<Integer> kLargest(int k, int...arr) {
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>(k); 
		
		for(int x : arr) {	
			
			minPQ.add(x);
			
			if(minPQ.size() > k) 
				minPQ.remove();
		}
		return minPQ;
	}
	
	/**
	 * A more efficient O(n) solution with O(1) extra space.
	 * since It modifies the original array.
	 * It doesn't guarantee the sortedness of final output. 
	 */
	private static void kLarge(int k, int...arr) {
		
		FindKthLargestElement.findKth(k, arr);
				
		for(int x : Arrays.copyOfRange(arr, 0, k)) {
			System.out.println(x);
		}
		
		//List<Integer> result = new ArrayList<>();
		
		/*for(int x : Arrays.copyOfRange(arr, 0, k))
			result.add(x);
		
		return result;*/		
	}
}
