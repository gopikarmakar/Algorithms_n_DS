package com.hyend.logical.algorithms.recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
		
	private final String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Permutations() {}

	public Permutations(int limit) {
		String elements = alphabets.substring(0, limit);
		//System.out.print(elements);
		stringPermutations("", elements);
	}
	
	public Permutations(List<Integer> keys) {
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
	 * Count of strings that can be formed using a, b and c under given constraints:
	 * Given a length n, count the number of strings of length n that can be made using
	 * ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
	 * @param n
	 * @param b_count
	 * @param c_count
	 * @param s
	 * @return
	 */
	public int totalPemutations(int n, int b_count, int c_count, String s) {
		if(n == 0) {
			System.out.println(s);
			return 1;
		}
		int total = 0;
		total += totalPemutations(n-1, b_count, c_count, s + 'a');
		if(b_count > 0)
			totalPemutations(n-1, b_count-1, c_count, s + 'b');
		if(c_count > 0)
			totalPemutations(n-1, b_count, c_count-1, s + 'c');
		
		return total;
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
	 * Unordered Permutations of all Digits in a Number.
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
