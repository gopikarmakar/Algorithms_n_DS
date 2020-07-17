package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * @author gopi_karmakar
 */
public class MinCutsToPalindromicDecomposition {

	public static void main(String[] args) {
		
		String s = "aab";
		String s2 = "aabbc";
		System.out.println(partition(s));
	}
	
	private static List<String> partition(String s) {
		
		int n = s.length();		
		int[] dp = new int[n];
		Arrays.fill(dp, -1);		
		
		for(int i = 0; i < n; ++i) {
			String sub = s.substring(0, i + 1);
			if(isPalindrome(sub))
				dp[i] = i + 1;
			
			if(dp[i] == -1) {
				
				for(int j = 0; j < i; ++j) {
					
					String sub2 = s.substring(j+1, i+1);
					if(dp[j] != -1 && isPalindrome(sub2)) {
						dp[i] = i - j;
						break;
					}
				}
			}
		}
		return fetchDecompositions(dp, s);
	}
	
	private static List<String> fetchDecompositions(int[] dp, String s) {
		
		List<String> decompositions = new ArrayList<>();
		
		if(dp[dp.length - 1] != -1) {
			int idx = s.length()-1;
			
			while(idx >= 0) {
				
				String sub3 = s.substring(idx + 1 - dp[idx], idx + 1);
				decompositions.add(sub3);
				idx -= dp[idx];
			}
			Collections.reverse(decompositions);
		}
		return decompositions;
	}
	
	private static boolean isPalindrome(String s) {
		
		for(int i = 0, j = s.length()-1; i < j; ++i, --j) {
			
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
