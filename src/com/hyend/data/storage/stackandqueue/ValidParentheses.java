package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string s containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if the 
 * input string is valid. 
 * 
 * @author gopi_karmakar
 */
public class ValidParentheses {

	public static void main(String[] args) {
		
		//String expression = "()[]{}";
		//String expression = "(]";
		//String expression = "([)]";
		String expression = "{[]}";
		
		System.out.println(isValid(expression));
	}
	
	/**
	 * Time complexity is O(n)
	 */
	private static boolean isValid(String expression) {
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : expression.toCharArray()) {
			
			if(c == '(') {
				stack.push(')');
			}
			else if(c == '{') {
				stack.push('}');
			}
			else if(c == '[') {
				stack.push(']');
			}
			else {
				if(stack.isEmpty() || c != stack.pop())
					return false;
			}
		}
		return stack.isEmpty();
	}
}
