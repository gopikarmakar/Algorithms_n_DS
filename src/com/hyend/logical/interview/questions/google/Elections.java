package com.hyend.logical.interview.questions.google;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution: Given a list of candidates with name and the timestamp of their receiving vote.
 * reply the total no. of votes received by a candidate in a given timestamp.
 * 
 * It was a GTI Question found in LeetCode.
 *  
 * @author gopi_karmakar
 */
public class Elections {
	
	public static void main(String[] args) {
		
		Elections e = new Elections();
		e.put(createSampleData());
		
		int time = 102;
				
		Candidate candidate = e.getVoteCount(time);
		
		String msg = candidate.getName() + " Received " + candidate.getTotalVotesAt(time) + " Votes By " + time + " Timestamp";
		
		System.out.println(msg);
	}
	
	private Map<String, Candidate> election;

	public Elections() {
		election = new HashMap<>();
	}

	public class Candidate {	
		
		private String name;
		
		//Total no. of votes received by candidate.
		private int totalVotes;
		
		// Mapping the total no. of votes at a particular time stamp.
		private Map<Integer, Integer> votesCount = new HashMap<>();
		
		public Candidate() {}

		Candidate(String name, int time) {	
			this.name = name;	
			votesCount.put(time, totalVotes);
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getTotalVotesAt(int time) {
			return votesCount.put(time, totalVotes);
		}
	}

	public void put(List<CastedVotes> votesList) {

		for(CastedVotes x : votesList) {

			Candidate candidate = election.getOrDefault(x.name, new Candidate(x.name, x.time));
			candidate.totalVotes += 1;
			candidate.votesCount.put(x.time, candidate.totalVotes);
			election.put(candidate.name, candidate);					
		}
	}

	public Candidate getVoteCount(int time) {
		
		Collection<Candidate> list = election.values();

		if(list.size() == 0)
			return null;

		for(Candidate candidate : list) {

			if(candidate.votesCount.containsKey(time)) {
				return candidate; 				
			}
		}		
		return null;
	}
	
	//////////////////////////////////////////// Sample Data Creation //////////////////////////////////////////
	
	public static class CastedVotes {
		public int time;
		public String name;		
	}
	
	private static List<Elections.CastedVotes> createSampleData() {	
		
		List<Elections.CastedVotes> votes = new ArrayList<>();
		
		Elections.CastedVotes[] vote = new Elections.CastedVotes[6];
		for(int i = 0; i < vote.length; i++)
			vote[i] = new Elections.CastedVotes();
		
		vote[0].name = "Amy"; vote[0].time = 97;
		vote[1].name = "Mark"; vote[1].time = 99;
		vote[2].name = "Cathy"; vote[2].time = 100;
		vote[3].name = "Amy"; vote[3].time = 101;
		vote[4].name = "Mark"; vote[4].time = 102;
		vote[5].name = "Amy"; vote[5].time = 103;
		
		for(int i = 0; i < vote.length; i++)
			votes.add(vote[i]);
		
		return votes;
	} 
}