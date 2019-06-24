package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.hyend.data.storage.stackandqueue.ImmutableQueue;
import com.hyend.data.storage.stackandqueue.ImmutableStack;
import com.hyend.data.storage.structures.priorityqueue.MaxPriorityQueue;
import com.hyend.data.storage.structures.priorityqueue.MinPriorityQueue;

/**
 * Sliding Window Maximum (Maximum of all SubArrays of size k) 
 * 
 * Input arr[] : {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3 
 * Output : 3 3 4 5 5 5 6
 * 
 * @author gopi_karmakar
 */
public class SlidingWindowMaximum {	
	
	public static void main(String...args) {
		int arr[] = {1,3,1,2,0,5};
		//int arr[] = {7, 2, 4};
		//int arr[] = {1,3,-1,-3,5,3,2,7};
		//int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};	
		maxInSubArrayWindow(3, arr);		
	}
	
	/**
	 * Solution: 1
	 * @param arr
	 * @param k
	 */
	public static void maxInSubArrayWindow(int k, int...arr) {		
		ImmutableStack myStack = new ImmutableStack();
		List<Integer> maxList = new ArrayList<Integer>();		
		int x = 1;
		for(int v : arr) {
			myStack.push(v);
			if(x >= k) {
				x--;
				maxList.add(myStack.getMax());
				int d = myStack.pop();
				System.out.println("Pop = " + d);
			}
			x++;
		}		
		System.out.println(maxList);
	}
}