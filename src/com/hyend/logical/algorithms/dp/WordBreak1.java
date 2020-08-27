package com.hyend.logical.algorithms.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * @author gopi_karmakar
 */
public class WordBreak1 {

	public static void main(String[] args) {
		
		String s1 = "catsandog";
		
		String[] words1 = {"cats", "dog", "sand", "and", "cat"};
		
		String s2 = "applepenapple";
			
		String[] words2 = {"apple", "pen"};		
		
		System.out.println(wordBreak(s1, new HashSet<String>(Arrays.asList(words1))));
	}
	
	/**
	 * The time complexity will be somewhere around
	 * O(n-w)*n where w is the length of the dictionary word.
	 */
    public static boolean wordBreak(String s, Set<String> wordDict) {
    	
        int n = s.length();        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++) {
        	
            if(!dp[i-1]) continue;
            
            for(int j = i; j <= n; j++) {
            	
            	String sub = s.substring(i-1, j);
            	
                if(wordDict.contains(sub)){
                
                	dp[j]=true;
                }
            }
            if(dp[n-1]) break;
        }
        return dp[n-1];        
    }
}
