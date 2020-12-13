package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A Facebook Interview Question
 * 
 * https://leetcode.com/problems/merge-intervals/
 * 
 * @author gopi_karmakar
 */
public class MergeIntervals {

	public static void main(String[] args) {
		
		int[][] intervals = {{1, 4}, {4, 5}};
		
		//int[][] intervals = {{1, 3}, {2, 6}, {8,10}, {15,18}};
		
		for(int[] interval : merge(intervals)) {			
				
			System.out.print("{" + interval[0] + ", " + interval[1] + "}\n");			
		}		
	}
	
	public static int[][] merge(int[][] intervals) {
		
		if(intervals == null || intervals.length < 1)
			return new int[][] {{}};
			
		List<int[]> result = new ArrayList<>();
		
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		
		int prevLow = intervals[0][0];
		int prevHigh = intervals[0][1];
		
		for(int i = 1; i < intervals.length; i++) {
			
			if(intervals[i][0] <= prevHigh) {
				prevHigh = Math.max(prevHigh, intervals[i][1]);
			}
			else {
				result.add(new int[] {prevLow, prevHigh});
				prevLow = intervals[i][0];
				prevHigh = intervals[i][1];
			}			
		}
		
		result.add(new int[] {prevLow, prevHigh});		
		
		return result.toArray(new int[result.size()][1]);
	}
}
