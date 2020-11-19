package com.hyend.logical.algorithms.dp.recursive;

/** 
 * You are climbing stairs. You can advance 1 to k steps at a time. 
 * Your destination is exactly n steps up.
 * 
 * Write a program which takes as inputs n and k and returns the number of ways 
 * in which you can get to your destination. For example, if n = 4 and k = 2, 
 * there are five ways in which to get to the destination:
 * 1) Four single stair advances,
 * 2) Two single stair advances followed by a double stair advance,
 * 3) A single stair advance followed by a double stair advance followed by a single stair advance,
 * 4) A double stair advance followed by two single stairs advances, and • two double stair advances.
 * 5) Two double stair advances.
 * 
 * @author gopi_karmakar
 */
public class ClimbingStairsII {

	public static void main(String[] args) {
		
		int n = 3, k = 3;
		int result = numberOfWays(n, k, new int[n + 1]);
		
		System.out.println(result);
	}
	
	/**
	 * An Efficient recursive approach. 
	 * In the program below, we cache value of F(i,k), 0 <= i <= n
	 * and use it again whenever same value recursively being called 
	 * again to improve time complexity. 	 
	 * 
	 * We take O(k) time to fill in each entry, so the total time complexity is O(K * n). 
	 * The space complexity is O(n).
	 */
	private static int numberOfWays(int n, int maxSteps, int[] totalWays) {
		
		if(n <= 1) 
			return 1;
		
		if(totalWays[n] == 0) {
			
			for(int i = 1; i <= maxSteps && n - i >= 0; ++i) {
				
				totalWays[n] += numberOfWays(n - i, maxSteps, totalWays);
			}
		}		
		return totalWays[n];
	}
}
