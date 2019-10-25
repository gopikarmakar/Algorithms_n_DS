package com.hyend.data.storage.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 * 
 * Insert a pair of interval into a set of intervals.
 * for e.g: 
 * Given a list of intervals : {{6, 7}, {3, 5}, {1, 2}, {12, 16}, {8, 10}}
 * and an Interval to be inserted : [4, 8]
 * return : [[1,2],[3,10],[12,16]] new interval [4,8] overlaps with [3,5],[6,7],[8,10]
 *  
 * @author gopi_karmakar
 */
public class InsertInterval {

	public static void main(String[] args) {
		
		
		
		//int[][] intervals = {{3,6}, {0,2}, {7,9}, {-4,-1}, {14,17}, {11,12}};
		
		int[][] intervals = {{6, 7}, {3, 5}, {1, 2}, {12, 16}, {8, 10}};
		
		int[] insert = {4, 8};
		
		List<EndPoints> disjointIntervals = new ArrayList<>();
		
		for(int i = 0; i < intervals.length; ++i) {
			disjointIntervals.add(new EndPoints(intervals[i][0], intervals[i][1]));
		}
		
		Collections.sort(disjointIntervals);
		
		System.out.println(mergeIntervals(disjointIntervals, new EndPoints(insert[0], insert[1])));
	}
	
	private static class EndPoints implements Comparable<EndPoints> {
		int start;
		int end;
		public EndPoints(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(EndPoints i) {
			return (this.end < i.end) ? -1 : (this.end > i.end) ? 1 : 0;  
		}
		
		@Override
		public String toString() {				
			return "["+ start + "," + end +"]";
		}
	}
	
	/**
	 * Since the program spends O(1) time per entry, its time complexity is O(n).
	 */
	private static List<EndPoints> mergeIntervals(List<EndPoints> disjointIntervals, EndPoints newInterval) {
						
		System.out.println(disjointIntervals);
		
		int i = 0;
		List<EndPoints> result = new ArrayList<>();
		
		while(i < disjointIntervals.size() && newInterval.start > disjointIntervals.get(i).end) {		
			result.add(disjointIntervals.get(i++));
		}
		
		while(i < disjointIntervals.size() && newInterval.end >= disjointIntervals.get(i).start) {
			
			// If [a, b] and [c, d] overlap, their union is [min(a , c), max(b, d)].
			newInterval = new EndPoints(
							Math.min(disjointIntervals.get(i).start, newInterval.start),
							Math.max(disjointIntervals.get(i).end, newInterval.end));
			i++;
		}
		result.add(newInterval);
		
		result.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
		
		return result;
	}
}
