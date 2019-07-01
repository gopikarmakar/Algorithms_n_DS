package com.hyend.data.storage.structures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * It'll fail in corner cases yet!
 * Need to improve.
 * 
 * Otherwise it's a correct and very efficient solution!
 * 
 * @author gopi_karmakar
 */
public class SlidingWindowMedian {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		//int[] nums = {2147483647, 2147483647}; // It'll fail for this case.				
		Solution sol = new Solution();
		for(double d : sol.medianSlidingWindow(nums, 2)) {
			System.out.println(d);
		}
	}
	
	private static class Solution {
		
		private final int DEFAULT = 1 << 4;
	    private PriorityQueue<Integer> minPQ;
	    private PriorityQueue<Integer> maxPQ;
	    
	    public Solution() {
	        minPQ = new PriorityQueue<Integer>();
	        maxPQ = new PriorityQueue<Integer>(DEFAULT, Collections.reverseOrder());
	    }
	    
	    public List<Double> medianSlidingWindow(int[] nums, int k) {
	        int i = 0;
	        List<Double> medians = new ArrayList<>();
	        while(i <= nums.length-k) {
	            medians.add(compute(Arrays.copyOfRange(nums, i, i+k)));
	            clearPQs();
	            i+=1;
	        }	        
	        return medians;
	    }
	    
	    private Double compute(int[] nums) {
	    	add(nums);
            return findMedian();
	    }
	    
	    private void add(int[] nums) {	        
	        for(int n : nums) {
	            if(minPQ.isEmpty()) minPQ.add(n);
	            else {
	                if(n >= minPQ.peek()) minPQ.add(n);
	                else maxPQ.add(n);
	            }
	            if(minPQ.size() > maxPQ.size()+1) maxPQ.add(minPQ.remove());
	            else if(maxPQ.size() > minPQ.size()) minPQ.add(maxPQ.remove());
	        }
	    }
	    
	    private double findMedian() {
	    	//long res = (minPQ.peek()+maxPQ.peek());
	        return (minPQ.size() == maxPQ.size()) 
	            ? ((minPQ.peek()+maxPQ.peek()) * 0.5) : minPQ.peek();
	    }
	    
	    private void clearPQs() {
	    	minPQ.clear();
	    	maxPQ.clear();
	    }
	}
}
