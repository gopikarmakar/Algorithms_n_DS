package com.hyend.logical.algorithms.strings;

/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Google, Facebook, Microsoft Interview Question
 * 
 * Given two binary strings, return their sum (also in a binary string).
 * 
 * @author gopi_karmakar
 */
public class AddTwoBinaryStrings {

	public static void main(String[] args) {
		
		//String s1 = "100";
		//String s2 = "11";
		
		String s1 = "11";
		String s2 = "1";	
		
		System.out.println(add(s1, s2));
	}
	
	/**
	 * Accepted in Leetcode with 2ms 72% runtime
	 */
	private static String add(String s1, String s2) {
		
		int l1 = s1.length()-1;
		int l2 = s2.length()-1;
		
		StringBuilder result = new StringBuilder();
		
		int carry = 0;
		
		while(l1 >= 0 || l2 >= 0) {					
			
			/**
			 *  ASCII Of '0' = 48 and '1' = 49.
			 *  i.e: '0' - '0' = 0 and '1' - '0' = 1
			 *  So it'll just return the numeric value of char.
			 *  
			 *  Another way to do it is:
			 *  Character.getNumericValue(s1.charAt(l1));
			 *  An api to type a char to numeric value;
			 */
			int e1 = (l1 >= 0) ? s1.charAt(l1--) - '0' : 0;
			
			int e2 = (l2 >= 0) ? s2.charAt(l2--) - '0' : 0;
			
			int sum = e1 + e2 + carry;
			
			carry = sum / 2;
			result.append(sum % 2);			
		}
		
		if(carry > 0)
			result.append(carry);
		
		return result.reverse().toString();
	}
}
