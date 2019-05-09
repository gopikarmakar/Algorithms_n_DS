package com.hyend.logical.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Wovn's coding test challenge.
 * 
 * @author gopi_karmakar
 */
public class MatchNamesParity {
	
	public List<Integer> prefix(List<String> inputs) {		
		List<Integer> list = new ArrayList<>();
		List<Integer> total = new ArrayList<>();		
		for(String str : inputs) {
			for(int i = 0; i < str.length(); i++) {
				list.add(match(str, str.substring(i, str.length())));					
			}
			total.add(total(list));
		}		
		return total;
	}
	
	private int match(String str, String sub) {
		int x = 0;
		for(int i = 0; i < sub.length(); i++) {
			if(sub.charAt(i) != str.charAt(i)) return x;		
			x+=1;
		}
		return x;
	}
	
	private int total(List<Integer> list) {		
		int res = 0;		
		for(int x : list) {
			res += x;
		}
		return res;
	}
}
