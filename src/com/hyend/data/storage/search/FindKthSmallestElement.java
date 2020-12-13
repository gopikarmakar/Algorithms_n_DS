package com.hyend.data.storage.search;

import java.util.Random;
import java.util.Comparator;

/**
 * Find Kth smallest element in an unsorted array
 * For e.g:  {3, 1, -1, 2, 7, 10, 4, 9, -3, -5}
 * K = 5
 * {-5, -3, -1, 1, 2, 3, 4, 7, 9, 10} = return 2 
 * 
 * @author gopi_karmakar
 */
public class FindKthSmallestElement {

	public static void main(String[] args) {
		
		int[] arr = {3, 1, -1, 2, 7, 10, 4, 9, -3, -5};
		System.out.println("Smallest Kth Element = " + findKth(10, arr));
	}
	
	/**
	 * O(n) time and O(1) space complexity
	 * Worst case time complexity is O(n^2) which occurs
	 * when the randomly selected pivot is the smallest or largest element in the current subarray.
	 * The probability of the worst-case reduces exponentially with the length of the input array, 
	 * and the worst-case is a non-issue in practice. For this reason, the randomize selection  
	 * algorithm is sometimes said to have almost certain O(n) time complexity. 
	 */
	public static int findKth(int k, int...arr) {
		
		int l = 0, r = arr.length-1, result = 0;
		
		if(k <= 0 || k > arr.length)
			return result;		
				
		Random rand = new Random(0);
		
		while(l <= r) {
			
			int pivotIdx = l + rand.nextInt(r - l + 1);

			//int newPivotIdx = partitionAroundPivot(arr, l, r, pivotIdx, Compare.Smaller_Than);
			int newPivotIdx = partitionAroundPivot(arr, l, r, pivotIdx);
			
			if(newPivotIdx == k-1) {
				result = arr[newPivotIdx];
				break;
			}
			else if(newPivotIdx > k-1) {
				r = newPivotIdx - 1;
			}
			else {
				l = newPivotIdx + 1;
			}
		}		
		return result;
	}
	
	//private static int partitionAroundPivot(int[] arr, int l, int r, int pivotIdx, Comparator<Integer> cmp) {
	private static int partitionAroundPivot(int[] arr, int l, int r, int pivotIdx) {
		
		int leftIdx = l;
		int pivotValue = arr[pivotIdx];
		
		swap(arr, r, pivotIdx);		
		for(int i = l; i < r; ++i) {
			
			/*if(cmp.compare(arr[i], pivotValue) < 0) {
				swap(arr, i, newPivotIdx++);
			}*/
			
			if(Integer.compare(arr[i], pivotValue) < 0) {
				swap(arr, i, leftIdx++);
			}			
		}
		swap(arr, r, leftIdx);
		
		return leftIdx;
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
				//return (a < b) ? -1 : a.equals(b) ? 0 : 1;
				return Integer.compare(a, b);
			}
		}
		public static final SmallerThan Smaller_Than = new SmallerThan();
	}
}
