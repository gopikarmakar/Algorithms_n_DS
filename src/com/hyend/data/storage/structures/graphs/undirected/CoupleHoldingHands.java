package com.hyend.data.storage.structures.graphs.undirected;

/**
 * A Google Interview Question
 * https://leetcode.com/problems/couples-holding-hands/
 * 
 * Compute the minimum number of swaps so that every couple is sitting side by side. 
 * Imagine the first couple being (0, 1) and the second couple being (2, 3), 
 * and so on with the last couple being (2N-2, 2N-1).
 * 
 * It's a variant to Minimum Swaps To Sort An Array. A Google Interview Question
 * 
 * @author gopi_karmakar
 */
public class CoupleHoldingHands {

	public static void main(String[] args) {
				
		int[] row1 = {3, 2, 0, 1};
		int[] row2 = {0, 2, 1, 3};
		int[] row3 = {1, 5, 3, 4, 0, 2};
		int[] row4 = {0, 2, 3, 4, 5, 1, 6, 8, 7, 9};
		
		int swaps = minSwapCouples(row1);
		System.out.println("Minimum " + swaps + " Swaps Required");
	}
	
	/**
	 * Solution: Imagine it as a Di-Graph and map each person with the currently sitting seat. 
	 * For e.g: row = {0, 2, 3, 4, 5, 1, 6, 8, 7, 9}
	 * 0th person -> sitting on 0th seat (0 -> 0)
	 * 2nd person -> sitting on 1st seat (2 -> 1) and so on...
	 * 1st person -> sitting on 5th seat (1 -> 5) and so on...
	 * 9th person -> sitting on 9th seat (9 -> 9)
	 * 
	 * row->pos = {0->0 1->5 2->1 3->2 4->3 5->4 6->6 7->8 8->7 9->9}
	 * 
	 * So when we want to arrange the (0,1) couple and look for the 1st person. 
	 * We go to the 5th seat and swap them and update their seating position and 
	 * keep doing so till the half of the couples. We finally meet the sitting 
	 * adjacently arranged couple. Below is the implementation of same solution.    
	 *  
	 * O(N) time complexity.
	 */
	private static int minSwapCouples(int...rows) {
		
		int swaps = 0;
		int N = rows.length / 2;
		
		int[] pos = new int[rows.length];
		
		//Creating graph
		for(int i = 0; i < rows.length; ++i) {	
			pos[rows[i]] = i;
		}
		
		for(int i = 0; i < N; ++i) {
			
			int c1 = rows[2 * i];
			int c2 = rows[2 * i + 1];
			
			if((c1 % 2 == 0 && c2 != c1 + 1) || (c1 % 2 != 0 && c2 != c1 - 1)) {
				
				int targetIndex = (c1 % 2 == 0) ? pos[c1 + 1] : pos[c1 - 1];
				swap(rows, pos, (2 * i + 1), targetIndex);
				swaps += 1;
			}
		}
		return swaps;
	}
	
	private static void swap(int[] rows, int[] pos, int sourceIndex, int targetIndex) {
		
		int temp = rows[sourceIndex];
		rows[sourceIndex] = rows[targetIndex];
		rows[targetIndex] = temp;
		
		pos[rows[sourceIndex]] = sourceIndex;
		pos[rows[targetIndex]] = targetIndex;		
	}
}
