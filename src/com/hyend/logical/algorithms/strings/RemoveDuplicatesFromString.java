package com.hyend.logical.algorithms.strings;


/**
 * Removing the duplicate from string without any additional buffer.
 * Which means replacing the same string after removing the duplicates.
 * 
 * Test cases for this would be
 * 1) String == null
 * 2) String == empty || < 2
 * 3) All characters duplicates "aaaaa"
 * 4) Continuous duplicates "aaaaabbbbb"
 * 5) Non-Contiguous duplicates "abababa"
 * 6) No duplicates "abcde"
 *  
 * 
 * @author gopi_karmakar
 *
 */
public class RemoveDuplicatesFromString {
	
	public void removeDuplicates(char[] str) {
		
		
		if(str == null) return;
		
		int len = str.length;
		if(len < 2) return;
		
		int tail = 1;		
		for(int i = 1; i < len; ++i) {
			int j;
			for(j = 0; j < tail; ++j) {
				if(str[i] == str[j]) break;
			}
			if(j == tail) {
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				System.out.println("tail = " + tail);
				str[tail] = str[i];
				++tail;
			}
		}
		//str[tail] = 0;
		for(int i = 0; i < tail; i++) {
			System.out.print(str[i]);
		}
	}	
}