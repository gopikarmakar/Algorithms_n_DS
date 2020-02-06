package com.hyend.data.storage.structures.priorityqueue;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * It'll fail in corner cases!
 * Need to improve.
 * 
 * Otherwise it's a correct and very efficient solution!
 * 
 * @author gopi_karmakar
 */
public class SlidingWindowMedian {
	
	private static final int DEFAULT = 1 << 4;
	
	private static PriorityQueue<Item> minPQ;
	private static PriorityQueue<Item> maxPQ;
	
	public SlidingWindowMedian() {
		
		
	}

	public static void main(String[] args) {
		
		int window = 3;
		//int[] nums = {-1, 3, 1, -3, 5, 3, 6, 7};
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		//int[] nums = {2147483647, 2147483647}; // It'll fail for this case.
			
		/*Solution sol = new Solution();
		for(double d : sol.medianSlidingWindow(nums, 3)) {
			System.out.println(d);
		}*/
		
		minPQ = new PriorityQueue<Item>();
        maxPQ = new PriorityQueue<Item>(DEFAULT, Collections.reverseOrder());
		
		int i = 0;
		for(int x : nums) {
						
		
			add(new Item(i, x));
			//Item item = new Item(i, x);
			//minPQ.add(item);
			//maxPQ.add(item);
			
			if(!minPQ.isEmpty() && minPQ.peek().index <= i - window) {
				minPQ.poll();
			}
			else if(!maxPQ.isEmpty() && maxPQ.peek().index <= i - window) {
				maxPQ.poll();
			}
			
			if(i + 1 >= window) {
								
				System.out.println(getMedian());
			}
				
			i++;
		}
		
		//System.out.println(minPQ);	
		//System.out.println(maxPQ);
	}
	
	private static class Item implements Comparable<Item> {
		
		public int index;
		public Integer item;			
		
		public Item(int index, Integer item) {
			this.item = item;
			this.index = index;
		}

		@Override
		public int compareTo(Item other) {

			return Integer.compare(this.item, other.item);
		}
		
		@Override
		public String toString() {
			
			return "" + item;
		}
	}
	
	private static void add(Item item) {
		
		if(minPQ.isEmpty() || item.item >= minPQ.peek().item) {
			
			minPQ.add(item);
		}
		else {
			
			maxPQ.add(item);			
		}
		
		if(minPQ.size() > maxPQ.size() + 1) {
			
			maxPQ.add(minPQ.poll());
		}
		else if(maxPQ.size() > minPQ.size()) {
			
			minPQ.add(maxPQ.poll());
		}
	}
	
	private static double getMedian() {

        return (minPQ.size() == maxPQ.size()) 
            ? ((minPQ.peek().item + maxPQ.peek().item) * 0.5) : minPQ.peek().item;	         
    }
	
	/*private static class Solution {
		
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
	    	//System.out.println(minPQ.size());
	    	//System.out.println(maxPQ.size());
	        return (minPQ.size() == maxPQ.size()) 
	            ? ((minPQ.peek() * 0.5 + maxPQ.peek() * 0.5) ) : minPQ.peek();	         
	    }
	    
	    private void clearPQs() {
	    	minPQ.clear();
	    	maxPQ.clear();
	    }
	}*/
}