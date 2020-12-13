package com.hyend.logical.algorithms.dp.greedy;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Given an array of heights of vertical lines Compute
 * the max water trapped by a pair of vertical lines.
 * 
 * @author gopi_karmakar
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		
		int[] heights = {1,8,6,2,5,4,8,3,7};
		//int[] heights = {1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1};
		
		System.out.println("Max Water Trapped = " + getMaxWaterTrapped(heights));
	}
	
	public static int getMaxWaterTrapped(int...heights) {
		
		int maxWater = 0;		
		int i = 0, j = heights.length-1, width = 0;
		
		while(i < j) {
			
			width = j - i;
			
			maxWater = Math.max(maxWater, width * Math.min(heights[i], heights[j]));
			
			if(heights[i] < heights[j]) {
				i++;
			}
			else if(heights[i] > heights[j]) {
				j--;
			}
			else {
				i++;
				j--;
			}
		}
		return maxWater;
	}
}
