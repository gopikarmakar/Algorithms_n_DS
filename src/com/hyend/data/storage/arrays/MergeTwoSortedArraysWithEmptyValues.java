package com.hyend.data.storage.arrays;

/**
 * Merge two sorted arrays which can contain empty entries:
 * For e.g:
 * a[] = {5, 13, 17, 19, 0, 0, 0, 0}
 * b[] = {3, 7, 11, 0}
 * return a[] = {3, 5, 7, 11, 13, 17, 19, 0}
 * NOTE: Always assume a.length > b.length and 0 means an empty entry.
 * @author gopi_karmakar
 */
public class MergeTwoSortedArraysWithEmptyValues {

	public static void main(String[] args) {
		int[] a = {5, 13, 17, 19, 0, 0, 0, 0};
		int[] b = {3, 7, 11, 0};
		for(int x : merge(a, b)) 
			System.out.print(x+ " ");
	}
	
	/**
	 * O(n) time complexity
	 */
	private static int[] merge(int[] a, int[] b) {		
		
		int n = a.length-1, m = b.length-1;		
		for(int i = n; i >= 0; --i) {
			if(a[i] != 0) break;
			n--;
		}	
		for(int j = m; j >= 0; --j) {
			if(b[j] != 0) break;
			m--;
		}
		
		int i = n, j = m, writeIdx = n + m + 1;
		while(i >= 0 && j >= 0) {			
			a[writeIdx--] = ((a[i] < b[j])) ? b[j--] : a[i--];			
		}
		int x = (m < n) ? j : i;
		while(x >= 0) {
			a[writeIdx--] =  (m < n) ? b[x--] : a[x--];
		}
		return a;
	}			
}
