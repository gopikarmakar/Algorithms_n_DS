package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * @author gopi_karmakar
 */
public class FindUniqueFourSums {

	public static void main(String[] args) {
	
		//int[] nums = {1, 0, -1, 0, -2, 2};
		int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
		
		System.out.println(fourSums(nums, 0));
	}
	
	private static List<List<Integer>> fourSums(int[] nums, int target) {
		
		Set<List<Integer>> set = new HashSet<>();
		
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-3; i++){
        	
            for(int j = i + 1; j < nums.length-2; j++){
            	
                int l = j + 1;
                int r = nums.length-1;
                
                while(l < r){
                	
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    
                    if(sum == target) {
                        set.add(Arrays.asList(nums[i],nums[j],nums[l++],nums[r--]));
                    }
                    else if(sum>target) r--;
                    else  l++;
                }
            }
        }
        return new ArrayList<>(set);
	}
}
