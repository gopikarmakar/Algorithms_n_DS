package com.hyend.logical.algorithms.dp.greedy;

/**
 * Find the majority element from a pool of elements
 * in O(n) time and without using any extra memory. 
 * 
 * @author gopi_karmakar
 */
public class MajorityElement {

	public static void main(String[] args) {
		
		String[] keys = {"b","a","c","a","a","b","a","a","c","a"};
		System.out.println("Majority Element = " + majority(keys));
	}
	
	/**
	 * O(n) Time complexity with O(1) extra space.
	 */
	private static String majority(String...keys) {
		
		int count = 0;
		String element = "";
		
		for(String k : keys) {
			
			if(count == 0) {
				element = k;
				count += 1;
			}
			else if(element.equals(k))
				count++;
			else
				count--;
		}		
		return element;
	}
}