package com.hyend.data.storage.sort;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Find max simultaneous events occurring for a single day in a calendar.
 * e.g: {10, 12} {12, 14} {11, 12} in this case there're 2 simultaneous events 
 * since there's an event from 10 to 12 and with in that time there's an another event 
 * scheduled simultaneously from 11 to 12.        
 * 
 * @author gopi_karmakar
 */
public class MaxSimultaneousEventsInACalendar {

	public static void main(String[] args) {
		
		//int[][] intervals = {{10, 12}, {11, 12}, {12, 14}};
		int[][] intervals = {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
		//int[][] intervals = {{6, 10}, {9, 17}, {8, 9}, {4, 5}, {1, 5}, {12, 15}, {11, 13}, {2, 7}, {14, 15}};		
		
		MaxSimultaneousEventsInACalendar events = new MaxSimultaneousEventsInACalendar();
		
		System.out.println(events.find(intervals));			
	}
	
	private class EndPoint implements Comparable<EndPoint> {
		
		int time;
		boolean isStart;
		
		public EndPoint(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
		
		@Override
		public int compareTo(EndPoint e) {
			
			if(this.time != e.time)
				return Integer.compare(this.time, e.time);
			
			return (isStart && !e.isStart) ? -1 : (!isStart && e.isStart) ? 1 : 0;
		}
		
		@Override
		public String toString() {		
			return "Time  = " + this.time + " isStart = " + this.isStart + "\n";
		}
	}
	
	private int find(int[][] intervals) {
		
		List<EndPoint> list = new ArrayList<>();
		
		for(int i = 0; i < intervals.length; i++) {
			
			list.add(new EndPoint(intervals[i][0], true));
			list.add(new EndPoint(intervals[i][1], false));
		}		
		return compute(list);
	}
	
	/**
	 * Sorting the EndPoint array takes 0(n log n) time; iterating through 
	 * the sorted array takes 0(n) time, yielding an 0(n log n) time complexity 
	 * The space complexity is 0(n), which is the size of the endpoint array.
	 */
	int maxParallelEvents = 0, parallelEventsRunning = 0;
	private int compute(List<EndPoint> list) {
		
		Collections.sort(list);
		System.out.println(list);
				
		HashMap<Integer, Integer> map = new HashMap<>();
		for(EndPoint ep : list) {
			
			if(ep.isStart) {
				++parallelEventsRunning;
				//parallelEventsRunning = map.getOrDefault(ep.time, 0);
				//map.put(ep.time, ++parallelEventsRunning);				
				maxParallelEvents = Math.max(parallelEventsRunning, maxParallelEvents);
			}			
			else {
				--parallelEventsRunning;
			}						
		}
		return maxParallelEvents;
	}
}
