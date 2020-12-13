package com.hyend.logical.algorithms.dp.recursive;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * @author gopi_karmakar
 */
public class CombinationSum {
	
	public static void main(String[] args) {
		
		//int[] candidates = {2, 3, 6, 7};
		//int target = 7;
		
		int[] candidates = {2, 3, 5};
		int target = 8;
		
		for(List<Integer> list : combinationSum(candidates, target)) {
			System.out.println(list);
		}
	}

	/**
	 * Accepted in Leetcode with 2ms 98.73% runtime
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        compute(candidates, 0, target, new ArrayList<>(), 0, result);
        
        return result;
    }
	
    private static void compute(int[] candidates, int index, int target, 
    		List<Integer> list, int sum, List<List<Integer>> result) {
    	
        if(sum == target) {
        	result.add(list);
            return;
        }
        
        for(int i=index; i < candidates.length; i++) {
        	
            if(sum+candidates[i] <= target) {
            	
                List<Integer> temp = new ArrayList<>(list);
                
                temp.add(candidates[i]);
                
                compute(candidates, i, target, temp, sum+candidates[i], result);  
            } 
        }
    }
}
