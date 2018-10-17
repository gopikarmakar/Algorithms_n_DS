package com.hyend.logical.algorithms;

public class PalindromeString {

	public void isItAPalindrome(String str) {
		str = str.toLowerCase();
		int fullLength = str.length()-1;
		int halfLength = (fullLength)/2;
		int i = halfLength, j = halfLength;
		for(; i > 0; i-=1, j+=1) {
			if(str.charAt(i) != str.charAt(j)) {
				System.out.println("Loop's broken coz " + str.charAt(i) + 
						" = " + str.charAt((j)));	
				break;
			}
		}
		System.out.println("Full Length = " + str.length() + 
				" Half Length = " + halfLength + " i = " + i + " j = " + j);
		
		if(i == 0 && j == fullLength)
			System.out.println("It's a Palindrome String!");
		else
			System.out.println("It's not a Palindrome String!");
	}
	
	/**
	 * It just simply checks the addition of the ascii value 
	 * of the two halves of the string, non reversed and reversed halves. 
	 * If both are equal then the string can be formed as a Palindrome string else not. 
	 * As simple as that!
	 * 
	 * @param str
	 * @return
	 */
	public boolean canItBeAPalindrome(String str) {
		str = str.toLowerCase();
		int fullLength = str.length()-1;		
		int halfLength = (fullLength)/2;
		int i = 0, j = fullLength;
		int leftTotal = 0, rightTotal = 0;
		for(; i < halfLength; i+=1) {
			leftTotal = leftTotal + (int)str.charAt(i);
			rightTotal = rightTotal + (int)str.charAt(j-i);
		}		
		return (leftTotal == rightTotal) ? true : false;
	}
}
