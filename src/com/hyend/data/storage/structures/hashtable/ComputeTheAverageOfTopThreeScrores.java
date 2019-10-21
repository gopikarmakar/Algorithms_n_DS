package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Student's multiple test scores are recorded in a file. Each line consists of a student ID, 
 * which is an alphanumeric string, and an integer between 0 and 100, inclusive.
 * 
 * Write a program which takes as input a file containing test scores and returns 
 * the student who has the maximum score averaged across his or her top three tests. 
 * If the student has fewer than three test scores, ignore that student
 * 
 * @author gopi_karmakar
 */
public class ComputeTheAverageOfTopThreeScrores {

	public static void main(String[] args) {
		
		compute(createSampleData());
	}
	
	/**
	 * Since we track at most three scores for a student, updating takes constant-time operation. 
	 * Therefore, the algorithm spends O(1) time per test score, yielding an O(n) time bound. 
	 * The space complexity is O(m), where m is the number of distinct students. 
	 * In the worst-case, m = O(n), but in the best-case it can be much better 
	 * for e.g., if there are only few students but lots of test scores.
	 */
	private static void compute(List<StudentRecord> list) {
		
		int topScore = 0;
		String topScorer = "No Such Student";
		final Map<String, PriorityQueue<Integer>> map = new HashMap<>();
				
		list.forEach(s -> {
			
			PriorityQueue<Integer> scores = map.getOrDefault(s.studentId, new PriorityQueue<Integer>());	
			
			scores.add(s.score);			
			if(scores.size() > 3)
				scores.poll();						
			
			map.put(s.studentId, scores);
		});
		
		for(Map.Entry<String, PriorityQueue<Integer>> e : map.entrySet()) {
			
			if(e.getValue().size() == 3) {
			
				int currentMaxScore = getAverageScore(e.getValue());
				if(currentMaxScore > topScore) {
					topScore = currentMaxScore;
					topScorer = e.getKey();
				}
			}
		}		
		System.out.println(topScorer + " with " + topScore + " score is the maximum score averaged in top three tests");
	}
	
	private static int getAverageScore(PriorityQueue<Integer> minPQ) {
		
		int avgScore = 0;		
		for(int x : minPQ) {				
			avgScore += x;
		}		
		return avgScore;
	}
	
	private static class StudentRecord {
		
		public String studentId;
		public int score;
		
		public StudentRecord(String studentId, int score) {
			this.studentId = studentId;
			this.score = score;
		}
	}
	
	private static List<StudentRecord> createSampleData() {

		String[][] studentScores = {{"A001", "30"}, {"B001", "91"}, {"C001", "89"}, {"D001", "95"}, 
								{"E001", "87"}, {"A001", "47"}, {"C001", "81"}, {"D001", "70"}, 
								{"B001", "43"}, {"E001", "75"}, {"A001", "80"}, {"C001", "90"}, 
								{"D001", "92"}, {"E001", "83"}, {"B001", "61"}, {"C001", "86"}, 
								{"F001", "75"}, {"A001", "33"}, {"F001", "89"}, {"E001", "90"}, 
								{"B001", "96"}};
		
		List<StudentRecord> list = new ArrayList<>();
		
		for(int i = 0; i < studentScores.length; ++i) {
			
			StudentRecord sr = new StudentRecord(studentScores[i][0], Integer.parseInt(studentScores[i][1]));
			list.add(sr);
		}		
		return list;
	}
}
