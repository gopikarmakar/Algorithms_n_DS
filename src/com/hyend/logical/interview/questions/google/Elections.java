package com.hyend.logical.interview.questions.google;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution: 
 * Given a list of candidates with name and the timestamp of their receiving vote.
 * reply the total no. of votes received by a candidate in a given timestamp.
 * 
 * It was a GTI Question found in LeetCode.
 *  
 * @author gopi_karmakar
 */
public class Elections {
	
	private Map<String, Candidate> candidates;

	public Elections() {
		candidates = new HashMap<>();
	}
	
	public static class InputVote {
		public int time;
		public String name;		
	}

	public class Candidate {

		//Total no. of votes received by candidate.
		private int totalVotes;
		
		private int time;
		
		private String name;	
		
		// Mapping the total no. of votes at a particular timestamp.
		private Map<Integer, Integer> times = new HashMap<>();
		
		public Candidate(Candidate member) {
			this.name = member.name;			
			this.totalVotes = times.get(member.time);
		}

		Candidate(String name, int time) {			
			totalVotes += 1;
			this.name = name;	
			times.put(time, totalVotes);
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getTotalVotesAt(int time) {
			return times.put(time, totalVotes);
		}
	}

	private void mapAndIncrementVoteCount(Candidate candidate, int time) {

		candidate.totalVotes += 1;
		candidate.times.put(time, candidate.totalVotes);
		candidates.put(candidate.name, candidate);
	}

	public void put(List<InputVote> votesList) {

		for(InputVote x : votesList) {

			Candidate candidate = candidates.get(x.name);
			if(candidate != null) {
				mapAndIncrementVoteCount(candidate, x.time);
			}
			else {
				candidate = new Candidate(x.name, x.time);
				candidates.put(x.name, candidate);
			}
		}
	}

	public Candidate getVoteCount(int time) {
		
		Collection<Candidate> list = candidates.values();

		if(list.size() == 0)
			return null;

		Candidate vote = null;
		for(Candidate v : list) {

			if(v.times.containsKey(time)) {
				vote = v; 
				break;
			}
		}		
		return vote;
	}
}