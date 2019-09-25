package com.hyend.data.storage.arrays;

/**
 * 
 * @author gopi_karmakar
 */
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 9, 11};
		int[] b = {2, 5, 6, 8, 10};
		
		System.out.println(findMedian(a, b));
	}
    
    /**
     * A program to find the Kth smallest number
     * as well as the median of an array. if the 
     * k = n/2 where n is the lenght of an array.    
     */
    public static double findMedian(int[] a, int[] b) {
    	
    	double res = 0.0;
    	int n = a.length;
    	int m = b.length;
    	int k = (n+m)/2;
    	int[] arr = new int[(n + m)];
    	
    	for(int x = 0; x < n; x++) arr[x] = a[x];
    	for(int y = 0; y < m; y++) arr[(n+y)] = b[y];
    	
    	int low = 0, hi = arr.length -1;
        while (hi > low) {
           int j = partition(arr, low, hi);
           if (j == k)  {
        	   if(k%2 == 0) {
        		   return (arr[j-1]+arr[k])/2;
        	   }
        	   else
        		   return arr[k];
           }
           else if (j > k)  hi = j - 1;
           else if (j < k)  low = j + 1;           
        }         
        return res;    
    }
    
    private static int partition(int[] arr, int low, int high) {
    	
    	int i = low, j = high+1, v = arr[low];    	
    	    	 
         while (true)
         {  // Scan right, scan left, check for scan complete, and exchange.
            while (minimum(arr[++i], v)) if (i == high) break;
            while (minimum(v, arr[--j])) if (j == low) break;
            if (i >= j) break;
            exchange(arr, i, j);
         }    	
         exchange(arr, low, j); 
         
         //System.out.println("Value of i = " + i);
         return j;
    }
    
    private static boolean minimum(int a, int b) { 
        return a < b ? true : false;  
    }
    
    private static void exchange(int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
}
