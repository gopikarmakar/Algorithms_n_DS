package com.hyend.logical.algorithms;

import java.util.Arrays;

/**
 * A Google Bangalore interview question.
 * 
 * Search in GFG for more details about what is Stock Span Means
 *   
 * @author gopi_karmakar
 *
 */
public class StockSpan {

	public void calculateSpan(int price[], int n, int S[]) { 
        // Span value of first day is always 1 
        S[0] = 1; 
          
        // Calculate span value of remaining days by linearly checking 
        // previous days 
        for (int i = 1; i < n; i++) 
        { 
            S[i] = 1; // Initialize span value 
              
            // Traverse left while the next element on left is smaller 
            // than price[i] 
            for (int j = i-1; (j>=0)&&(price[i]>=price[j]); j--) 
                S[i]++; 
        }
        
        System.out.print(Arrays.toString(S)); 
    }
}
