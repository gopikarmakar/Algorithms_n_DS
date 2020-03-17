package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		
		String s1 = "catsanddog";
		
		String[] words1 = {"cats", "dog", "sand", "and", "cat"};
		
		String s2 = "applepenapple";
			
		String[] words2 = {"apple", "pen"};		
		
		System.out.println(wordBreak(s1, new ArrayList<String>(Arrays.asList(words1))));
	}
	
    public static boolean wordBreak(String s, List<String> wordDict) {
    	
        int n = s.length();        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++) {
        	
            if(!dp[i-1]) continue;
            
            for(int j = i; j <= n; j++) {
            	
                if(wordDict.contains(s.substring(i-1,j))){
                
                	dp[j]=true;
                }
            }
            if(dp[n]) break;
        }
        return dp[n];        
    }
}
