package com.hyend.data.storage.structures.graphs.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author gopi_karmakar
 */
public class CourseSchedule {

	static class Vertex {
        
        public static enum Color {WHITE, GRAY, BLACK};            
        
        int v;             
        Color color = null;                 
        
        List<Vertex> edges;
        
        public Vertex(int v) {
            this.v = v;
            color = Color.WHITE;           
            this.edges = new ArrayList<>();
        }        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Set<Vertex> graph = createGraph(prerequisites);
        
        for(Vertex v : graph) {
            
            if(v.color == Vertex.Color.WHITE && hasCycle(v))
                return false;                        
        }
        return true;
    }
    
    private boolean hasCycle(Vertex v) {
        
        if(v.color == Vertex.Color.GRAY)
            return true;
        
        v.color = Vertex.Color.GRAY;
        
        for(Vertex e : v.edges) {
            
            if(e.color != Vertex.Color.BLACK) {
                if(hasCycle(e)) 
                    return true;
            }
        }
        v.color = Vertex.Color.BLACK;
        return false;
    }
    
    ////////////////////////////// Sample Graph Creation //////////////////////
    private Set<Vertex> createGraph(int[][] prerequisites) {
        
        Set<Vertex> graph = new HashSet<>();
        
        for(int[] arr : prerequisites) {                        
                        
            for(int i = 1; i < arr.length; ++i) {
                
                createPool(arr[0], arr[i]);
                addEdge(graph, getVertex(arr[0]), getVertex(arr[i]));
            }            
        }
        return graph;
    }
    
    private void addEdge(Set<Vertex> graph, Vertex v, Vertex e) {        
        v.edges.add(e);
        graph.add(v);
    }
        
    private Map<Integer, Vertex> map = new HashMap<>();
    private void createPool(int v, int e) {
        
        map.putIfAbsent(v, new Vertex(v));
		map.putIfAbsent(e, new Vertex(e));
    }
    
    private Vertex getVertex(int v) {        
        return map.get(v);
    }
}
