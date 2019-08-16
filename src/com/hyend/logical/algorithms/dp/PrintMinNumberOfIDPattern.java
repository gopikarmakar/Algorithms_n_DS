package com.hyend.logical.algorithms.dp;

import java.util.Stack;

/** 
 * 
 * Google and Amazon's telephonic interview question
 * 
 * Given a pattern containing only I’s and D’s. 
 * I for increasing and D for decreasing. 
 * Devise an algorithm to print the minimum number 
 * following that pattern. 
 * should be between 1-9 digits and the digits can’t repeat
 * 
 * @author gopi_karmakar
 *
 */
public class PrintMinNumberOfIDPattern {

	public String printMinNumberForPattern(String pattern) {

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