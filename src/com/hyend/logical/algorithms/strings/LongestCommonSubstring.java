package com.hyend.logical.algorithms.strings;

/**
 * @author gopi_karmakar
 */
public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		
		// Longest Common Substring is 'eeksfor' of len 7
		String s1 = "geeksforskeeg";
		String s2 = "skeeggggeeeeksfor";
		
		System.out.println(getLCS(s1, s2));
	}
	
	public static int getLCS(String s1, String s2) {
	
		int n1 = s1.length(); 
		int n2 = s2.length();		
		int x = 0, length = 0, maxLength = 0;
		
		for(int i = 0; i < n1; i++) {			
			x = i;
			for(int j = 0; j < n2 && x < n1; j++) {	
				
				if(s2.charAt(j) == s1.charAt(x)) {
					x++;
					length += 1;					
				}
				else {					
					if(length > maxLength)	
						maxLength = length;
					/**
					 * Taking care this case:
					 * str1 = geeksforskeeg
					 * str2 = skeeggggeeksfor
					 */
					if(x > 0 && s2.charAt(j) == s1.charAt(x-1))
						length = 1;
					else length = 0;
					i = x;
				}
			}
			/**
			 * Taking care this case:
			 * str1 = g
			 * str2 = ge			 
			 */ 
			if(length > maxLength)	
				maxLength = length;
		}		
		return maxLength;
	}
}
