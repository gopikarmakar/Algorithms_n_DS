package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * A Facebook Interview Question
 * 
 * Merge two sorted set of intervals. 
 * Assume Intervals are sorted as per their end time.
 * 
 * @author gopi_karmakar
 */
public class MergeIntervalsII {

	public static void main(String[] args) {
		
		int[][] interval1 = {{1, 5}, {10, 14}, {16, 18}, {20, 24}, {30, 38}};
		int[][] interval2 = {{-4, -2}, {2, 6}, {8, 10}, {11, 20}};
		
		for(int[] interval : merge(interval1, interval2)) {			
			
			System.out.print("{" + interval[0] + ", " + interval[1] + "}\n");			
		}
	}
	
	private static int[][] merge(int[][] interval1, int[][] interval2) {
		
		List<int[]> list = new ArrayList<>();
		
		for(int[] e : interval1) {
			list.add(e);
		}
		
		for(int[] e : interval2) {
			list.add(e);
		}
		
		return com.hyend.logical.algorithms.dp.greedy.MergeIntervals.merge(list.toArray(new int[list.size()][1]));
	}
}