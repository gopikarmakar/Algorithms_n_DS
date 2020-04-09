package com.hyend.logical.algorithms.dp;

/**
 * Compute Levenshtein distance between two Strings.
 * 
 * https://leetcode.com/problems/k-similar-strings/
 *  
 * @author gopi_karmakar
 */
public class LevenshteinDistance {

	public static void main(String[] args) {
		
		// Consider case sensitivity as one action too.
		//String a = "Carthorse";
		//String b = "Orchestra";
		
		String a = "AABC";
		String b = "ABCA";
		
		
		int a_Idx = a.length();
		int b_Idx = b.length();
		
		int[][] distanceBtwnPrefixes = new int[a_Idx][b_Idx];
		
		int distance = computeDistance(a, a_Idx - 1, b, b_Idx - 1, distanceBtwnPrefixes);
		
		System.out.println("Levenshtein Distance = " +  distance);
	}
	
	private static int computeDistance(String a, int a_Idx, String b, int b_Idx, int[][] distanceBtwnPrefixes) {
		
		if(a_Idx < 0) {			
			// A is empty so add all of B's characters.
			return b_Idx + 1;			
		}
		else if(b_Idx < 0) {
			
			// B is empty so remove all of A's characters.
			return a_Idx + 1;
		}
		
		if(distanceBtwnPrefixes[a_Idx][b_Idx] == 0) {
			
			if(a.charAt(a_Idx) == b.charAt(b_Idx)) {
				
				distanceBtwnPrefixes[a_Idx][b_Idx] = computeDistance(a, a_Idx - 1, b, b_Idx - 1, distanceBtwnPrefixes);
			}
			else {
				
				int subtituteLast = computeDistance(a, a_Idx - 1, b, b_Idx - 1, distanceBtwnPrefixes);
				
				int addLast = computeDistance(a, a_Idx, b, b_Idx - 1, distanceBtwnPrefixes);
				
				int removeLast = computeDistance(a, a_Idx - 1, b, b_Idx, distanceBtwnPrefixes);
				
				distanceBtwnPrefixes[a_Idx][b_Idx] = 1 + Math.min(subtituteLast, Math.min(addLast, removeLast));			
			}			
		}
		return distanceBtwnPrefixes[a_Idx][b_Idx];
	}
}
