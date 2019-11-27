package com.hyend.data.storage.structures.graphs.edgeweighted;

public class DistanceWithFewestEdges {

	public int distance;
	public int minNumEdges;
	
	public DistanceWithFewestEdges(int distance, int minNumEdges) {
		this.distance = distance;
		this.minNumEdges = minNumEdges;
	}
}
