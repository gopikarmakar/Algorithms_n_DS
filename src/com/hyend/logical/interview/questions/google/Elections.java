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

	private void mapAndIncrementVoteCount(Candidate guy, int time) {

		guy.totalVotes += 1;
		guy.times.put(time, guy.totalVotes);
		candidates.put(guy.name, guy);
	}

	public void put(List<InputVote> votesList) {

		for(InputVote x : votesList) {

			Candidate vote = candidates.get(x.name);
			if(vote != null) {
				mapAndIncrementVoteCount(vote, x.time);
			}
			else {
				vote = new Candidate(x.name, x.time);
				candidates.put(x.name, vote);
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