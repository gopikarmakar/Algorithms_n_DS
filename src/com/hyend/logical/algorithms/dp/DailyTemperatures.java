package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * @author gopi_karmakar
 */
public class DailyTemperatures {

	public static void main(String[] args) {
		
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		//int[] T = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
		
		dailyTemperatures(T);
	}
	
	private static void dailyTemperatures(int[] T) {	
				
		int warmestDay = T[0], daysCount = 0, day = 0;
		
		int[] res = new int[T.length];
			
		for(int i = 1; i < T.length; i++) {
			
			daysCount += 1;
			if(T[i] > warmestDay) {
				res[day++] = daysCount;				
				daysCount = 0;
				i = day;
				warmestDay = T[i];				
			}
			else if(i == T.length-1 && day != i) {
				daysCount = 0;
				res[day++] = daysCount;	
				i = day;				
				warmestDay = T[i];								
			}				
		}
		System.out.println("Warmest Day = "+warmestDay);
		for(int x : res) {
			System.out.println(x);
		}
	}
}
