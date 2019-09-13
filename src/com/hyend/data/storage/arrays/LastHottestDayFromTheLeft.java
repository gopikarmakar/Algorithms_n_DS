package com.hyend.data.storage.arrays;

import java.util.Arrays;

/**
 * A Google, Amazon interview question:
 * 
 * Given temperatures of a whole week in Celcius
 * return the hottest day from the left for each passing day
 * return -1 for the no previous hottest day.
 * 
 * for e.g:  {70, 60, 40, 50, 35, 90, 10}
 * return:   {-1, 70, 60, 60, 50, -1, 90}
 * 
 * Variant: Stock Span Problem.
 *
 * @author gopi_karmakar
 */
public class LastHottestDayFromTheLeft {

	public static void main(String[] args) {
		
		int[] temperatures = {70, 60, 40, 50, 35, 90, 10};
		//int[] temperatures = {70, 60, 45, 40, 50, 35, 90, 10};
		//int[] temperatures = {30, 60, 40, 50, 35, 90, 10};
		
		int[] result = hottestDays(temperatures);
		
		for(int x: result)
			System.out.println(x);
	}
	
	/**
	 * An O(n) solution
	 */
	private static int[] hottestDays(int...temperatures) {
		
		int[] result = new int[temperatures.length];
		Arrays.fill(result, -1);
		
		int max = temperatures[0];
		for(int i = 1; i < temperatures.length; i++) {					
					
			if(max > temperatures[i-1] && temperatures[i-1] > temperatures[i]) {
				max = temperatures[i-1];				
			}			
			
			if(max >= temperatures[i])
				result[i] = max;
			else 
				max = temperatures[i];
		}		
		return result;
	}
}
