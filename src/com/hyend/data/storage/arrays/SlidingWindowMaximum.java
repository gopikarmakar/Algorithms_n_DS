package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.ArrayList;
import com.hyend.data.storage.stackandqueue.ImmutableStack;

/**
 * Sliding Window Maximum (Maximum of all SubArrays of size k) 
 * 
 * It's improper since it fails. 
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
		//maxInSubArrayWindow(2, arr.length, arr);
	}
	
	/**
	 * A naive solution:
	 * 
	 * The time complexity is O((n-k+1)*k) 
	 * which can also be written as O(N * K)
	 * 
	 * @param k
	 * @param n
	 * @param arr
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