package com.hyend.data.storage.sort;

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
public class MergeIntervals {

	public static void main(String[] args) {
		
		int[][] interval1 = {{1, 5}, {10, 14}, {16, 18}, {20, 24}, {30, 38}};
		int[][] interval2 = {{-4, -2}, {2, 6}, {8, 10}, {11, 20}};
		
		List<EndPoint> intervalList1 = new ArrayList<>();
		List<EndPoint> intervalList2 = new ArrayList<>();
		
		for(int i = 0; i < interval1.length; ++i) {
			intervalList1.add(new EndPoint(interval1[i][0], interval1[i][1]));
		}
		
		for(int i = 0; i < interval2.length; ++i) {
			intervalList2.add(new EndPoint(interval2[i][0], interval2[i][1]));
		}
		
		System.out.println(merge(intervalList1, intervalList2));
	}
	
	private static class EndPoint {
		
		int start;
		int end;
		public EndPoint(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {				
			return "["+ start + "," + end +"]";
		}
	}
	
	/**
	 * Since the program spends O(1) time per entry, its time complexity is O(n).
	 */
	private static List<EndPoint> merge(List<EndPoint> a, List<EndPoint> b) {
		
		List<EndPoint> result = new ArrayList<>();
		
		int m = a.size();
		int n = b.size();
		
		// Merge non overlapping intervals
		int i = 0, j = 0;	
		while((i < m && j < n)) {
			
			if(b.get(j).start > a.get(i).end) {
				result.add(a.get(i++));
			}
			else if(b.get(j).end < a.get(i).start) {
				result.add(b.get(j++));
			}
			else break;
		}
				
		List<EndPoint> tempResult = mergeIntoOne(i, j, a, b);								
		
		result.addAll(mergeFinalOverlap(tempResult));
		
		return result;
	}
	
	private static List<EndPoint> mergeIntoOne(int i, int j, List<EndPoint> a, List<EndPoint> b) {
		
		int m = a.size();
		int n = b.size();
		
		List<EndPoint> tempResult = new ArrayList<>();
		
		while(i < m && j < n) {
			
			if(b.get(j).end >= a.get(i).start) {
				
				// If [a, b] and [c, d] overlap, their union is [min(a , c), max(b, d)].
				
				EndPoint mergedInterval = new EndPoint(
								Math.min(a.get(i).start, b.get(j).start),
								Math.max(a.get(i).end, b.get(j).end));
								
				tempResult.add(mergedInterval);
			}
			else {
				tempResult.add(a.get(i));
				tempResult.add(b.get(j));
			}			
			i++;
			j++;
		}		
		
		List<EndPoint> pending = (i == m) ? b.subList(j, b.size()): 
											a.subList(i, a.size());		
		tempResult.addAll(pending);
		
		//System.out.println(tempResult);
		
		return tempResult;
	}
	
	private static List<EndPoint> mergeFinalOverlap(List<EndPoint> tempResult) {
		
		for(int x = 0, y = x + 1; x < tempResult.size()-1 && y < tempResult.size();) {
			
			if(tempResult.get(x).end >= tempResult.get(y).start) {
				
				// If [a, b] and [c, d] overlap, their union is [min(a , c), max(b, d)].
				
				EndPoint mergedInterval = new EndPoint(
						Math.min(tempResult.get(x).start, tempResult.get(y).start),
						Math.max(tempResult.get(x).end, tempResult.get(y).end));
				
				tempResult.set(x, mergedInterval);
				tempResult.remove(y);
			}
			else {				
				++x;
				++y;
			}
		}
		return tempResult;
	}
}