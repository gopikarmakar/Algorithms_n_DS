package com.hyend.data.storage.sort;

import java.util.ArrayList;

import java.util.List;

/**
 * Let A be an array of integers. Call the pair of indices (i, j) inverted 
 * if i < j and A[i] > A[j]. For example, if A = (4,1,2,3), then the pair of 
 * indices (0, 3) is inverted. Intuitively, the number of inverted pairs in an 
 * array is a measure of how unsorted it is.
 * 
 * @author gopi_karmakar
 */
public class CountInversions {
	
	public static void main(String[] args) {
		
		//int[] arr = {1, 3, 2};
		//int[] arr = {3, 6, 4, 2, 5, 1};	
		//int[] arr = {1, 3, 4, 2};
		//int[] arr = {4, 3, 1, 2};
		//int[] arr = {4, 1, 2, 3};
		int[] arr = {5, 1, 3, 2};
		//int[] arr = {2, 6, 4, 5, 1, 3};
		System.out.println(countInversions(arr, 0, arr.length));
		
		for(int x : arr)
			System.out.println(x);
	}
	
	/**
	 * O(n log n) time complexity.
	 */
	public static int countInversions(int[] arr, int l, int r) {
		
		if(r - l <= 1) return 0;
		
		int mid = l + ((r - l)/2);
		
		return countInversions(arr, l, mid) + countInversions(arr, mid, r) + merge(arr, l, mid, r);
	}
	
	private static int merge(int[] arr, int l, int mid, int r) {
		
		List<Integer> sorted = new ArrayList<>();
		int leftStart = l, rightStart = mid, inversions = 0;
		
		while(leftStart < mid && rightStart < r) {
			
			if(Integer.compare(arr[leftStart], arr[rightStart]) <= 0) {
				
				sorted.add(arr[leftStart++]);
			}
			else {
				
				inversions += mid - leftStart;				
				sorted.add(arr[rightStart++]);
			}
		}
		
		for(int i = leftStart; i < mid; ++i) {
			sorted.add(arr[i]);
		}
		
		for(int i = rightStart; i < r; ++i) {
			sorted.add(arr[i]);
		}
		
		for(int x : sorted) {			
			arr[l++] = x;
		}
		return inversions;
	}
}
