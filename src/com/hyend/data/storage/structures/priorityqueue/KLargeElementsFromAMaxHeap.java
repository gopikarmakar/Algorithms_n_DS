package com.hyend.data.storage.structures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find K Large Elements from a max heap without modifying the max heap.
 *  
 * @author gopi_karmakar
 */
public class KLargeElementsFromAMaxHeap {

	public static void main(String[] args) {
		
		Integer[] arr = {561, 314, 401, 28, 156, 359, 271, 11, 3};
		//Imagine this list is a max heap 
		List<Integer> maxHeap = Arrays.asList(arr);
		System.out.println(find(4, maxHeap));
	}
	
	/**
	 * An O(k log k) time complexity solution with extra O(k) space
	 * It doesn't modify the original heap   
	 */
	private static List<Integer> find(int k, List<Integer> maxHeap) {
		
		PriorityQueue<HeapEntry> maxPQ = new PriorityQueue<>(16, Compare.CMP_HEAP);
		maxPQ.add(new HeapEntry(0, maxHeap.get(0)));
		
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < k; ++i) {
			
			int idx = maxPQ.peek().index;
			result.add(maxPQ.remove().value);
			
			int leftChildIdx = 2 * idx + 1;
			if(leftChildIdx < maxHeap.size()) {
				maxPQ.add(new HeapEntry(leftChildIdx, maxHeap.get(leftChildIdx)));
			}
			
			int rightChildIdx = 2 * idx + 2;
			if(rightChildIdx < maxHeap.size()) {
				maxPQ.add(new HeapEntry(rightChildIdx, maxHeap.get(rightChildIdx)));
			}
		}		
		return result;
	}
	
	static class HeapEntry {
		int index;
		int value;
		
		public HeapEntry(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	static class Compare implements Comparator<HeapEntry> {
		
		@Override
		public int compare(HeapEntry e1, HeapEntry e2) {
			return Integer.compare(e2.value, e1.value);
		}
		
		public static final Compare CMP_HEAP = new Compare();
	}
}
