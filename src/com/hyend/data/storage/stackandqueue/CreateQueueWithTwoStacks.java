package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/**
 * A Google Interview Question
 * 
 * Create a queue with two stacks.
 * 
 * Add operation will take O(1) time but will take O(n) time after the remove operation.
 * Remove operation will always take O(n) time.
 * Peek operation will take O(1) time.
 * 
 * @author gopi_karmakar
 */
public class CreateQueueWithTwoStacks<K> {
	
	private Stack<K> s1;
	private Stack<K> s2;
	private K peek = null;
	
	public CreateQueueWithTwoStacks() {
		this.s1 = new Stack<>();
		this.s2 = new Stack<>();
	}
	
	public static void main(String[] args) {
		
		CreateQueueWithTwoStacks<Integer> q = new CreateQueueWithTwoStacks<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add(6);
		q.add(7);
		q.add(8);
		System.out.println("Peek = " + q.peek());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println("Peek = " + q.peek());
		System.out.println(q.remove());
		System.out.println("Peek = " + q.peek());
		System.out.println(q.remove());
		q.add(9);
		System.out.println(q.remove());
		System.out.println("Peek = " + q.peek());
		System.out.println(q.remove());
		//System.out.println("Peek = " + q.peek());
		System.out.println(q.remove());
	}
	
	private void add(K k) {	
		copyToS1();
		s1.push(k);
	}
	
	private K remove() {		
		
		copyToS2();
				
		if(s2.isEmpty())
			throw new AssertionError("Stack is empty");
		
		K k = s2.pop();
		peek = (!s2.isEmpty()) ? s2.peek() : null;
		return k;		
	}
	
	private K peek() {
		
		if(peek == null)
			throw new AssertionError("Stack is empty");
		
		return peek;
	}
	
	private void copyToS2() {
		
		while(!s1.isEmpty()) {
			
			s2.push(s1.pop());
		}
	}
	
	private void copyToS1() {
		
		while(!s2.isEmpty()) {
			
			s1.push(s2.pop());
		}
	}
}
