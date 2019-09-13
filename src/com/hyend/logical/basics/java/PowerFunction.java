 package com.hyend.logical.basics.java;

 /**
  * Java Power function
  *  
  * @author gopi_karmakar
  */
public class PowerFunction {
	
	public static void main(String[] args) {
		
		//System.out.println(Math.floor(Integer.MAX_VALUE));
		
		//System.out.println(Math.pow(3, -2));
		
		//System.out.println(myPow(2, -2));
		
		System.out.println(Math.pow(3, 0.2));
	}
		
	public static double myPow(double x, double n) {
		
		boolean negative = false;
		double result = 1.0;
		
		if(n >= Integer.MAX_VALUE || n <= (Integer.MIN_VALUE))
            return Math.floor(x * 100) / 100;        
            		
		if(n < 0 && !negative) {
			n = Math.abs(n);			
			negative = true;
		}
		
		for(double i = n; i >= 1; i--) {
			result *= x; 
		}
		
		return (negative) ? (100/result)*0.01 : result;
	}
}