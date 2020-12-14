package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * 
 * Solution accepted in Leetcode with 94% runtime.
 * 
 * All the four operations are in constant time.
 *  
 * @author gopi_karmakar
 */
public class MinStack {

	private int min = Integer.MAX_VALUE;
			
	private Stack<Integer> stack;
	
	public static void main(String[] args) {
		
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.peek());
		System.out.println(minStack.getMin());
	}
	
	public MinStack() {
		
		stack = new Stack<>();
	}
	
	public void push(int e) {
		
		if(e <= min) {
			
			stack.push(min);
			min = e;
		}
		
		stack.push(e);
	}
	
	public void pop() {
		
		int e = stack.pop();
		
		if(e == min)
			min = stack.pop();
	}
	
	public int peek() {		
		return stack.peek();
	}
	
	public int getMin() {
		return min;
	}
}
