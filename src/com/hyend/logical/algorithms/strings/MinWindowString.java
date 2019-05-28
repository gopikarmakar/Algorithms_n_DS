package com.hyend.logical.algorithms.strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

// TODO: Wrong Implementation I need to improve it
public class MinWindowString {
	
	public static void main(String...args) {
		printMSG("" + minWindow("bdab", "ab"));
	}

	private static String minWindow(String s, String t) {
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		if(s == null || t == null ||
				s.isEmpty() || t.isEmpty())
			return "";
    
		s = s.toLowerCase();
		t = t.toLowerCase();
		int length = t.length()-1;
		int index = 0, startWindow = 0, windowCount = 0, minWindow = 0;
		boolean[] tx = new boolean[26];

		for(char c : t.toCharArray()) {
			tx[c - 'a'] = true;
		}

		int tl = length;    
		boolean shouldStart = false;
        for(char c : s.toCharArray()) {        	
        	if(tx[c  - 'a']) {
        		if(!shouldStart) {
        			startWindow = index;
        			shouldStart = true;
        		}
        		if(tl != 0) tl--;
        		else {
        			windowCount+=1;
        			if(minWindow == 0) minWindow = windowCount;
        			else if(windowCount < minWindow) minWindow = windowCount;        			        			
        			tl = length;
        			windowCount = 0;
        			shouldStart = false;
        		}		
        	}
        	if(shouldStart)
        		windowCount+=1;
        	index+=1;
        }
        System.out.println(minWindow);
        return s.substring(startWindow, startWindow+minWindow);
    }
	
	private static void printMSG(String msg) {		
		System.out.println(msg);
	}
}
