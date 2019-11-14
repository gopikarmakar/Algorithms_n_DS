package com.hyend.logical.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class TestStrings {
	
	public static void main(String[] args) {
		
		//IsARotation isRotation = new IsARotation();
		//System.out.println(isRotation.isRotation("waterbottle", "erbottlewat"));
		
		//AnagramString anagram = new AnagramString();
		//boolean val = anagram.isItAnagramString("INTEGRAL", "TRIANGLE");¥
		
		
		//System.out.println(new ZigZagConversion().convert("paypalishiring", 4));
		
		//KMPSubstringPatternSearch kmp = new KMPSubstringPatternSearch();
		//RabinKarpPatternMatching rabin = new RabinKarpPatternMatching();
		//System.out.println("Is It A Match = " + rabin.isPatternMatched("abcxabcdabcdabcy", "abcdabcy"));
		
		//LongestPalindromeSubString lps = new LongestPalindromeSubString();
		//printMsg(lps.palindromicSubString("bb"));
		//Palindromicity palindrome = new Palindromicity();
		/*LongestCommonSubstring lss = new LongestCommonSubstring();
		int length = lss.getLCS("geeksforskeeg", "skeeggggeeeeksfor");
		printMsg(""+length);*/
				
		MatchNamesParity c = new MatchNamesParity();
		List<String> list = new ArrayList<>();
		list.add("ababaa");
		List<Integer> l1 = c.prefix(list);		
		for(int i : l1) {
			printMsg("" + i);
		}
	}
	
	private static void printMsg(String msg) {		
		System.out.println(msg);
	}
}