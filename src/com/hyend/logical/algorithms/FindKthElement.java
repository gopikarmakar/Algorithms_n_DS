package com.hyend.logical.algorithms;

/**
 * @author karmakargopi
 *
 * Given two sorted arrays of size m and n respectively, 
 * you are tasked with finding the element that would be 
 * at the k’th position of the final sorted array.
 */
public class FindKthElement {

	public int find(int[] arr1, int[] arr2, int l1, int l2, int k) {
		
		int[] common = new int[l1+l2];
		int i = 0, j = 0, x = 0;
		
		while(true) {
			
			if(i < l1) {
				if(arr1[i] < arr2[j]) common[x++] = arr1[i++];
			}			
			if(j < l2) {
				if(arr1[i] > arr2[j]) common[x++] = arr2[j++];
			}
			if((i+j) == (l1+l2)) return common[k-1];
		}
	}
	
	public int findKth(int[] arr1, int l1, int[] arr2, int l2, int k) {

		if (k > (l1+l2) || k < 1) return -1;
		   
		  // let m <= n
		  if (l2 > l1) return findKth(arr2, l2, arr1, l1, k);
		   
			// if arr2 is empty returning k-th element of arr1
		  if (l2 == 0) return arr1[k - 1];
		  
		  // if arr1 is empty returning k-th element of arr2
		  else if (l1 == 0) return arr2[k - 1];
		   
		  // if k = 1 return minimum of first two elements of both arrays 
		  if (k == 1) return Math.min(arr1[0], arr2[0]);
		   
		  // now the divide and conquer part
		  int i = Math.min(l1, k / 2), j = Math.min(l2, k / 2);
		   
		  if (arr1[i - 1] > arr2[j - 1] ) 
		    // Now we need to find only k-j th element since we have found out the lowest j
		    return findKth(arr1, l1, arr2, l2 - j, k - j);
		  else
		    // Now we need to find only k-i th element since we have found out the lowest i
		    return findKth(arr1, l1 - i, arr2, l2, k - i);
	}
}
