package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For e.g nums = {1,1,1,2,2,3} k = 2 return {1, 2}
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * @author gopi_karmakar
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		
		int[] nums = {1, 1, 1, 2, 2, 3};
		
		//int[] nums = {1};
		
		System.out.println(topKFrequent(nums, 2));
	}
	
	/**
	 * Time complexity will be dominated by PQ O(n log k)
	 * Can improve to O(n) by QuickSort partitioning algorithm
	 */
	private static List<Integer> topKFrequent(int[] nums, int k) {
		
		List<Integer> list = new ArrayList<>();
		
		Map<Integer, Integer> map = new HashMap<>();
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxPQ = 
				new PriorityQueue<>(k, (a, b)->b.getValue() - a.getValue());
		
		for(int n : nums) {
			
			map.put(n, map.getOrDefault(n, 0) + 1);
		}				
		
		maxPQ.addAll(map.entrySet());
		
		while(k-- > 0) {
			
			list.add(maxPQ.poll().getKey());
		}
		
		return list;
	}
}
