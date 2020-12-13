package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Facebook Interview Question
 * 
 * https://leetcode.com/problems/logger-rate-limiter/
 * 
 * Give an array A consisting of string with time stamp, 
 * and a time-interval T, print the string such that there 
 * are no duplications within the time-interval T.
 * 
 * @author gopi_karmakar
 */
public class LoggerLimiter {

	public static void main(String[] args) {
		
		String[] logs = {"2:foo", "3:bar", "5:hello", "6:foo", "11:world", "19:foo"};
		int timeLimit = 8;
		
		System.out.println(uniqueLogs(logs, timeLimit));
	}
	
	/**
	 * O(n) time & space complexity solution
	 */
	private static List<String> uniqueLogs(String[] logs, int timeLimit) {
		
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		for(String log : logs) {
			
			String[] split = log.split(":");
			Integer time = Integer.parseInt(split[0]);
			
			if(map.containsKey(split[1]) && (time - map.getOrDefault(split[1], 0) < timeLimit))
				continue;
			
			map.put(split[1], time);
			result.add(split[1]);
		}
		return result;
	}
}
