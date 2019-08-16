 package com.hyend.logical.algorithms.dp;

public class Exponent {
	
	boolean negative = false;
	double result = 1.0;
	
	public double myPow(double x, int n) {
		
		if(n >= Integer.MAX_VALUE || n <= -(Integer.MAX_VALUE))
            return Math.floor(x * 100) / 100;        
            		
		if(n < 0 && !negative) {
			n = -(n);			
			negative = true;
		}
		
		for(int i = n; i >= 1; i--) {
			result *= x; 
		}		
		
		return (negative) ? (100/result)*0.01 : result;		
	}
}
