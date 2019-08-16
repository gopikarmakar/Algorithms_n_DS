package com.hyend.data.storage.stackandqueue;

import java.util.List;
import java.util.ArrayList;

/**
 * Implement a Stack which,
 * in addition to push and pop
 * also has a function getMin
 * which returns the minimum element
 * from the stack. Push, Pop and getMin
 * all should operate in O(1) time.
 *  
 * @author karmakargopi
 *
 */
public class StackWithMin {
	
	int index = 0; 
	/**
	 * We're assuming that it's an all positive value stack.
	 */
	int newMin = -1;	
	private List<Integer> stack = new ArrayList<>();
	
	public void push(int val) {
		if(stack.isEmpty()) 
			newMin = val;
		else
			newMin = Math.min(newMin, Math.min(val, this.peek()));
		stack.add(index++, val);
	}
	
	public Integer pop() {		
		return stack.get((index-=1));
	}
	
	public Integer peek() {
		return stack.get(stack.size()-1);
	}
	
	public int getMin() {
		return newMin;
	}
}
