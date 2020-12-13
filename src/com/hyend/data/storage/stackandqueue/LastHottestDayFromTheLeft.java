package com.hyend.data.storage.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A Google, Amazon interview question:
 * 
 * It's a variation of below problem:
 * https://leetcode.com/problems/daily-temperatures/
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
		
		int[] T = {70, 60, 40, 50, 35, 90, 10};
		//int[] temperatures = {70, 60, 45, 40, 50, 35, 90, 10};
		//int[] temperatures = {30, 60, 40, 50, 35, 90, 10};
		
		int[] result = hottestDays(T);
		
		for(int x: result)
			System.out.println(x);
	}
	
	/**
	 * An O(n) solution
	 */
	private static int[] hottestDays(int...T) {
		
		int[] result = new int[T.length];
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i = 0; i < T.length; i++) {
			
			while(!dq.isEmpty() && T[i] >= dq.peekLast())
				dq.pollLast();
			
			result[i] = (dq.isEmpty()) ? -1 : dq.peekLast();
			
			dq.addLast(T[i]);
		}

		return result;
	}
}
