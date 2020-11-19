package com.hyend.logical.algorithms.dp.recursive;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct 
 * ways can you climb to the top?
 * 
 * @author gopi_karmakar
 */
public class ClimbingStairs {
	
	private static Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String[] args) {
		
		cache.put(1, 1);
		cache.put(2, 2);				
		
		System.out.println(numOfWays(3));		
	}

	private static int numOfWays(int n) {
		
		if(cache.containsKey(n))
			return cache.get(n);
		
		int ways = numOfWays(n-1) + numOfWays(n-2);
		cache.put(n, ways);		
		return ways;				
	}
}