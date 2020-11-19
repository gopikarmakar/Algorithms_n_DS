package com.hyend.data.storage.structures.hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Google Interview Question
 * 
 * Find if the given array has as many repeats as queried
 * for e.g: 
 * {3,2,4,1}, q1 = {2} return false, Since there're no two times repeated number
 * {1,1,2,3}, q2 = {2} return true, Since 1 repeated two times.
 * {1,1,1,1,1}, q5 = {2, 2} return true, since 1 can be seen as a pair of repeats
 * 
 * @author gopi_karmakar
 */
public class HasRepeats {

	public static void main(String[] args) {
		
		Integer[] nums1 = {3,2,4,1}, q1 = {2};
		Integer[] nums2 = {1,1,2,3}, q2 = {2};
		Integer[] nums3 = {1,2,3,4}, q3 = {2,2};
		Integer[] nums4 = {1,2,3,4,4}, q4 = {1,2};
		Integer[] nums5 = {1,1,1,1,1}, q5 = {2,2};
		Integer[] nums6 = {1,2,3,4,4}, q6 = {2,1};
		
		System.out.println(hasRepeats(Arrays.asList(nums4), Arrays.asList(q4)));
	}
	
	private static boolean hasRepeats(List<Integer> nums, List<Integer> q) {
		
		Collections.sort(q, (a, b)->b-a);
		
		Map<Integer, Integer> map = new HashMap<>();	
		
		nums.forEach(e -> {
			
			map.put(e, map.getOrDefault(e, 0) + 1);
		});
		
		Queue<Map.Entry<Integer, Integer>> maxPQ = 
				new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
		
		maxPQ.addAll(map.entrySet());
		
		for(Integer e : q) {
			
			if(maxPQ.isEmpty())
				return false;
			
			Map.Entry<Integer, Integer> entry = maxPQ.poll();
			entry.setValue(entry.getValue() - e);
			
			if(entry.getValue() < 0)
				return false;
			
			maxPQ.add(entry);
		}			
		
		return true;
	}
}
