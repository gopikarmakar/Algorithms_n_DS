package com.hyend.data.storage.structures.priorityqueue;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Consider a coordinate system for the Milky Way in which Earth is at (0,0,0). 
 * Model stars as points, and assume distances are in light years. 
 * The Milky Way consists of approximately 10^12 stars, 
 * and their coordinates are stored in a file.
 * How would you compute the k stars which are closest to Earth?
 * 
 * NOTE: It's a variant of K Small elements problem
 * 
 * @author gopi_karmakar
 */
public class ComputeKClosestStars {

	public static void main(String[] args) {
		
		// Sample data creation
		List<Star> stars = new ArrayList<>();
		for(int i = 1; i <= 10; ++i) {
			if(i % 2 == 0)
				stars.add(new Star(i * 2, i * 4, i * 6));
			else 
				stars.add(new Star(i * 3, i * 5, i + 7));
		}
		for(Star star : computeKClosestStars(3, stars)) {
			System.out.println(star);
		}		
	}
	
	private static List<Star> computeKClosestStars(int k, List<Star> stars) {
		
		PriorityQueue<Star> maxPQ = new PriorityQueue<>(k, Collections.reverseOrder());
		
		for(Star star : stars) {
			
			maxPQ.add(star);
			
			if(maxPQ.size() > k) {
				maxPQ.remove();
			}			
		}
		
		List<Star> orderedStars = new ArrayList<>(maxPQ);
		
		//Since the sortedness won;t be guaranteed		
		Collections.sort(orderedStars);
		
		return orderedStars;
	}
	
	private static class Star implements Comparable<Star> {
		
		private double x, y, z;
		
		public Star(double x, double y, double z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		private double distance() {
			 return Math.sqrt(x*x + y*y + z*z);
		}

		@Override
		public int compareTo(Star other) {			
			return Double.compare(this.distance(), other.distance());
		}

		@Override
		public String toString() {
			return "Star [x = " + x + ", y = " + y + ", z = " + z + ", distance = " + distance() + "]";
		}				
	}
}
