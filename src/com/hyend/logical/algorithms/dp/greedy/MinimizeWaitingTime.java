package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;

/**
 * A database has to respond to a set of client SQL queries. 
 * The service time required for each query is known in advance. 
 * For this application, the queries must be processed by the database 
 * one at a time, but can be done in any order. The time a query waits 
 * before its turn comes is called its waiting time.
 * 
 * Given service times for a set of queries, compute a schedule 
 * for processing the queries that minimizes the total waiting time
 * 
 * For e.g:For example, if the service times are (2,5,1,3) then the 
 * waiting time for executing query 3 can be 0+(2)+(2+5)+(2+5+1) = 17  
 * 
 * @author gopi_karmakar
 */
public class MinimizeWaitingTime {

	public static void main(String[] args) {
		int[] queryServiceTimes = {2,5,1,3};		
		System.out.println(minimizeWaitingTime(queryServiceTimes));
	}
	
	/**	 
	 * If we schedule queries in order of decreasing service times, 
	 * the total waiting time is 0+(5)+(5+3)+(5+3+2) = 23
	 * 
	 * We should sort the queries by their service times and then 
	 * process them in the order of nondecreasing service time.
	 * 
	 * The time complexity is dominated by the Sort time On(log n)
	 * 
	 * @param serviceTimes
	 * @return
	 */
	private static int minimizeWaitingTime(int...serviceTimes) {

		Arrays.sort(serviceTimes);
				
		int totalWaitingTime = 0;
		int totalQueries = serviceTimes.length;
		
		for(int i = 0; i < totalQueries; ++i) {
			int query = totalQueries - (i+1);
			totalWaitingTime += serviceTimes[i] * query; 
		}
		
		return totalWaitingTime;
	}
}
 