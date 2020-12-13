package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * @author gopi_karmakar
 */
public class DailyTemperatures {

	public static void main(String[] args) {
		
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		//int[] T = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
		
		for(int t : dailyTemperatures(T)) {
			System.out.println(t);
		}
	}
	
	/**
	 * Accepted in Leetcode with 91.68% less memory usage
	 */
	private static int[] dailyTemperatures(int[] T) {
		
		int[] result = new int[T.length];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = T.length-1; i >= 0; i--) {
			
			while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			
			result[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
			
			stack.push(i);
		}
		return result;
	}
}
