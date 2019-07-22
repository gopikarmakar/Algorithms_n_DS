package com.hyend.logical.algorithms.recursive;

import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.Objects;

public class TestRecursion {
	
	public static void recursive(int[] arr, int l, int h) {
		
		if(h <= l) return;
		int m = l + (h - l)/2;
		recursive(arr, l, m);
		recursive(arr, m+1, h);
		PrintMSG("l = " + l + " m = " + m + " h = " + h);
	}
	
	public static void main(String[] args) {
		//Factorial fact = new Factorial();		
		//PrintMSG(fact.recursiveFactorial(4));
		
		//StudentAttendance sa = new StudentAttendance();
		//PrintMSG(sa.waysToGetPenalty(5));
		//int[] arr = {6,3,2,1,5,4,9,7,10,8};
		//recursive(arr, 0, arr.length-1);
		
		Fibonacci fib = new Fibonacci();
		PrintMSG("Fibonacci Sum = " + fib.findFibMemoized(1000));
		
		/*ArrayList<Integer> keys = new ArrayList<>();
		keys.add(1);
		keys.add(1);
		keys.add(2);
		Permutations charPerm = new Permutations(keys);*/
		
		//StudentAttendance sa = new StudentAttendance();
		//Permutations p = new Permutations();
		//p.anagramStringPermutations("AABB");
		//PrintMSG("Total Ways = " + p.totalPemutations( 3, 1, 2, ""));
		//Combinations comb = new Combinations(3);
	}
	
	private static void PrintMSG(Object msg) {
		System.out.println(msg);
		Objects.hash(10, 20);		
	}
}
