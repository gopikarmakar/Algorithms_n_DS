package com.hyend.data.storage.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.EmptyStackException;

/**
 * A data structure which performs all the O(1) functionalities of stack
 * like : push, pop, peek, max, size and isEmpty
 * 
 * @author gopi_karmakar
 */
public class StackWithMax<K extends Comparable<K>> {		
	
	int size = 0;
	private Deque<K> stack = new LinkedList<>();
	private Deque<Element<K>> cachedMaxWithCount = new LinkedList<>();
	
	public StackWithMax() {}
	
	// Adds an element to stack
	public void push(K element) {	
		
		size+=1;
		stack.addFirst(element);
		
		if(!cachedMaxWithCount.isEmpty()) {		
			
			if(element.compareTo(getMax()) == 0) {
				cachedMaxWithCount.peekFirst().count += 1;
			}
			else {				
				addToCache(validateMax(element));				
			}
		}
		else {
			addToCache(element);
		}
	}
	
	// Pops from stack
	public K pop() {		
		
		validateEmptiness();
		
		size-=1;
		K element = stack.removeFirst();
		
		if(element.equals(getMax())) {
			cachedMaxWithCount.peekFirst().count -= 1;
			
			if(cachedMaxWithCount.peekFirst().count == 0)
				cachedMaxWithCount.removeFirst();
		}		
		return element;
	}
	
	// Removes from queue
	public K remove() {		
		validateEmptiness();		
		return stack.removeFirst();
	}
	
	public K peek() {
		validateEmptiness();		
		return stack.peekFirst();
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	// Gets max from stack
	public K getMax() {
		validateEmptiness();
		return cachedMaxWithCount.peekFirst().max;
	}
	
	// Gets max from stack
	public K popMax() {
		validateEmptiness();
		return cachedMaxWithCount.removeFirst().max;
	}
		
	private void addToCache(K element) {
		
		Element<K> e = new Element<>(1);
		e.max = element;		
		cachedMaxWithCount.addFirst(e);	
	}
	
	private void validateEmptiness() {
		if(isEmpty()) throw new EmptyStackException();
	}
	
	private K validateMax(K element) {	
		return (element.compareTo(getMax()) > 0) ? element : getMax();				
	}
}