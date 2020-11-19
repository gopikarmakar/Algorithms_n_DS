package com.hyend.data.storage.structures.graphs.directed;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-similar-strings/
 * It's not a full proof solution
 * 
 * @author gopi_karmakar
 */
public class KSimilarStrings {

	public static void main(String[] args) {
		
		String a = "abac";
		String b = "baca";
		
		System.out.println(kSimilarity(a, b));
	}
	
	private static int kSimilarity(String a, String b) {
		
		Queue<String> q = new LinkedList<>();
		q.add(a);
		int cnt = 0;
		Set<String> visited = new HashSet<>();
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for(int k = 0; k < size; k++) {
				a = q.poll();			
			
				if(a.equals(b)) return cnt;
			
				int i = 0;
				while(a.charAt(i) == b.charAt(i)) i++;
				
				for(int j = i+1; j < b.length(); j++) {
					
					if(a.charAt(i) != b.charAt(j)) continue;
					
					String temp = swap(i, j, a);
					
					if(visited.add(temp)) q.add(temp);
				}
			}
			cnt++;
		}
		return -1;
	}
	
	private static String swap(int i, int j, String a) {
		
		char[] A = a.toCharArray();		
		char t = A[i];
		A[i] = A[j];
		A[j] = t;
		return new String(A);
	}
}
