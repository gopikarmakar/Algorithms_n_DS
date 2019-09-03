package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
		
	private final String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Permutations() {
		
	}
	
	public void stringPermutations(int limit) {
		String elements = alphabets.substring(0, limit);		
		stringPermutations("", elements);
	}
	
	/**
	 * Ordered Permutations of all Characters in a String.
	 * @param prefix
	 * @param str
	 * 
	 * ""  abc
	 * 
	 * 
	 */
	private void stringPermutations(String prefix, String str) {
		int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; ++i) {
            	String s1 = str.substring(0, i);
            	//System.out.println("s1 = " + s1);            	
            	String s2 = str.substring(i+1, n);
            	//System.out.println("s2 = " + s2);
            	stringPermutations(prefix + str.charAt(i), s1 + s2);
            }
        }
	}
	
	/**
	 * Count of strings that can be formed using a, b and c under given constraints:
	 * Given a length n, count the number of strings of length n that can be made using
	 * ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
	 * @param n
	 * @param b_count
	 * @param c_count
	 * @param s
	 * @return
	 */
	public int stringPermutations(int n, int b_count, int c_count, String s) {
		if(n == 0) {
			System.out.println(s);
			return 1;
		}
		int total = 0;
		total += stringPermutations(n-1, b_count, c_count, s + 'a');
		if(b_count > 0)
			stringPermutations(n-1, b_count-1, c_count, s + 'b');
		if(c_count > 0)
			stringPermutations(n-1, b_count, c_count-1, s + 'c');
		
		return total;
	}
		
	public int anagramStringPermutations(String str) {
		String[] vow = {"A", "E", "I", "O", "U"};
		Set<String> vowels = new HashSet<>();		
		for(String s : vow)
			vowels.add(s);
		
		List<String> list = new ArrayList<>();
		
		return anagramPermutations("", str, vowels, list);
	}
        
	/**
	 * An Memoized Solution
	 * A perfect anagram word is a word when
	 * 1: A word should not start with any vowel
	 * 2: Two vowels can't be next to each other
	 *  
	 * Print all the perfect anagram word permutations.	
	 */
	int count = 0;
    private int anagramPermutations(String prefix, String str, Set<String> vowels, List<String> list) {
		
    	if(list.contains(prefix))
    		return count;
    	
    	int n = str.length();
        if (n == 0) {        	
        	for(int i = 0; i < prefix.length()-1; i++) {
        		if(!vowels.contains(""+prefix.charAt(i)) && vowels.contains(""+prefix.charAt(i+1)))
        			i+=1;
        		else return count;			
    		}
        	count+=1;
        	list.add(prefix);
        	System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; ++i)
            	anagramPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), vowels, list);
        }
        return count;
	}
}