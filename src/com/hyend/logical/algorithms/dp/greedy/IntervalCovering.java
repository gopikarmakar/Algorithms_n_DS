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
 *
 * @author gopi_karmakar
 */
public class IntervalCovering {

	public static void main(String[] args) {
		int[][] tasks = {{0,3},{3,4},{4,5},{2,3},{3,4},{1,2}};
		
		IntervalCovering ic = new IntervalCovering();
		
		List<Interval> intervals = new ArrayList<>();
		for(int i = 0; i < tasks.length; i++) {
			intervals.add(ic.new Interval(tasks[i][0], tasks[i][1]));			
		}
		System.out.println("Visits at " + ic.findMinimumVisits(intervals) + 
				" Intervals Covers All Tasks");		
	}
	
	private class Interval {		
		int left, right;		
		public Interval(int left, int right) {
			this.left = left;
			this.right = right;		
		}
	}
	
	public List<Integer> findMinimumVisits(List<Interval> intervals) {
		
		if(intervals.isEmpty())
			return Collections.EMPTY_LIST;
		
		Collections.sort(intervals, new Comparator<Interval>() {			
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.right, i2.right);
			}
		});
		
		int lastVisitTime = intervals.get(0).right;		
		List<Integer> OptimumVisits = new ArrayList<>();
		OptimumVisits.add(lastVisitTime);
		
		for(Interval interval : intervals) {
			if(interval.left > lastVisitTime) {						
				/**
				 * The current right end point, lastVisitTime, 
				 * will not cover any more intervals
				 */
				lastVisitTime = interval.right;
				OptimumVisits.add(lastVisitTime);
			}
		}		
		return OptimumVisits;
	}
}
