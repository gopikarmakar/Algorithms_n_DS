package com.hyend.data.storage.structures.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * A Google India Interview Question
 * 
 * Compute the running median of a stream of numbers
 * 
 * @author gopi_karmakar
 */
public class MedianFromOnlineDataStream {
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		sol.add(1);
		printMSG("" + sol.findMedian());
		sol.add(0);
		printMSG("" + sol.findMedian());
		sol.add(3);
		printMSG("" + sol.findMedian());
		sol.add(5);
		printMSG("" + sol.findMedian());
		sol.add(2);
		printMSG("" + sol.findMedian());
		sol.add(0);
		printMSG("" + sol.findMedian());
		sol.add(1);
		printMSG("" + sol.findMedian());
	}
	
	public static void printMSG(String msg) {
		System.out.println(msg);
	}
	
	private static class Solution {
	
		PriorityQueue<Integer> minPQ;
		PriorityQueue<Integer> maxPQ;
		
		public Solution() {
			minPQ = new PriorityQueue<>();
			maxPQ = new PriorityQueue<>(16, Collections.reverseOrder());
		}
		
		public void add(int num) {		
			
			if(minPQ.isEmpty() || num >= minPQ.peek()) {
				minPQ.add(num);
			}
			else {				
				maxPQ.add(num);				
			}		
			if(minPQ.size() > maxPQ.size()+1) {
				maxPQ.add(minPQ.remove());
			}
			else if(maxPQ.size() > minPQ.size()) {
				minPQ.add(maxPQ.remove());
			}
		}
		
		public double findMedian() {	     
			return (minPQ.size() == maxPQ.size()) ? (minPQ.peek() + maxPQ.peek()) * 0.5 : minPQ.peek();
	    }
	}
}
