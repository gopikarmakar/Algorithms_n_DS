package com.hyend.logical.algorithms.dp;

/**
 * Given a string s, partition s such that every substring 
 * of the partition is a Palindrome. Return the minimum cuts 
 * needed for a Palindrome partitioning of s.
 * 
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * @author gopi_karmakar
 */
public class PalindromePartitioningMinCuts {

public static void main(String[] args) {
		
		String s = "aab";
		String s1 = "aabbc";
		String s2 = "abbab";
				
		System.out.println(minSplits1(s2));
		System.out.println(minSplits2(s2));
	}
	
	/**
	 * Solution-1: Worst case time complexity can be O(n^2).
	 * Accepted in Leetcode with the runtime 3ms. 
	 * Faster than the 99.52% of submissions in LeetCode. 
	 * This approach is quite efficient since we start from 
	 * the middle and exit as soon as the substr isn't palindromic, 
	 * So unlike the Solution-2, we don't need to keep traversing the 
	 * same substrings from 0 over and over again and extract the substrings 
	 * each time.	
	 */
	private static int minSplits1(String s) {
		
		int n = s.length();
		int[] dp = new int[n];
		
		/**
		 * Initializing it with dp[i] = i because initially or in the 
		 *  worst case, we would need to cut for each character.
		 */
		for(int i = 0; i < n; i++) {
			dp[i] = i;					
		}
		
		/**
		 * Start with every character and start expanding in the substring from  
		 * the center as far as new characters are equal. We need to do the 
		 * same for the odd and the even length of substrings.
		 */
		for(int i = 0; i < n; i++) {
			findMin(s, dp, i, i);
			findMin(s, dp, i-1, i);	
		}		
		return dp[n-1];
	}
	
	/**
	 * abbab
	 * While expanding:
	 * 1: Since we expand only if our expanded substring is a palindrome,
	 * we do not need to keep extracting a substring from the main string.
	 * 	 
	 * 2: We just need to add the the previous palindromic mincut from our   
	 * current substring starts plus one for the current palindromic substr. 
	 */
	private static void findMin(String s, int[] dp, int start, int end) {
		
		for(; start >= 0 && end < s.length() && 
				s.charAt(start) == s.charAt(end); start--, end++) {
			
			int newCut = (start == 0) ? 0 : dp[start-1] + 1;
			dp[end] = Math.min(newCut, dp[end]);
		}	
	}
	
	/**
	 * Solution-II
	 * A slow runtime of 1179ms. Faster than the 13% of submissions. 
	 */
	private static int minSplits2(String s) {
		
		int n = s.length();		
		int[] dp = new int[n];
		
		for(int i = 0; i < n ; ++i) {
			
			dp[i] = i;
			
			for(int j = 0; j <= i; ++j) {
				
				String sub = s.substring(j, i + 1);
				if(isPalindrome(sub)) {
					
					dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j-1] + 1);
				}				
			}			
		}		
		return dp[n-1];
	}
	
	private static boolean isPalindrome(String s) {
		
		for(int i = 0, j = s.length()-1; i < j; ++i, --j) {
			
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}
