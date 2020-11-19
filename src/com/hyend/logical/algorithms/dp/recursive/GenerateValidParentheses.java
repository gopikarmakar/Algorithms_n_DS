package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Given a number of pairs. Generate all valid pairs of parentheses.
 * for e.g: numPairs = 2 then valid pair of parens are (()), ()()
 * 
 * @author gopi_karmakar
 */
public class GenerateValidParentheses {

	public static void main(String[] args) {
		
		int numPairs = 3;
		
		List<String> result = new ArrayList<>();
		
		generate(numPairs, numPairs, "", result);
		
		System.out.println(result);
	}
	
	/**
	 * Time complexity will be 2k! / (k! (k+1)!)
	 */
	private static void generate(int leftParens, int rightParens, String prefix, List<String> result) {
		
		if(leftParens == 0 && rightParens == 0) {			
			result.add(prefix);
			return;
		}
		
		if(leftParens > 0) {
			
			generate(leftParens - 1, rightParens, prefix + "(", result);
		}
		
		if(leftParens < rightParens) {
			
			generate(leftParens, rightParens - 1, prefix + ")", result);
		}
		return;
	}
}
