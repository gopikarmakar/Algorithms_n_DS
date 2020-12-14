package com.hyend.logical.algorithms.strings;

/**
 * https://leetcode.com/problems/add-strings/
 * 
 * Given two non-negative integers num1 and num2 
 * represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * @author gopi_karmakar
 */
public class AddTwoStrings {

	public static void main(String[] args) {
		
		String s1 = "1";
		String s2 = "9";
		
		System.out.println(add(s1, s2));
	}
	
	/**
	 * Solution accepted in Leetcode with 2ms 92% runtime
	 */
	private static String add(String s1, String s2) {
		
		StringBuilder result = new StringBuilder();
		
		int l1 = s1.length() - 1;
		int l2 = s2.length() - 1;
		
		int carry = 0;
		while(l1 >= 0 || l2 >= 0) {
			
			int e1 = (l1 >= 0) ? s1.charAt(l1--) - '0' : 0;
			
			int e2 = (l2 >= 0) ? s2.charAt(l2--) - '0' : 0;
			
			int sum = e1 + e2 + carry;
			
			carry = sum / 10;
			result.append(sum % 10);
		}
		
		if(carry > 0)
			result.append(carry);
		
		return result.reverse().toString();
	}
}
