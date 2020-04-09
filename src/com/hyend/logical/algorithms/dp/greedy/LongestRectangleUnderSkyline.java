package com.hyend.logical.algorithms.dp.greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author gopi_karmakar
 */
public class LongestRectangleUnderSkyline {
	
	public static void main(String[] args) {
		
		int[] heights = {1,4,2,5,6,3,2,6,6,5,2,1,3};		
		System.out.println("Longest Rectangle = " + calculateLargestRectangle(heights));
	}

	/**
	 * The time complexity is 0(n)
	 */
	public static int calculateLargestRectangle(int...heights) {
		
		int maxRectangleArea = 0;		
		Deque<Integer> pillarIndices = new LinkedList<>();
		
		for(int i = 0; i < heights.length; i++) {
			
			if(!pillarIndices.isEmpty() && i < heights.length &&
				heights[i] == heights[pillarIndices.peekFirst()]) {
				// Replace previous building of same height by current building. 
				// This ensures the later buildings have the correct left end point.
				pillarIndices.removeFirst();
				pillarIndices.addFirst(i);;
			}				
			while(!pillarIndices.isEmpty() &&
				isNewPillarOrReachedEnd(i, pillarIndices.peekFirst(), heights)) {
				
				int height = heights[pillarIndices.removeFirst()];
				
				int width = (pillarIndices.isEmpty()) ? i : i - pillarIndices.peekFirst()-1;
				
				maxRectangleArea = Math.max(maxRectangleArea, height * width);
			}			
			pillarIndices.addFirst(i);
		}		
		return maxRectangleArea;
	}
	
	public static boolean isNewPillarOrReachedEnd(int currentIdx, int lastPillarIdx, int...heights) {
		
		return (currentIdx < heights.length) ? 
				heights[currentIdx] < heights[lastPillarIdx] : true;				
	}
}
