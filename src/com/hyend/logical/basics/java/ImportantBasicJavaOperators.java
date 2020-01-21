package com.hyend.logical.basics.java;

import java.util.BitSet;

public class ImportantBasicJavaOperators {

	public static void main(String...args) {
		functions();
		//shiftOperation();
		//bitwiseOperation();		
    }
	
	private static void bitwiseOperation() {
		//Initial values 
        int a = -5; 
        int b = 7; 
  
        /*
         * bitwise and
         * 0101 & 0111 = 0101 = 5 
         */       
        System.out.println("a & b = " + (a & b)); 

        /*
         * bitwise or
         * 0101 | 0111 = 0111 = 7 
         */  
        System.out.println("a | b = " + (a | b)); 
  
        /*
         * bitwise XOR
         * 0101 ^ 0111 = 0010 = 2 
         */  
        System.out.println("a ^ b = " + (a ^ b)); 
  
        /*
         * bitwise and
         * ~0101 = 1010
         * will give 2's complement of 1010 = -6 
         */  
        System.out.println("~a = " + ~a); 
  
        /*
         * can also be combined with
         * assignment operator to provide shorthand 
         * assignment 
         * a = a & b  
         */        
        a &= b; 
        System.out.println("a= " + a);		
	}
	
	private static void shiftOperation() {
		//Initial values 
        int a = 1; 
        int b = -10; 
  
        /*
         * Signed Left Shift
         * 1 << 5 = (1 * (2 ^ 5)) = 32 
         */  
        System.out.println(a + " << " + "5" + " = " + (a << 5));
        System.out.println(b + " << " + "5" + " = " + (b << 5));
                        
        /*
         * Signed Right Shift
         * 10 >> 1 = (10 / (2 ^ 1)) = 5 
         */        
        System.out.println(b + " >> " + "1" + " = " + (b >> 1));
        
        /*
         * UnSigned Right Shift
         * Will not reserve the signed bit      
         */        
        System.out.println(b + " >>> " + "5" + " = " + (b >>> 5));
	} 
	
	private static void functions() {
		
		//Initial values 
        int a = 2; 
        int b = 5;
        
        System.out.println("Math.abs(2-5)		= " + Math.abs(a-b));
        
        System.out.println("Math.abs(-34.5)		= " + Math.abs(-34.5));
        System.out.println("Math.ceil(2.17)		= " + Math.ceil(2.17));
        System.out.println("Math.floor(2.17)  	= " + Math.floor(2.17));
        System.out.println("Math.pow(a , b)  	= " + Math.pow(a , b));
        System.out.println("Math.sqrt(16)  		= " + Math.sqrt(16));
	}
}
