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
 * 
 * 
 * Input arr[] : {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3 
 * Output : 3 3 4 5 5 5 6
 * 
 * @author gopi_karmakar
 */
public class SlidingWindowMaximum {	
	
	public static void main(String...args) {
		//int arr[] = {1,3,1,2,0,5};
		int arr[] = {7, 2, 4};
		//int arr[] = {1,3,-1,-3,5,3,2,7};
		//int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};	
		maxInSubArrayWindow(2, arr);
	}
	
	/**
	 * Solution: 1
	 * @param arr
	 * @param k
	 */
	public static void maxInSubArrayWindow(int[] arr, int k) {
		
        /*if(nums.length == 0 || k == 0 || k == 1)
            return nums;
        
        List<Integer> subList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length-k+1; i++) {			
            for(int j = i; j < i+k; j++) {
                subList.add(nums[j]);
            }
            pq.addAll(subList);
            subList.clear();
            int item = 0;
            while(!pq.isEmpty()) {
                item = pq.remove();
            }
            maxList.add(item);
        }    

        int[] arr = new int[maxList.size()];   
        int i = 0;
        for(int x : maxList)
            arr[i++] = x;

        return arr;*/
		
		ImmutableStack myStack = new ImmutableStack();
		List<Integer> maxList = new ArrayList<Integer>();
		
		for(int i = 0; i <= arr.length-k; i++) {
			
			for(int j = i; j < i+k; j++) {
				myStack.push(arr[j]);
			}
			for(int j = i; j < k-1; j++) {
				myStack.push(arr[j]);
			}
			int max = myStack.getMax();
			myStack.pop();
			maxList.add(max);
		}
		for(int x : maxList)
			System.out.println(x);
	}
	
	/**
	 * Improved Solution: 2
	 * @param k
	 * @param arr
	 */
	public static void maxInSubArrayWindow(int k, int...arr) {			
		//dequeSolution(k, arr);
		priorityQueueSolution(k, arr);
	}
	
	private static void dequeSolution(int k, int...arr) {
		List<Integer> maxList = new ArrayList<Integer>();		
		if(k > 2) {
			ImmutableQueue myQueue = new ImmutableQueue();
			int offset = 1;
			for(int x : arr) {
				myQueue.enqueue(x);
				if(offset == k) {
					offset-=1;
					maxList.add(myQueue.getMax());
					myQueue.dequeue();
				}
				offset+=1;
			}
		}
		else if(k == 2) {
			
			for(int i = 0; i < arr.length-1; i++) {
				
				int max = Math.max(arr[i], arr[i+k-1]);
				maxList.add(max);
			}
		}
		
		for(int x : maxList)
			System.out.println(x);
	}
	
	private static void priorityQueueSolution(int k, int...nums) {		
				
		if(nums.length == 0 || k == 0 || k == 1)
            return;
        		
        List<Integer> subList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length-k+1; i++) {			
            for(int j = i; j < i+k; j++) {
                subList.add(nums[j]);
            }
            pq.addAll(subList);
            subList.clear();
            int item = 0;
            while(!pq.isEmpty()) {
                item = pq.remove();
            }
            maxList.add(item);
        }
		
		for(int x : maxList)
			System.out.println(x);
	}
}