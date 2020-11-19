package com.hyend.data.storage.structures.priorityqueue;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

/**
 * Implement a stack using heap
 * @author gopi_karmakar
 */
public class ImplementStackUsingHeap {

	public static void main(String[] args) {
		
		HeapStack<Integer> heapStack = new HeapStack<>();
		heapStack.push(5);
		heapStack.push(3);
		heapStack.push(7);
		System.out.println(heapStack.pop());
		System.out.println(heapStack.pop());
		heapStack.push(6);
		heapStack.push(4);
		System.out.println(heapStack.pop());
		System.out.println(heapStack.pop());
		System.out.println(heapStack.peek());
		heapStack.push(7);
		System.out.println(heapStack.pop());
		System.out.println(heapStack.pop());
		System.out.println(heapStack.peek());
	}
	
	/**
	 * Time complexity for push and pop is that of adding and 
	 * extracting-max from a max-heap i.e O(log n)
	 * where n is the current number of elements.
	 */
	private static class HeapStack<K> {
		
		//PriorityQueue<Entry<K>> maxPQ = new PriorityQueue<>(16, Compare.CMP_ENTRY);
		PriorityQueue<Entry<K>> maxPQ = new PriorityQueue<>(16, (a, b) -> b.timeStamp - a.timeStamp);
		
		int timeStamp = 0;
		
		public void push(K k) {
			maxPQ.add(new Entry<K>(k, ++timeStamp));
		}
		
		public K pop() {
			if(maxPQ.isEmpty()) 
				throw new EmptyStackException();			
			return maxPQ.remove().k;
		}
		
		public K peek() {
			if(maxPQ.isEmpty()) 
				throw new EmptyStackException();
			return maxPQ.peek().k;
		}
	}
	
	private static class Entry<K> {	
		K k;
		int timeStamp;		
		public Entry(K k, int timeStamp) {
			this.k = k;
			this.timeStamp = timeStamp;
		}
	}
	
	/**
	 * Reverse order comparator
	 */
	private static class Compare implements Comparator<Entry<?>> {		
		@Override
		public int compare(Entry<?> e1, Entry<?> e2) {
			return Integer.compare(e2.timeStamp, e1.timeStamp);
		}		
		public static final Compare CMP_ENTRY = new Compare();
	}
}