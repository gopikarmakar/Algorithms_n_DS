package com.hyend.logical.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.hyend.logical.algorithms.Elections.Candidate;

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
		//String pattern = minNumberPattern.printMinNumberForPattern("DI");
		//printMsg(pattern);
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
		Elections e = new Elections();
		int time = 101;
		e.put(createSampleData());
		Candidate member = e.getVoteCount(time);
		printMsg(member.getName() + " Received " + member.getTotalVotesAt(time) + " Votes At " + time + " Timestamp");
	}
	
	
	private static List<Elections.InputVote> createSampleData() {
		
		List<Elections.InputVote> votes = new ArrayList<>();
		Elections.InputVote[] vote = new Elections.InputVote[6];
		for(int i = 0; i < vote.length; i++)
			vote[i] = new Elections.InputVote();
		
		vote[0].name = "Amy"; vote[0].time = 97;
		vote[1].name = "Mark"; vote[1].time = 99;
		vote[2].name = "Cathy"; vote[2].time = 100;
		vote[3].name = "Amy"; vote[3].time = 101;
		vote[4].name = "Mark"; vote[4].time = 102;
		vote[5].name = "Amy"; vote[5].time = 103;
		for(int i = 0; i < vote.length; i++)
			votes.add(vote[i]);
		
		return votes;
	}
	
	private static void printMsg(String msg) {		
		System.out.println(msg);
	}
}
