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
		
		System.out.println(findKth(bst, 3));
	}
	
	/**
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
	
	private static int findKth(Node<Integer, ?> root, int k) {
        
        Stack<Node<Integer, ?>> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        
        Node<Integer, ?> e = root;
        
        while(!s.isEmpty() || e != null) {                    	
        	
            if(e != null) {
                
                s.push(e);
                e = e.left;
            }
            else {
                e = s.pop();
                if(l.size() == k) {
                	return l.get(k-1);                	                    
                }                
                l.add(e.key); 
                e = e.right; 
            }            
        }
        return l.get(k-1);
    }
}
