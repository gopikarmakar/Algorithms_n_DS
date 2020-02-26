package com.hyend.data.storage.stackandqueue;

import java.util.Stack;

/** 
 * Google and Amazon's interview question
 * 
 * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. 
 * Devise an algorithm to print the minimum number following that pattern. 
 * Number should be between 1-9 digits and the digits can’t repeat.
 * for e.g: 
 * pattern = "I" result = 12
 * pattern = "D" result = 21
 * pattern = "ID" result = 132 // here it can't be 121 since 1 is repeating
 * pattern = "DI" result = 213 // here it can't be 212 since 2 is repeating
 * 
 * @author gopi_karmakar
 */
public class PrintMinNumberOfIDPattern {
	
	public static void main(String[] args) {
		
		System.out.println(printMinNumberForPattern("DI"));
	}

	private static String printMinNumberForPattern(String pattern) {

		String converted = "";
		int len = pattern.length();
		Stack<Integer> stack = new Stack<>();

		for (int x = 0; x <= len; x++) {

			stack.push(x+1);

			if (x == len || pattern.charAt(x) == 'I') {
				
				while (!stack.isEmpty()) {					
					//converted += stack.peek();
					converted += stack.pop();
				}
			}		
		}
		return converted;
	}
}