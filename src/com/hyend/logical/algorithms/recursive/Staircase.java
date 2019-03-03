package com.hyend.logical.algorithms.recursive;

/**
 * 
 * @author karmakargopi
 * 
 * Prob: Find out the number of ways,
 * to climb the top of the staircase
 * for n given steps in staircase
 * 
 * 
 */
public class Staircase {
	
	int totalWays = 0;
	
	public Staircase() {}
	
	public Staircase(int n) {
		//cache = new int[n+1];
	}	
	
	/**
	 * Highly inefficient recursive approach.
	 * By every time calculating the same
	 * recursive calls. 
	 * @param n
	 * @return
	 */
	public int numberOfWays(int n) {
		
		if(n == 0 || n == 1) return 1;
		else {
			totalWays = numberOfWays(n-1) + numberOfWays(n-2);
		}	
		return totalWays;
	}
	
	/**
	 * Efficient recursive approach.
	 * Where we store the previous value 
	 * and use it again whenever same value 
	 * recursively being called again.
	 * @param n
	 * @param temp
	 * @return
	 */
	public int numberOfWays(int n, int[] cache) {
		
		if(cache[n] != 0) return cache[n];
		if(n == 0 || n == 1) return 1;
		else {
			totalWays = numberOfWays(n-1, cache) + numberOfWays(n-2, cache);
			cache[n] = totalWays;
		}	
		return cache[n];
	}
	
	/**
	 * Bottoms up approach to find the
	 * number of ways to climb the staircase
	 * @param n
	 * @return
	 */
	public int bottomsUpNumOfWays(int n) {
		
		int i = 2;
		int[] temp = new int[n+1];
		temp[0] = 1;
		temp[1] = 1;
		if(n == 0 || n == 1) return temp[n];
		
		for(; i <= n; i++) {
			temp[i] = temp[n-1] + temp[n-2];
		}
		return temp[i-1];
	}
	
	/**
	 * Bottoms up approach to find the number of ways
	 * with in the given range of steps can be taken.
	 * @param n
	 * @param range
	 * @return
	 */
	public int numOfWaysWithInRange(int n, int[] range) {
		
		
		int[] temp = new int[n+1];
		temp[0] = 1;
		
		if(n == 0) return 1;
		
		int i = 1;
		for(; i<= n; i++) {
			totalWays = 0;
			for(int j : range) {
				if(i-j >= 0) 
					totalWays += temp[i-j];
			}
			temp[i] = totalWays;
		}
		return temp[n];
	}
}