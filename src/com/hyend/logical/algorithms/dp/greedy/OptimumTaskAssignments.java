package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm that takes as input a 
 * set of tasks and returns an optimum assignment.
 * Such that all tasks finish with in the maximum assignments.
 * 
 * We consider the problem of assigning tasks to workers. 
 * Each worker must be assigned exactly two tasks. 
 * Each task takes a fixed amount of time and are independent,
 * i.e., there are no constraints of the form 
 * "Task 4 cannot start before Task 3 is completed." 
 * Any task can be assigned to any worker.
 *
 * We want to assign tasks to workers so as to minimize how long 
 * it takes before all tasks are completed. For example, if there 
 * are 6 tasks whose durations are 5, 2, 1, 6, 4, 4 hours, 
 * then an optimum assignment is to give the first two tasks 
 * (i.e., the tasks with duration 5 and 2) to one worker, 
 * the next two (1 and 6) to another worker, and the 
 * last two tasks (4 and 4) to the last worker. 
 * For this assignment, all tasks will finish with in the 
 * max(5 + 2, 1 + 6, 4 + 4) = 8 hours.
 * 
 */
public class OptimumTaskAssignments {
	
	public static void main(String[] args) {
		int[] durations = {5,2,1,6,4,4};
		OptimumTaskAssignments tasks = new OptimumTaskAssignments();
		List<PairedTasks> assignments = tasks.optimumTaskAssignment(durations);
		
		for(PairedTasks pairs : assignments) {		
			System.out.println(pairs.toString());
		}				
	}
	
	private class PairedTasks {
		public int task1;
		public int task2;
		
		public PairedTasks(int task1, int task2) {
			this.task1 = task1;
			this.task2 = task2; 
		}
		
		@Override
		public String toString() {
			String msg = "[" + task1 + ", " + task2 + "]";
			return msg;
		}
	}

	/**
	 * Solution: We sort the set of task durations, and pair the shortest, 
	 * second shortest, third shortest, etc. tasks with the longest, 
	 * second longest, third longest, etc. tasks. 
	 * For example, if the durations are 5, 2, 1, 6, 4, 4, 
	 * then on sorting we get 1, 2, 4, 4, 5, 6, 
	 * and the pairings are (1,6), (2,5), and (4,4).
	 * 
	 * The time complexity is dominated by the Sort time On(log n)
	 *  
	 * @param durations
	 * @return
	 */
	public List<PairedTasks> optimumTaskAssignment(int...durations) {
		
		Arrays.sort(durations);
		
		List<PairedTasks> assignments = new ArrayList<>();
		
		for(int i = 0, j = durations.length-1; i < j; ++i,--j)
			assignments.add(new PairedTasks(durations[i], durations[j]));
			
		return assignments;
	}
}
