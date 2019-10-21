package com.hyend.data.storage.structures.hashtable;

import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.Sequence;

/**
 * Test the Collatz conjecture for the first n positive integers.
 * 
 * The Collatz conjecture is the following: 
 * Take any natural number. If it is odd, triple it and add one; if it is even, halve it. 
 * Repeat the process indefinitely. No matter what number you begin with, you will eventually arrive at 1.
 * for e.g: if we start with 11 we get the sequence 11,34,17,52,26,13,40, 20,10,5,16,8,4,2,1. 
 * Despite intense efforts, the Collatz conjecture has not been proved or disproved.
 * 
 * @author gopi_karmakar
 */
public class CollatzConjecture {

	public static void main(String[] args) {
		System.out.println(find(11));
	}
	
	/**
	 * 1: Reuse computation by storing all the numbers you have already proved to converge to 1; 
	 * that way, as soon as you reach such a number, you can assume it would reach 1.
	 * 2: To save time, skip even numbers (since they are immediately halved, and the resulting 
	 * number must have already been checked).
	 * 3: If you have tested every number up to k, you can stop the chain as soon as you reach 
	 * a number that is less than or equal to k. You do not need to store the numbers below k in the hash table.
	 * 4: If multiplication and division are expensive, use bit shifting and addition.
	 * 5:Partition the search set and use many computers in parallel to explore the subsets.
	 * 
	 * We cannot say much about time complexity beyond the obvious, namely that it is at least proportional to n.
	 */
	private static boolean find(int n) {
		
		Set<Long> verifiedNumbers = new HashSet<>();		
		for(int i = 3; i <=n; ++i) {
			Set<Long> sequence = new HashSet<>();
			long testI = i;
			while(testI >= i) {
				if(!sequence.add(testI)) {
					/** 
					 * We previously encountered testI, so the Collatz sequence has fallen into a loop. 
					 * This disproves the hypothesis, so we short-circuit, returning false.
					 */
					return false;
				}
				
				if(testI % 2 != 0) {
										
					if(!verifiedNumbers.add(testI)) {
						// testI has already been verified to converge to 1.
						break;
					}
					long newtestI = 3 * testI + 1;
					if(newtestI <= testI)
						throw new ArithmeticException("Collatz sequence overflow for " + i);
					testI = newtestI;							
				}
				else {
					// Even number, halve it.
					testI /= 2;
				}
			}
		}
		System.out.println(verifiedNumbers);
		return true;
	}
}
