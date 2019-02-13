package com.hyend.logical.algorithms.strings;

import java.util.Arrays;

public class ZigZagConversion {
	
	public String convert(String s, int numRows) {
		
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
