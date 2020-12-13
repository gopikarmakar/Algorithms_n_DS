package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A Google and Facebook Interview Question.
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Let's say we have a database of all the customers
 * entry time and exit time to a store, we want maximum  
 * number of customers at a time in the store.
 * 
 * Variant: Given an array of meeting time intervals consisting of 
 * start and end times [[s1,e1],[s2,e2],...] 
 * find the minimum number of conference rooms required.
 * 
 * @author gopi_karmakar
 */
public class MeetingRoomII {

	public static void main(String[] args) {
	
		int[][] events = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
		
		System.out.println(roomsRequired(events));
	}
	

	/**
	 * Solution: In other words to have the maximum customers 
	 * in the store at a given time we should consider the 
	 * late exit times. This way it'll require least meeting
	 * rooms with the maximum customers with in it.
	 * 
	 * O(n(log n)) time and O(n) Space complexity
	 */
	private static int roomsRequired(int[][] events) {
		
		Arrays.sort(events, (a, b) -> a[0] - b[0]);
		
		Queue<Integer> pq = new PriorityQueue<>();
		
		for(int[] event : events) {
			
			if(pq.isEmpty()) {
				pq.add(event[1]);
			}
			else {
				
				if(event[0] >= pq.peek()) {
					pq.poll();
				}				
				
				pq.add(event[1]);
			}
		}
					
		return pq.size();
	}
}
