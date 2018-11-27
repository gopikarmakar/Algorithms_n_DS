package com.hyend.logical.algorithms.strings;

/**
 * Suppose You have a method isSubstring which checks 
 * if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check 
 * if s2 is a rotation of s1 using only one call to 
 * isSubstring (i.e. “waterbottle” is a rotation of “erbottlewat”)
 * 
 * @author gopi_karmakar
 *
 */
public class IsARotation {

	public boolean isRotation(String s1, String s2) {
		boolean isRotation = false;
		
		int len = s1.length();
		if((len == s2.length()) && len > 0) {			
			String s1s1 = s1 + s1;
			System.out.println(s1s1);
			isRotation = isSubstring(s1s1, s2);			
		}				
		return isRotation;
	}
	
	/**
	 * Fin
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isSubstring(String s1, String s2) {
		boolean isSubstring = false;
		int j = 0;
		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();		
		for(int i = 0; i < ss1.length; i++) {					
			int x = i;
			for(;j < ss2.length;) {					 					
				if(ss2[j++] != ss1[x++]) {
					j = 0;
					break;
				}					
			}
			if(j == ss2.length) {
				isSubstring = true;
				break;
			}											
		}		
		return isSubstring;
	}
}
