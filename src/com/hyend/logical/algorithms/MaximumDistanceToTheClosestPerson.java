package com.hyend.logical.algorithms;

import java.util.ArrayList;

public class MaximumDistanceToTheClosestPerson {
	
	public int maximumDistanceToTheClosestPerson(int[] seats) {
				
		int maxDistance = 0;
		int totalSeats = seats.length;
		if(totalSeats == 0 || totalSeats == 1)
			return maxDistance;
		
		int index = 0;
		ArrayList<Integer> occupiedSeats = new ArrayList<>();        				
		for(int status : seats) {
			if(status == 1)				
				occupiedSeats.add(index+1);
			index++;
		}
		if(!occupiedSeats.isEmpty()) { 		
			if(occupiedSeats.size() == 1)
				maxDistance = totalSeats-1;
			else {
				index = 0;
				int emptySeats = occupiedSeats.get(index);
				for(index = 0; index < occupiedSeats.size()-1; index++) {
					int nextEmptySeats = occupiedSeats.get(index+1) - occupiedSeats.get(index);
					if(nextEmptySeats > emptySeats)
						emptySeats = nextEmptySeats;
				}
				if(emptySeats % 2 == 0)
					maxDistance = emptySeats/2;
				else
					maxDistance = emptySeats - 1;
			}
		}
		return maxDistance;
    }
}
