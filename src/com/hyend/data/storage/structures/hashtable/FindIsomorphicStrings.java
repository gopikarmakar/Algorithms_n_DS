package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An amazon interview question
 * 
 * Group isomorphic strings together. Two strings are called isomorphic 
 * if each character in both strings can be mapped to each other.
 * 
 * for e.g:  
 * consider the strings "ACAB" and "XCXY" are isomorphic as we can map
 * A->X C->C B->Y (here A maps with X twice) 
 * 
 * "PAPER" and "TITLE" are isomorphic since we can map
 * P->T A->I E->L R->E (here P maps with T twice)
 * 
 * "EGG" and "ADD" are isomorphic since 
 * G and D can be mapped twice.
 *  
 * but "FOO" and "BAR" are not isomorphic since
 * O can be mapped twice unlike any letter in BAR. 
 * 
 * @author gopi_karmakar
 */
public class FindIsomorphicStrings {
	
	public static void main(String[] args) {
		
		//String[] input = {"foo", "paper", "egg", "bar", "title", "add"};
		String[] input = {"banana", "paper", "egg", "foo", "apple", "cat", 
						  "apply", "bat", "add", "title", "bar"};
		
		findIsomorphic(input).forEach(e -> {
			
			e.forEach(x -> {
				
				System.out.print(x + " ");
			});
			System.out.println();
		});
	}

	/**
	 * O(n * l) time complexity where n = number of string and l = longest length.
	 */
	private static Collection<List<String>> findIsomorphic(String...input) {				
		
		Map<String, List<String>> map = new HashMap<>();
		
		if(input.length == 0) return null;
		
		for(String s : input) {
						
			String hashed = hash(s);
			System.out.println("String = " + s + " and hashedString = " + hashed);
			
			List<String> list = map.getOrDefault(hashed, new ArrayList<String>());
			list.add(s);			
			map.put(hashed, list);
		}
		
		return map.values();
	}
	
	private static String hash(String s) {
					
		String hashed = "";
		
		if(s == null || s.isEmpty()) return hashed;
			
		Map<Character, Integer> map = new HashMap<>();		
		
		int count = 1;		
		for(char c : s.toCharArray()) {
						
			if(!map.containsKey(c))
				map.put(c, count++);
			
			//# is To differentiate between cases like: 12 and 12(1 and 2) 			
			hashed += map.get(c) + "#";
		}		
		return hashed;
	}	
}
