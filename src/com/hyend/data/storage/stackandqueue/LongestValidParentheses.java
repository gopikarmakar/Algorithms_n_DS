package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/**
 * Return the total count of valid parentheses
 * for e.g: ")()())" there're 4 valid parens in that expression 
 * 
 * @author gopi_karmakar
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		
		String expression = "()(()";
		System.out.println(calculate(expression));
	}
	
	/**
	 * Time complexity is O(n)
	 */
	private static int calculate(String expression) {
		
		int count = 0;
		Stack<Character> stack = new Stack<>();
		
		for(char c : expression.toCharArray()) {
			
			if(c == '(') {
				
				stack.push(c);
			}										
			else {
				
				if(c == ')' && !stack.isEmpty()) {
					
					stack.pop();
					
					count += 2;
				}
			}
		}
		return count;
	}
}
