package com.hyend.logical.algorithms.strings;

/**
 * Google, Facebook, Microsoft Interview Question
 * 
 * Given two binary strings, return their sum (also in a binary string).
 * 
 * @author gopi_karmakar
 */
public class AddTwoBinaryStrings {

	public static void main(String[] args) {
		
		String s1 = "100";
		String s2 = "11";		
		
		System.out.println(add(s1, s2));
	}
	
	private static String add(String s1, String s2) {
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		
		StringBuilder result = new StringBuilder();
		
		int carry = 0;
		
		while(i >= 0 || j >= 0) {
			
			int sum = carry;
			
			if(i >= 0) {
				
				/**
				 *  ASCII Of '0' = 48 and '1' = 49.
				 *  i.e: '0' - '0' = 0 and '1' - '0' = 1
				 *  So it'll just return the numeric value of char.
				 *  So the below two statements are same.
 				 */
				//int n1 = s1.charAt(i) - '0';				
				sum += Character.getNumericValue(s1.charAt(i));				
			}		
			
			if(j >= 0) {
								
				//int n2 = s2.charAt(j) - '0';							
				sum += Character.getNumericValue(s2.charAt(j));				
			}
						
			carry = sum / 2;
			result.append(sum % 2);
			
			i--;
			j--;
		}
		if(carry > 0)
			result.append(carry);
		
		return result.reverse().toString();
	}
}
