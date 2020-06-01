package com.hyend.logical.algorithms;

/**
 * 
 * @author gopi_karmakar
 */
public class MaxWaterTrapped {

	public static void main(String[] args) {
		
		int[] blocks = {1, 2, 1, 3, 4, 4, 5, 1, 2, 0, 3};
		
		System.out.println(compute(blocks));
	}
	
	private static int compute(int...blocks) {
		
		int maxWater = 0;
		
		int maxH = getMaxHeight(blocks);
		
		int left = blocks[0];
		int right = blocks[blocks.length-1];
		
		for(int i = 1; i < maxH; ++i) {
			
			if(blocks[i] >= left) {
				left = blocks[i];
			}
			else {				
				maxWater += left - blocks[i];
			}
		}
		
		for(int i = blocks.length-2; i > maxH; --i) {
			
			if(blocks[i] >= right) {
				right = blocks[i];
			}
			else {
				maxWater += right - blocks[i];
			}
		}
		
		return maxWater;
	}
	
	private static int getMaxHeight(int...blocks) {
		
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
