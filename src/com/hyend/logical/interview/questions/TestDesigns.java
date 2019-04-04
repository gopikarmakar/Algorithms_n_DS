package com.hyend.logical.interview.questions;

import java.util.List;
import java.util.ArrayList;

import com.hyend.logical.interview.questions.google.Elections;
import com.hyend.logical.interview.questions.google.Elections.Candidate;

public class TestDesigns {
	
	public static void main(String[] args) {
		
		Elections e = new Elections();
		int time = 101;
		e.put(createSampleData());
		Candidate member = e.getVoteCount(time);
		printMsg(member.getName() + " Received " + member.getTotalVotesAt(time) + " Votes At " + time + " Timestamp");
	}

	private static List<Elections.InputVote> createSampleData() {
		
		List<Elections.InputVote> votes = new ArrayList<>();
		Elections.InputVote[] vote = new Elections.InputVote[6];
		for(int i = 0; i < vote.length; i++)
			vote[i] = new Elections.InputVote();
		
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
	
	private static void printMsg(String msg) {		
		
		System.out.println(msg);
	}
}
