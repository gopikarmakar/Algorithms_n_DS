package com.hyend.logical.algorithms.recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
		
	private final String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Permutations() {}
	
	public void stringPermutations(int limit) {
		String elements = alphabets.substring(0, limit);		
		stringPermutations("", elements);
	}
	
	/**
	 * Ordered Permutations of all Characters in a String.
	 * @param prefix
	 * @param str
	 */
	private void stringPermutations(String prefix, String str) {
		int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; ++i)
            	stringPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
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
		return anagramPermutations("", str);
	}
        
	/**
	 * A perfect anagram word is a word when
	 * 1: A word should not start with any vowel
	 * 2: Two vowels can't be next to each other
	 *  
	 * Print all the perfect anagram word permutations.	 
	 */
	int count = 0;	
	ArrayList<String> list = new ArrayList<>();
    private int anagramPermutations(String prefix, String str) {
		
    	if(list.contains(str))
    		return count;
    	
    	int n = str.length();
        if (n == 0) {        	
        	if(!list.contains(prefix)) {
	        	for(int i = 0; i < prefix.length()-1; i++) {        		
	        		if(!isVowel(prefix.charAt(i)) && isVowel(prefix.charAt(i+1)))
	        			i+=1;
	        		else return count;			
	    		}
	        	count+=1;
	        	list.add(prefix);
	        	System.out.println(prefix);	        	
        	}
        }
        else {
            for (int i = 0; i < n; ++i)
            	anagramPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
        return count;
	}
    
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private boolean isVowel(char c) {
    	
    	boolean status = false;
    	for(char ch : vowels) {
    		if(c == ch) {
    			status = true;
    			break;
    		}
    	}
    	return status;
    }
    
    /**
     * 
     * @param keys
     */
    public void numberPermutations(List<Integer> keys) {
    	List<List<Integer>> uPermsList = new ArrayList<>();
		int n = keys.size();
		int[] arr = new int[n];
		for(int x = 0; x < n; x++) {
			arr[x] = keys.get(x);
			//uPermsList.add(new ArrayList<Integer>());	
		}		
		numberPermutations(uPermsList, arr, n);
		for(List<Integer> list : uPermsList) {
			for(int e : list) {
				System.out.print(e+", ");
			}
			System.out.println("");
		}
    }
	
	/**
	 * Unordered Permutations of all Digits in a Number.
	 * Google interview question, Unique Permutations implementation is still pending.
	 * 
	 * @param uniquePerms
	 * @param keys
	 * @param n
	 */
	private void numberPermutations(List<List<Integer>> uniquePerms, int[] keys, int n) {			
		if(n == 1) {
			List<Integer> list = new ArrayList<>();
			for(int x : keys)
				list.add(x);			
			uniquePerms.add(list);
			return;
		}
		else {		
			for(int i = 0; i < n; i++) {
				swap(keys, i, n-1);	
				numberPermutations(uniquePerms, keys, n-1);											
				swap(keys, i, n-1);
			}
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}