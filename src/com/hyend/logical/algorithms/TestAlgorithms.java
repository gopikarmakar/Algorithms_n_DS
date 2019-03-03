package com.hyend.logical.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestAlgorithms {
	
	public static void main(String[] args) {
		
		int[] arr = {8, 9, 7, 12, 11, 10, 1};
		int[] seats = {1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1};
		
		/*FindFirstMissingPositive findMinPositive = 
				new FindFirstMissingPositive();
		
		int result = findMinPositive.findFirstMinPositive(arr);
		
		System.out.println("First Minimum Positive = " + result);*/
		
		//Exponent power = new Exponent();
		//printMsg("" + power.myPow(0.00001, 2147483647));
		//printMsg(""+ 1/4);			
		
		//UniformRandom uRand = new UniformRandom();
		//printMsg(""+ uRand.uniformRandom(5, 6));
		
		
		//MaximumDistanceToTheClosestPerson mdttcp = new MaximumDistanceToTheClosestPerson();
		//mdttcp.maximumDistanceToTheClosestPerson(seats);
		
		PrintMinNumberOfIDPattern minNumberPattern = new PrintMinNumberOfIDPattern();
		String pattern = minNumberPattern.printMinNumberForPattern("DI");
		printMsg(pattern);
		//GCD gcd = new GCD();
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		//MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
		//double res = median.findMedian(nums1, nums2);	
		//printMsg("median = "+res);
		//printMsg("Max Zeroes = " + new MaxZerosByFlipping().getMaxZeroes(seats));
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {2, 4, 6, 8};
		int[] arr3 = {3, 7, 9};		
		
		//MultiwayMerge mMerge = new MultiwayMerge();
		//int[][] keys = {arr1, arr2, arr3};
		//mMerge.merge(keys);
	}
	
	private static void printMsg(String msg) {		
		System.out.println(msg);
	}
}
