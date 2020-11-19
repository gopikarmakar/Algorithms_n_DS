package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * 
 * @author gopi_karmakar
 */
public class SubSets {

	private static String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		
		//int[] nums = {};
		//int[] nums = {0};
		int[] nums = {1, 2, 3};
		List<List<Integer>> subsets = new ArrayList<>();		
		subset(0, nums, new ArrayList<>(), subsets);
		
		System.out.println(subsets);
		
		int n = 3;
		String elements = alphabets.substring(0, n);
		stringCombinations("", elements);
	}	
	
	private static void subset(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
	
		subsets.add(new ArrayList<>(subset));
		
		if(subset.size() < nums.length) {
			
			for(int i = index; i < nums.length; i++) {
				
				subset.add(nums[i]);
				subset(i + 1, nums, subset, subsets);
				subset.remove(subset.size()-1);
			}
		}
	}
	
	private static void stringCombinations(String prefix, String s) {
		
		if(s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
		
			stringCombinations(prefix + s.charAt(0), s.substring(1));
			stringCombinations(prefix,               s.substring(1));
		}
	}
}