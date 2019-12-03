package com.hyend.logical.algorithms.dp.recursive;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	public static void main(String[] args) {
		//System.out.println(findFib(10));
		System.out.println(fibMemoized(10));
	}	
	
	/**
	 * Find a Fibonacci number at a given position. 
	 * A Bottom up approach.
	 * @param n
	 * @return
	 */
	public static int findFib(int k) {
		
		if(k <= 1)
			return k;
		
		int fibMinus2 = 0;
		int fibMinus1 = 1;
		
		for(int i = 2; i < k; ++i) {
			int fib = fibMinus2 + fibMinus1;
			fibMinus2 = fibMinus1;
			fibMinus1 = fib;
		}
		return fibMinus1;
	}
	
	/**
	 * Find a Fibonacci number at a given position. 
	 * Memoized solution.
	 * @param limit
	 * @param temp
	 * @return
	 */
	
	private static Map<Integer, Integer> cache = new HashMap<>();
	private static int fibMemoized(int n) {
		
		if(n <= 1) return n;
		else if(!cache.containsKey(n)) {
			cache.put(n, fibMemoized(n-2) + fibMemoized(n-1));
		}
		return cache.get(n);
	}
	
	public static int findFibMemoized(int limit) {
		int[] temp = new int[limit+1];
		return memoized(limit, temp);
	}
	
	static int sum;
	private static int memoized(int pos, int[] temp) {
		
		if(temp[pos] != 0) {
			return temp[pos];
		}
		
		if(pos == 1 || pos == 2)	return 1;
		else {
			sum = memoized(pos-1, temp) + memoized(pos-2, temp);
			temp[pos] = sum;
		}
		return temp[pos];		
	}
}
