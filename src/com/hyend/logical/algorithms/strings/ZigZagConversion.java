package com.hyend.logical.algorithms.strings;

import java.util.Arrays;

/**
 * Print the Sinusoidally (Snake/ZigZag) string of the given string under given rows. 
 * 
 * For e.g: "ZigZag conversion of "PAYPALISHIRING" = "PINALSIGYAHRPI" in 4 rows
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * ZigZag conversion of "PAYPALISHIRING" = "PAHNAPLSIIGYIR" in 3 rows
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * @author gopi_karmakar
 */
public class ZigZagConversion {
		
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));		
	}
	
	/**
	 * O(n) time complexity solution with,
	 * O(n) extra space 
	 */
	private static String convert(String s, int numRows) {
		
		if(s == null || s.length() == 1 || numRows <= 1) return s;		
		
		int len = s.length();
		String[] chunks = new String[numRows];
		Arrays.fill(chunks, "");

		int rows = 0;
		Boolean down = true;
		for(int x = 0; x < len; x++) {
			
			chunks[rows] += s.charAt(x);
			
			if(rows == numRows-1) down = false;	
			else if(rows == 0) down = true;
			
			if(down) rows+=1;
			else  rows-=1;
		}
			
		String zigzag = "";
		for(String str : chunks)
			zigzag += str;
			
		return zigzag;		
    }
}
