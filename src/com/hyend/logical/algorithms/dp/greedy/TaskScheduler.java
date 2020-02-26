package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z 
 * where different letters represent different tasks. Tasks could be done without original order. 
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be 
 * at least n intervals that CPU are doing different tasks or just be idle.
 *
 * Need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * for e.g: {'A', 'A', 'A', 'B', 'B', 'B'}  n = 2
 * 			A -> B -> Idle -> A -> B -> Idle A->B
 * 
 * 
 * @author gopi_karmakar
 */
public class TaskScheduler {

	public static void main(String[] args) {	
		
		System.out.println(leastInterval(2, 'A', 'A', 'A', 'B', 'B', 'B'));
	}
	
	/**
	 * Time complexity : O(n). We iterate over tasks array only once.
	 * In worst case sorting can take O(n log (n)) time if there're a lot of different tasks
	 * Otherwise Sorting tasks array of length n takes O(26log(26)) = O(1) time. 
	 * After this, only one iteration over 26 elements of map is done.
	 * 
	 * Space complexity will O(1)
	 */
	private static int leastInterval(int n, char...tasks) {
		
        int[] map = new int[26];
        
        for (char c: tasks) {
        	
        	//map[c - 'A']++;
            map[c - 'A'] += 1;
        }               
        
        Arrays.sort(map);
        
        for(int x : map)
        	System.out.println(x);
        
        int max_val = map[25] - 1, idle_slots = max_val * n;               
        
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
        	
            idle_slots -= Math.min(map[i], max_val);
        }
                
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
