package com.hyend.logical.algorithms.strings;

/**
 * Suppose You have a method isSubstring which checks 
 * whether one word is a substring of another or not. 
 * 
 * Given two strings, s1 and s2, write code to check 
 * if s2 is a rotation of s1 using only one call to 
 * isSubstring (i.e. “waterbottle” is a rotation of “erbottlewat”)
 * 
 * @author gopi_karmakar
 *
 */
public class IsARotation {
	
	public static void main(String[] args) {
		
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println("Is It A Rotation = " + isRotation(s1, s2));
	}

	public static boolean isRotation(String s1, String s2) {
		boolean isRotation = false;
		
		int len = s1.length();
		if(len > 0 && (len == s2.length())) {			
			String s1s2 = s1 + s1;
			System.out.println(s1s2);		
			isRotation = s1s2.contains(s2);
		}				
		return isRotation;
	}
}
