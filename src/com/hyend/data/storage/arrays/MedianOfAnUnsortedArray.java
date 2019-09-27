package com.hyend.data.storage.arrays;

import java.util.Random;
import java.util.Comparator;

/**
 * Find the median of an unsorted array.
 * For e.g:  {3, 1, -1, 2, 7, 10, 4, 9, -3, -5}
 * {-5, -3, -1, 1, 2, 3, 4, 7, 9, 10} = return 2.5
 * 
 * @author gopi_karmakar
 */
public class MedianOfAnUnsortedArray {

	public static void main(String[] args) {
	
		int[] arr = {1, 3, 4, 2, 6, 5, 8, 7};
		//int[] arr = {3, 1, -1, 2, 7, 10, 4, 9, -3, -5};
		//int[] arr = {3, 1, -1, 2, 7, 10, 4, 9, -3};
		System.out.println(findMedian(arr));
	}
	
	/**
	 * O(n) time and O(1) space complexity
	 * Worst case time complexity is O(n^2) which occurs
	 * when the randomly selected pivot is the smallest or largest element in the current subarray.
	 * The probability of the worst-case reduces exponentially with the length of the input array, 
	 * and the worst-case is a non-issue in practice. For this reason, the randomize selection  
	 * algorithm is sometimes said to have almost certain O(n) time complexity. 
	 */
	public static double findMedian(int...arr) {
		
		double median = 0.0;
		int n = arr.length, l = 0, r = n-1, k = n/2;
		
		Random random = new Random(0);
		
		while(l <= r) {
			
			int rand = random.nextInt(r - l + 1);
			int pivotIdx = rand + l;
			int newPivotIdx = partitionAroundPivot(arr, l, r, pivotIdx, Compare.Smaller_Than);
			
			if(newPivotIdx == k-1) {
				
				median = (n%2 == 0) ? (arr[newPivotIdx] + arr[k]) * 0.5 : arr[newPivotIdx]; 
				break;
			}
			else if(newPivotIdx > k-1) {
				r = newPivotIdx - 1;
			}
			else {
				l = newPivotIdx + 1;
			}
		}
		return median;
	}
	
	private static int partitionAroundPivot(int[] arr, int l, int r, int pivotIdx, Comparator<Integer> cmp) {
		
		int newPivotIdx = l;
		int pivotValue = arr[pivotIdx];
		
		swap(arr, r, pivotIdx);
		for(int i = l; i < r; ++i) {
			if(cmp.compare(arr[i], pivotValue) < 0) {
				swap(arr, i, newPivotIdx++);
			}
		}
		swap(arr, r, newPivotIdx);		
		return newPivotIdx;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static class Compare {
		private static class SmallerThan implements Comparator<Integer> {
			@Override
			public int compare(Integer a, Integer b) {
				return (a < b) ? -1 : a.equals(b) ? 0 : 1;
			}
		}
		private static final SmallerThan Smaller_Than = new SmallerThan();
	}
}
