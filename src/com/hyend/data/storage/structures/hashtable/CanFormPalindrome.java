package com.hyend.data.storage.structures.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		boolean res = sol.canFormPalindrome("geeksogeeks");
		System.out.println("Can it be formed = " + res);
	}
	
	private static class Solution {	
		public boolean canFormPalindrome(String s) {			
			Map<Character, Integer> map = new HashMap<Character, Integer>();			
			for(char c : s.toCharArray()) {				
				if(!map.containsKey(c))
					map.put(c, 1);
				else {
					map.put(c, map.get(c)+1);					
				}
			}			
			int odd = 0;
			for(int x : map.values()) {
				if(x % 2 != 0 && ++odd > 1)
					return false;
			}
			return true;
		}
	}		
}
