package com.hyend.logical.algorithms;

public class MedianOfTwoSortedArrays {
      
    // Function to find minimum 
    private boolean minimum(int a, int b) { 
        return a < b ? true : false;  
    }
    
    private void exchange(int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
    
    private int partition(int[] arr, int low, int high) {
    	
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
    
    /**
     * A program to find the Kth smallest number
     * as well as the median of an array. if the 
     * k = n/2 where n is the lenght of an array.
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedian(int[] nums1, int[] nums2) {
    	
    	double res = 0.0;
    	int n = nums1.length;
    	int m = nums2.length;
    	int k = (n+m)/2;
    	int[] arr = new int[(n + m)];
    	
    	for(int x = 0; x < n; x++) arr[x] = nums1[x];
    	for(int y = 0; y < m; y++) arr[(n+y)] = nums2[y];
    	
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
}
