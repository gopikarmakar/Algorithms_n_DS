package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Find the K small elements of BST
 * 
 * @author gopi_karmakar
 */
public class FindKSmallElements {

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		List<Integer> list = new ArrayList<>();
		
		find(bst, list, 4);			
		
		System.out.println(list);
		
		System.out.println(find(bst, 4));
	}
	
	/**
	 * Recursive Approach
	 * 
	 * The time complexity is O(h + k) 
	 */
	private static void find(Node<Integer, ?> node, List<Integer> list, int k) {
		
		if(node != null && list.size() < k) {
			
			find(node.left, list, k);
			
			if(list.size() < k) {
				
				list.add(node.key);
				
				find(node.right, list, k);
			}
		}
	}
	
	/**
	 * Iterative Approach
	 */
	private static List<Integer> find(Node<Integer, ?> root, int k) {
        
        Stack<Node<Integer, ?>> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        Node<Integer, ?> e = root;
        
        while(!s.isEmpty() || e != null) {                    	
        	
            if(e != null) {
                
                s.push(e);
                e = e.left;
            }
            else {
                e = s.pop();
                if(result.size() >= k) {
                	return result;                	                    
                }                
                result.add(e.key); 
                e = e.right; 
            }            
        }
        return result;
    }
}
