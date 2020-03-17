package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of closed intervals,
 * find a minimum sized set of numbers that covers all the intervals.
 * 
 * for e.g if there're tasks at times [0,3],[2,6],[3,4],[6,9]
 * then a manager visit times at [0,2,3,6] cover all completed and running tasks.
 * A smaller set of visit times that also helps to monitor and cover all tasks is [3,6]
 * 
 * https://leetcode.com/problems/video-stitching/
 *
 * @author gopi_karmakar
 */
public class IntervalCovering {

	public static void main(String[] args) {
		
		int[][] tasks = {{0,3},{3,4},{4,5},{2,3},{3,4},{1,2}};
		
		int[][] clips = {{0,2}, {4,6}, {8,10}, {1,9}, {1,5}, {5,9}};
					
		System.out.println("Visits at " + findMinimumVisits(clips) + 
				" Intervals Covers All Tasks");		
	}
	
	private static class Interval {		
		int left, right;		
		public Interval(int left, int right) {
			this.left = left;
			this.right = right;		
		}
		
		@Override
		public String toString() {
		
			return "{" + left + ", " + right +"}";
		}
	}
	
	/**
	 * Since we spend O(1) time per index, the time complexity 
	 * after the initial sort is 0(n), where n is the 
	 * number of intervals Therefore, the time taken is 
	 * dominated by the initial sort, i.e., 0(n log n)	 
	 */
	public static List<Integer> findMinimumVisits(int[][] tasks) {
		
		List<Interval> intervals = new ArrayList<>();
		for(int i = 0; i < tasks.length; i++) {
			intervals.add(new Interval(tasks[i][0], tasks[i][1]));			
		}
		
		if(intervals.isEmpty())
			return Collections.emptyList();
		
		sort(intervals);
		System.out.println(intervals);		
		
		int lastVisitTime = intervals.get(0).right;		
		List<Integer> OptimumVisits = new ArrayList<>();
		OptimumVisits.add(lastVisitTime);
		
		for(Interval interval : intervals) {
			 // The current right end point lastVisitTime, 
			 // will not cover any more intervals
			if(interval.left > lastVisitTime) {					 
				lastVisitTime = interval.right;
				OptimumVisits.add(lastVisitTime);
			}
		}		
		return OptimumVisits;
	}
	
	private static void sort(List<Interval> intervals) {
		
		/*Collections.sort(intervals, new Comparator<Interval>() {
			
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.right, i2.right);
			}
		});*/
		Collections.sort(intervals, (a, b)-> Integer.compare(a.right, b.right));
	}
}
