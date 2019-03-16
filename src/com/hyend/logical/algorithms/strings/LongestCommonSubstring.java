package com.hyend.logical.algorithms.strings;

public class LongestCommonSubstring {
	
	public int getLCS(String str1, String str2) {
	
		int n1 = str1.length(); 
		int n2 = str2.length();		
		int x = 0, length = 0, maxLength = 0;
		for(int i = 0; i < n1; i++) {			
			x = i;
			for(int j = 0; j < n2 && x < n1; j++) {			
				if(str2.charAt(j) == str1.charAt(x)) {
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
					if(x > 0 && str2.charAt(j) == str1.charAt(x-1))
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
