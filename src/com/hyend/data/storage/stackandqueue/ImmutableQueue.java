package com.hyend.data.storage.stackandqueue;

import java.util.List;
import java.util.Deque;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Queue with min and max
 * 
 * @author gopi_karmakar 
 */
public class ImmutableQueue {

	private Deque<Element> dq = new LinkedList<>();	
	class Element {
		int min;
		int max;
		int element;		
		public Element(int element, int min, int max) {
			this.min = min;
			this.max = max;
			this.element = element;
		}
	}
	
	/**
	 * Input arr[] : {1, 2, 3, 1, 4, 5, 2, 3, 6}
	 * 				 {1, 3, -1, -3, 5, 3, 6, 7};
	 */
	public void enqueue(int element) {
		int max = Math.max(element, isEmpty() ? element : getMax());
		//int totalMax = Math.max(max, isEmpty() ? element : getMax());
		dq.add(new Element(element, 0, max));
	}

	public int dequeue() {
		if(isEmpty())
			throw new IllegalStateException("remove(): empty queue");
		return dq.remove().element;
	}	
	
	public int getMax() {
		if(isEmpty())
			throw new IllegalStateException("max(): empty queue");
		return dq.peekLast().max;
	}
	
	public int getElement() {
		if(isEmpty())
			throw new IllegalStateException("getElement(): empty queue");
		return dq.peekLast().element;
	}
	
	public boolean isEmpty() {
		return dq.isEmpty();
	}
	
	public List<Integer> getDQList() {
		Iterator<Element> itr = dq.iterator();
		List<Integer> list = new ArrayList<>();
		while(itr.hasNext())
			list.add(itr.next().element);
		return list;
	}
}
