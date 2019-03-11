package com.hyend.logical.designs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution: Given a list of candidates with name and the timestamp of their receiving vote.
 * 			 reply the total no. of votes received by a candidate in a given timestamp.
 * 
 * It was a Google Telephonic Interview Question found in LeetCode.
 *  
 * @author gopi_karmakar
 *
 */
public class Elections {
	
	private Map<String, Candidate> candidates;

	public Elections() {
		candidates = new HashMap<>();
	}
	
	static class InputVote {		
		int time;
		String name;		
	}

	class Candidate {

		// It'll be the total no. of votes received by candidate.
		private int totalVotes;
		
		private int time;
		
		String name;	
		
		// It'll hold the total no. of votes for a particular timestamp.
		Map<Integer, Integer> times = new HashMap<>();
		
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

	private void replace(Candidate guy, int time) {

		guy.totalVotes += 1;
		guy.times.put(time, guy.totalVotes);
		candidates.put(guy.name, guy);
	}

	public void put(List<InputVote> votesList) {

		for(InputVote x : votesList) {

			Candidate vote = candidates.get(x.name);
			if(vote != null) {
				replace(vote, x.time);
			}
			else {
				vote = new Candidate(x.name, x.time);
				candidates.put(x.name, vote);
			}
		}
	}

	public Candidate getVoteCount(int time) {

		List<Candidate> list = new ArrayList<>(candidates.values());
		
		new ArrayList<Integer>() ;

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