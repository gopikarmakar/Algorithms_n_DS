package com.hyend.logical.algorithms.dp.recursive;

import java.util.Arrays;

/**
 * Find longest sub sequence between two strings
 * For e.g: s1 = "AGGTAB"  s2 = "GXTXAYB"
 * lss = "GTAB" length = 4;
 * 
 * @author gopi_karmakar
 */
public class LongestSubSequence {

	public static void main(String[] args) {
		
		//String a = "AGGTAB";
		String a = "aabcc";
		int a_Idx = a.length();
		
		//String b = "GXTXAYB";
		String b = "aadbbcbcac";
		int b_idx = b.length();
		
		int[][] cache = new int[a_Idx][b_idx];
		
		/*for(int[] c : cache) {
			
			Arrays.fill(c, -1);
		}*/
		
		int result = lss(a, a_Idx - 1, b, b_idx - 1, cache);
		
		for(int[] c : cache) {
			
			for(int d : c) {
			
				System.out.print(d + " ");
			}
			System.out.println();
		}
		
		System.out.println(result);
	}
	
	/**
	 * Both Time and space complexity is O(n * m)
	 */
	private static int lss(String a, int a_Idx, String b, int b_Idx, int[][] cache) {
		
		if(a_Idx < 0 || b_Idx < 0) 
			return 0;
		
		if(cache[a_Idx][b_Idx] == 0) {
			
			if(a.charAt(a_Idx) == b.charAt(b_Idx)) {
				
				cache[a_Idx][b_Idx] = 1 + lss(a, a_Idx - 1, b, b_Idx - 1, cache);
			}
			else {
				
				int A = lss(a, a_Idx - 1, b, b_Idx, cache);
				
				int B = lss(a, a_Idx, b, b_Idx - 1, cache);
				
				cache[a_Idx][b_Idx] = Math.max(A, B);
			}
		}
		return cache[a_Idx][b_Idx];
	}
}
