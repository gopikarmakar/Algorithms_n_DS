package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Validate whether the given two BST nodes are an
 * ancestor and descendant of the given middle BST node 
 * with out any track of the parent node.  
 * 
 * @author gopi_karmakar
 */
public class AreThreeBSTNodesTotallyOrdered {

	public static void main(String[] args) {
		
		Node<Integer, ?> tree = BinarySearchTree.createDefault();
		Node<Integer, ?> node1 = tree.left;
		Node<Integer, ?> middle = tree.left.right;
		//Node<Integer, ?> middle = tree.left.left;
		Node<Integer, ?> node2 = tree.left.right.left.left;
		
		System.out.println(areOrdered(node1, node2, middle));
		
	}
	
	private static boolean areOrdered(Node<Integer, ?> node1, Node<Integer, ?> node2, 
			Node<Integer, ?> middle) {
		
		Node<Integer, ?> search1 = node1;
		Node<Integer, ?> search2 = node2;
		
		/**
		 * Interleaved searching from node1 and node2 for middle
		 */
		while(search1 != node2 && search1 != middle &&
			search2 != node1 && search2 != middle &&
				(search1 != null || search2 != null)) {
			
			if(search1 != null) {
				search1 = (search1.key < middle.key) ? search1.right : search1.left;  
			}
			
			if(search2 != null) {
				search2 = (search2.key < middle.key) ? search2.right : search2.left;
			}
		}
		
		/**
		 * If this condition satisfies then it means both searches were 
		 * unsuccessful, we got to node2 from node1 or to node1 from node2
		 * without seeing the middle node, which means middle node cannot lie 
		 * between node1 and node2.		 
		 */
		if(search1 == node2 || search2 == node1 ||
			(search1 != middle) && (search2 != middle))
			return false;					
		
		/**
		 * If we get here then we know for sure that the middle node path  
		 * lie between either of node1 or node2, now we just need to find  
		 * from which node has a path to middle node.		 
		 */
		return (search1 == middle) ? searhTarget(middle, node2) : searhTarget(middle, node1);
								
	}
	
	private static boolean searhTarget(Node<Integer, ?> from, Node<Integer, ?> target) {
		
		while(from != null &&  from != target) {
			from = (from.key < target.key) ? from.right : from.left;
		}
			
		return (from == target);
	}
}
