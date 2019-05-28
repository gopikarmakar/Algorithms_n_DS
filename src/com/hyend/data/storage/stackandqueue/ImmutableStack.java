package com.hyend.data.storage.stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Stack with min and max
 * 
 * @author gopi_karmakar
 */
public final class ImmutableStack {
	private Deque<Element> dq = new LinkedList<Element>();
	class Element {		
		int max;
		int min;
		int element;
		public Element(int element, int min, int max) {
			this.min = min;
			this.max = max;
			this.element = element;
		}
	}
	
	public void push(int element) {
		//int min = Math.min(element, dq.isEmpty() ? element : getMin());
		int max = Math.max(element, dq.isEmpty() ? element : getMax());
		//System.out.println(max);
		dq.push(new Element(element, 0, max));
	}
	
	public int pop() {
		if(dq.isEmpty())
			throw new IllegalStateException("pop(): empty stack");
		return dq.pop().element;
	}
	
	public int getMin() {
		if(dq.isEmpty())
			throw new IllegalStateException("min(): empty stack");
		return dq.peek().min;
	}
	
	public int getMax() {
		if(dq.isEmpty())
			throw new IllegalStateException("max(): empty stack");
		return dq.peek().max;
	}
	
	public List<Integer> getDQList() {
		Iterator<Element> itr = dq.iterator();
		List<Integer> list = new ArrayList<>();
		while(itr.hasNext())
			list.add(itr.next().element);
		return list;
	}
}