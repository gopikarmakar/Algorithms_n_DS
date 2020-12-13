package com.hyend.logical.algorithms.dp.greedy;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author gopi_karmakar
 */
public class MaxWaterTrapped {

	public static void main(String[] args) {
		
		//int[] blocks = {1, 2, 1, 3, 4, 4, 5, 1, 2, 0, 3};
		
		int[] blocks = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println(compute(blocks));
	}
	
	private static int compute(int...blocks) {
		
		int maxWater = 0;
		
		int maxHeightIdx = getMaxHeightIndex(blocks);
		
		int left = blocks[0];
		int right = blocks[blocks.length-1];
		
		for(int i = 1; i < maxHeightIdx; ++i) {
			
			if(blocks[i] >= left) {
				left = blocks[i];
			}
			else {				
				maxWater += left - blocks[i];
			}
		}
		
		for(int i = blocks.length-2; i > maxHeightIdx; --i) {
			
			if(blocks[i] >= right) {
				right = blocks[i];
			}
			else {
				maxWater += right - blocks[i];
			}
		}
		
		return maxWater;
	}
	
	private static int getMaxHeightIndex(int...blocks) {
		
		int max = blocks[0], index = 0;
		
		for(int i = 1; i < blocks.length; ++i) {
			
			if(blocks[i] > max) {
				max = blocks[i];
				index = i;
			}
		}
		return index;
	}
}
