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
	int maxInRange = 0;
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
	
	public ImmutableStack() {}
	
	public ImmutableStack(int range) {
		this.maxInRange = range;
	}
	
	int offset = 0;
	public void push(int v) {
		//int min = Math.min(element, dq.isEmpty() ? element : getMin());
		int max = Math.max(v, (dq.isEmpty() ? v : getMax()));
		//System.out.println(max);		
		//max = (v > dq.peek())
		dq.push(new Element(v, 0, max));
	}
	
	public int size() {
		return dq.size();
	}
	
	public int pop() {
		if(dq.isEmpty())
			throw new IllegalStateException("pop(): empty stack");
		return dq.removeLast().element;
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
	
	private int setMax(int v) {
		if(dq.isEmpty())
			throw new IllegalStateException("max(): empty stack");
		
		return (v < dq.peek().element) ? dq.peek().max : v;
		//return dq.peek().max;
	}
	
	public List<Integer> getDQList() {
		Iterator<Element> itr = dq.iterator();
		List<Integer> list = new ArrayList<>();
		while(itr.hasNext())
			list.add(itr.next().element);
		return list;
	}
}