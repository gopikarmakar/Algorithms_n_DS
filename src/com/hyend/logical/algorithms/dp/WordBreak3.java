package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Google On Site Interview Question
 * 
 * Given a word s without spaces and a dictionary dict, 
 * you have to find a way to split the word in such a way that,
 * 1) The number of splits should be the minimum
 * 2) It should contain all the dictionary words / letters.
 * If there're multiple solutions, return any of them.
 * 
 * For e.g: s = "bedbathandbeyond", dict = ["bed", "bath", "bat", "and", "hand", "beyond"]
 * output = ["bed", "bath", "and", "beyond"] or ["bed", "bat", "hand", "beyond"]
 * 
 * Here we can see how the above example uses all the dictionary words:
 * Output-1 doesn't contains "hand" separately but "bath" contains "h" within. 
 * Output-2 doesn't contains "and" separately but "hand" contains "and" within.
 * 
 * https://leetcode.com/discuss/interview-question/385870/Google-or-Onsite-or-Word-Break-III/347600
 * 
 * @author gopi_karmakar
 */
public class WordBreak3 {

	public static void main(String[] args) {
		
		String s = "bedbathandbeyond";
		String[] dict = {"bed", "bath", "and", "bat", "hand", "beyond"};
		
		System.out.println(wordBreak(s, new HashSet<>(Arrays.asList(dict))));
		System.out.println(decompose(s, new HashSet<>(Arrays.asList(dict))));
	}
	
	/**
	 * Let n be the length of the input string s. 
	 * For each k < n we check for each j < k whether the 
	 * substring s[j + 1 : k] is a dictionary word, and each such check 
	 * requires O(k - j) time. This implies the time complexity is O(n^3). 
	 */
	private static List<String> wordBreak(String s, Set<String> dict) {
		
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		
		for(int i = 0; i < s.length(); ++i) {
			
			String sub = s.substring(0, i+1);
			if(dict.contains(sub))
				dp[i] = i + 1;		
		
			if(dp[i] == -1) {
				
				for(int j = 0; j < i; ++j) {
			
					String sub2 = s.substring(j+1, i+1);
					if(dp[j] != -1 && dict.contains(sub2)) {
						dp[i] = i - j;
						break;
					}
				}
			}		
		}
		
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
	
	private static List<String> decompose(String s, Set<String> dict) {
		
		int n = s.length();
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for(int i = 1; i <=n; i++) {
			
			if(dp[i-1] == -1) continue;
			
			for(int j = i; j <= n; j++) {
				
				String sub = s.substring(i-1, j);
				
				if(dict.contains(sub)) {
					
					dp[j] = j - i + 1;
				}
			}			
			if(dp[n] != -1) break;				
		}
		
		dp[0] = -1;
		List<String> decompositions = new ArrayList<>();
		
		if(dp[dp.length - 1] != -1) {
			int idx = s.length();
			
			while(idx > 0) {
				
				String sub3 = s.substring(idx - dp[idx], idx);
				decompositions.add(sub3);
				idx -= dp[idx];
			}
			Collections.reverse(decompositions);
		}		
		return decompositions;		
	}
}
