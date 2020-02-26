package com.hyend.data.storage.stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * A Google Interview Question:
 * Sliding Window Maximum (Variant: Maximum from SubArrays of size k) 
 * For e.g:
 * Input arr[] : {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3 
 * Output : 3 3 4 5 5 5 6
 * 
 * @author gopi_karmakar
 */
public class SlidingWindowMaximum {	
	
	public static void main(String...args) {
		//int[] arr = new int[0];
		int arr[] = {1, 3, 1, 2, 0, 5};
		//int arr[] = {7, 2, 4};
		//int arr[] = {1,3,-1,-3,5,3,2,7};
		//int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};

		//maxInSubArrayWindow(3, arr.length, arr);
		System.out.println(); 
		System.out.println(maxInSlidingWindow(3, arr));
	}
	
	/**
	 * An efficient O(n) time complexity solution
	 * with additional O(w) extra space. 
	 * where w is the window size.
	 */
	public static List<Integer> maxInSlidingWindow(int w, int...arr) {
		
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		
		if(w == 0 || w > arr.length) return list;
		
	    for(int i = 0; i < arr.length; ++i){
	    	
	    	// Checking and removing the index from head which are out 
	    	// Of this window boundary. In short when DQ.head < i+w
	        if(!deque.isEmpty() && deque.peek() == i - w) 
	            deque.poll();
	 
	        while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
	            deque.removeLast();
	        }  	        
	 
	        deque.addLast(i);
	        
	        if(i >= w-1)
	        	list.add(arr[deque.peek()]);	        	       
	    }
	    return list;
	}
	
	/**
	 * An another O((n-k+1)*k) solution 
	 * which can also be written as O(N * K)
	 */
	public static void maxInSubArrayWindow(int k, int n, int...arr) {
		int j, max;		  
        for (int i = 0; i <= n - k; i++) { 
            max = arr[i];
            for (j = 1; j < k; j++) { 
                if (arr[i + j] > max) 
                    max = arr[i + j];
            } 
            System.out.print(max + " "); 
        } 
	}
}