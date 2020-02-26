package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Queue;
import java.util.Stack;

import java.util.LinkedList;

/**
 * A concrete Binary Search Tree Implementation with the tracking of
 * Parent node for every child node. Also with Recursive and Non-Recursive 
 * insertions, retrievals & traversals. Ascending or Descending Left & Right 
 * Diagonal Traversals.
 * 
 * Average-case cost (after N random inserts & search):
 * Insert : 1.39 log(N)
 * Search : 1.39 log(N)
 * 
 * Worst-case cost (after N random inserts & search):
 * Insert : (N)
 * Search : (N)
 * 
 * 	       		       11
 *   		  5                15
 *   	 3        8         14    16
 *     2   4    7   9     13         19
 *  1         6		    12	     17      20
 *					               18       21
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree_OLD {
	
	public static void main(String[] args) {		
		TestBinarySearchTree();
	}
	
	@SuppressWarnings("rawtypes")
	private static void TestBinarySearchTree() {
		
		BST<Integer, String> bst = new BST<Integer, String>();	
		
	    bst.put(11, "Juu");
	    bst.put(15, "JuIchi");
	    bst.put(5, "Kyuu");
	    bst.put(16, "JuuNi");
	    bst.put(3, "Penta");
	    bst.put(14, "Seven");
	    bst.put(8, "Nine");
	    bst.put(13, "Duo");
	    bst.put(4, "Uno");
	    bst.put(18, "Uno");
	    bst.put(7, "Uno");
	    bst.put(12, "Uno");
	    bst.put(2, "Uno");
	    bst.put(17, "Uno");
	    bst.put(1, "Uno");
	    bst.put(19, "Uno");
	    bst.put(6, "Uno");
	    bst.put(20, "Uno");	   
	    bst.put(9, "Uno");
	    bst.put(21, "twotwo");
		
	    //PrintMSG("Tree Size = " + bt.size());
	    System.out.println("The Value For Deteletd Key 14 = " + bst.delete(14));
	    //PrintMSG("The Value For Key 2 = " + bt.contains(2));
	    //bst.printAllPostOrderNodes();
	    //System.out.println("PreOrder Printing");
	    //bst.printAllPreOrderNodes();
	    //bt.printAllInOrderNodes(bt.NON_RECURSIVE);
	    //bt.printNodesInRange(4, 8);
	    //bt.printAllRightDiagonalNodes();
	    //bt.convertToDoubleLinkedList();
	    //bt.printDoubleyLinkedList(bt.DESCENDING);
	    bst.printAllBFSNodesFromRoot();
	    //System.out.println("Invert Printing");
	    //bt.printAnInvertedTree();
		
		/*bst.put(5);
		bst.put(1);
		bst.put(4);*/
		
		/*bst.root = bst.new Node(5, null);
		bst.root.left = bst.new Node(1, bst.root);
		bst.root.right = bst.new Node(4, bst.root);
		bst.root.right.left = bst.new Node(3, bst.root.right);
		bst.root.right.right = bst.new Node(6, bst.root.right);*/
		
		//bst.root = bst.new Node(5, null);
		//bst.root.left = bst.new Node(1, bst.root);
		
		//System.out.println("" + bst.isValidateBST(bst.root));		
	}
	
	private static class BST<K extends Comparable<K>, V> {
		
		private int size = 0;
		public final int RECURSIVE = 1;
		public final int ASCENDING = 2;
		public final int DESCENDING = 3;
		public final int NON_RECURSIVE = 4;
		private Node root, head, tail, parent;
		
		class Node {
			K key;
			V value;
			int data;
			Node left;
			Node right;
			Node parent;
			
			public Node(int data, Node parent) {
				this.data = data;
				this.parent = parent;
			}
			
			public Node(K key, V value, Node parent) {
				this.key = key;
				this.value = value;
				this.parent = parent;
			}
		}
		
		public BST() {
			root = null;
			parent = null;
		}
		
		/**
		 * Binary Search Tree guarantees O(logn)
		 * time for Insertions.
		 * 
		 * After adding the values to tree
		 * the tree will become like: 
		 * 
		 * @param value
		 * @return
		 */
		public void put(int data) {
			root = insertNodeRecursive(root, data);
		}
		
		public Node put(K key, V value) {
			return insertNodeNonRecursive(key, value);
		}
			
		/**
		 * Searching a value from BST takes O(LogN) time  
		 * in best & average cases and O(n) in worst cases. 
		 * 
		 * @param key
		 * @return
		 */
		public V contains(K key) {
			//return containsNodeNonRecursive(key).value;
			if(root == null)
				return null;
			return containsNodeRecursive(root, key).value;
		}
		
		public V delete(K key) {
			Node node = containsNodeNonRecursive(key);
			V value = node.value;
			deleteNode(node);
			return value;
		}
		
		/**
		 * It's one of the ways for Depth First Search
		 *  It traverse the till the depth from the root
		 * In-Order traversal of tree visits 
		 * first the left sub-tree, 
		 * then the root node, 
		 * and finally the right sub-tree
		 */
		public void printAllInOrderNodes(int method) {
			switch (method) {		
				case RECURSIVE:
					traverseInOrderRecursive(root);
					break;
				case NON_RECURSIVE:
					traverseInOrderNonRecursive();
					break;
			}
		}
		
		/**
		 * Another way of Depth First Search
		 * Pre-Order traversal of tree visits
		 * first the root node, 
		 * then the left subtree, 
		 * and finally the right subtree
		 */
		public void printAllPreOrderNodes() {
			traversePreOrderRecursive(root);
		}
		
		/**
		 * Another way of Depth First Search
		 * Post-order traversal of tree visits 
		 * first the left subtree, 
		 * then the right subtree, 
		 * and finally the root node at the end
		 */
		public void printAllPostOrderNodes() {
			traversePostOrderRecursive(root);
		}
		
		/**
		 * Level order or Breadth First Search (BFS)
		 * traverse all the nodes in a level from root.
		 * Unlike traversing till depth.
		 */
		public void printAllBFSNodesFromRoot() {
			traverseBFSFromRootNonRecursive();
		}
		
		public void printAnInvertedTree() {
			invertTraversalOfATree();
		}
		
		public void printAllRightDiagonalNodes() {
			if(root == null)
				return;
			traverseRightDiagonalFromRootNonRecursive();
		}
		
		/**
		 * Both ways traversal. 
		 * Very inefficient just for testing.
		 * @param order
		 */
		public void printDoubleyLinkedList(int order) {
			Node node = null;
			if(order == ASCENDING) node = head;
			else if(order == DESCENDING) node = tail;
			while(node != null) {
				System.out.println("Node = " + node.key + " Value = " + node.value);
				if(order == ASCENDING) node = node.right;
				else if(order == DESCENDING) node = node.left;
			}
		}
		
		public void printNodesInRange(K leftRange, K rightRange) {
			traverseInOrderRecursiveWithInRange(root, leftRange, rightRange);
		}
		
		/**
		 * Binary tree conversion to Double Linked List.
		 */
		public void convertToDoubleLinkedList() {
			convertToDoubleyLLRecursively(root);
		}
		
		public boolean validateBSTProperty() {
			return isValidateBST(root);
		}
		
		public int size() {
			return size;
		}
		
		private Node insertNodeNonRecursive(K key, V value) {
			Node node = root;
			if(node == null) {
				root = new Node(key, value, parent);
				root.parent = parent;
				size += 1;
				return root;
			}
			int cmp = 0;
			do {
				parent = node;
				cmp = key.compareTo(node.key);
				if(cmp < 0)
					node = node.left;
				else if(cmp > 0) 
					node = node.right;
				else
					node.value = value;			
			} while(node != null);
			if(cmp < 0)
				node = parent.left = new Node(key, value, parent);		
			else if(cmp > 0)
				node = parent.right = new Node(key, value, parent);				
			size += 1;
			return node;
		}
		
		private Node insertNodeRecursive(Node node, int data) {
			if(node == null) {
				node = new Node(data, parent);
				size += 1;
				return node;
			}
			parent = node;
			if(data < node.data) 
				node.left = insertNodeRecursive(node.left, data);
			else if(data > node.data)
				node.right = insertNodeRecursive(node.right, data);
			else 
				node.data = data;
			
			return node;
		}
		
		private Node insertNodeRecursive(Node node, K key, V value) {		
			if(node == null) {
				node = new Node(key, value, parent);			
				size += 1;
				return node;
			}
			parent = node;
			int cmp = key.compareTo(node.key);
			if(cmp < 0)
				node.left = insertNodeRecursive(node.left, key, value);
			else if(cmp > 0)
				node.right = insertNodeRecursive(node.right, key, value);
			else
				node.value = value;
			return node;
		}
		
		private Node containsNodeRecursive(Node node, K key) {				
			int cmp = key.compareTo(node.key);
			if(cmp == 0)
				return node;
			return (cmp < 0) ? containsNodeRecursive(node.left, key) : containsNodeRecursive(node.right, key);		
		}
		
		private Node containsNodeNonRecursive(K key) {
			Node node = root;
			if(node == null)
				return null;
			do {
				int cmp = key.compareTo(node.key);
				if(cmp < 0) node = node.left;
				else if(cmp > 0) node = node.right;
				else return node;
			} while(node != null);		
			return null;
		}
		
		/**
		 * Deleting a node Non-Recursively.
		 * 	 	       		   11
		 *   		  5                15
		 *   	 3        8         14    16
		 *     2   4    7   9     13         19
		 *  1         6		    12	      17    20
		 *					                18    21
		 * @param node
		 * @param key
		 * @return
		 */
		private void deleteNode(Node node) {
			size -= 1;
			if(node.left != null && node.right != null) {
				Node successor = getSuccessor(node.right);
				node.key = successor.key;
				node.value = successor.value;
				node = successor;
			}
			Node replacement = (node.left != null) ? node.left : node.right;
			if(replacement != null) {
				if(node.parent == null)
					root = replacement;
				else if(node == node.parent.left)
					node.parent.left = replacement;
				else if(node == node.parent.right)
					node.parent.right = replacement;
				node.left = node.right = node.parent = null;
			}
			else if(node.parent == null)
				root = null;
			else {
				if(node.parent != null) {
					if(node == node.parent.left)
						node.parent.left = null;
					else if(node == node.parent.right)
						node.parent.right = null;
					node.parent = null;
				}
			}
		}
		
		private Node getSuccessor(Node node) {
			while(node.left != null)
				node = node.left;
			return node;
		}
		
		/**
		 * @param node
		 */
		private void traverseInOrderRecursive(Node node) {
			if(node == null)
				return;		
			traverseInOrderRecursive(node.left);
			K parent = (node.parent == null) ? null : node.parent.key;
			System.out.println("Parent = " + parent + " and Node = " + node.key);
			traverseInOrderRecursive(node.right);
		}
		
		/**
		 * Left diagonal or In-Order traversal.
		 * of a tree Without Recursion.
		 * 	       		       11
		 *   		  5                15
		 *   	 3        8         14    16
		 *     2   4    7   9     13         19
		 *  1         6		    12	     17      20
		 *					               18       21 
		 *     								        						  
		 */
		private void traverseInOrderNonRecursive() {		
			Stack<Node> s = new Stack<>();
			Node x = root;
			do {
				if(x != null) {
					s.add(x);
					x = x.left;
				}
				else {					
					if(!s.isEmpty())
						x = s.pop();
					else break;
					
					K parent = (x.parent == null) ? null : x.parent.key;
					System.out.println("Parent = " + parent + " and Node = " + x.key);					
					x = x.right;
				}			
			} while(true);
		}
		
		/**
		 * Print In-Order tree traversal with in range. 
		 * @param node
		 * @param leftRange
		 * @param rightRange
		 */
		private void traverseInOrderRecursiveWithInRange(Node node, K leftRange, K rightRange) {
			if(node == null)
				return;		
			traverseInOrderRecursiveWithInRange(node.left, leftRange, rightRange);
			int leftCmp = node.key.compareTo(leftRange);
			int rightcmp = node.key.compareTo(rightRange);
			if(leftCmp >= 0 && rightcmp <= 0) {			
				K parent = (node.parent == null) ? null : node.parent.key;
				System.out.println("Parent = " + parent + " and Node = " + node.key);
			}
			traverseInOrderRecursiveWithInRange(node.right, leftRange, rightRange);
		}
		
		/**
		 * @param node
		 */
		private void traversePreOrderRecursive(Node node) {
			if(node == null)
				return;
			K parent = (node.parent == null) ? null : node.parent.key;
			System.out.println("Parent = " + parent + " and Node = " + node.key);
			traversePreOrderRecursive(node.left);
			traversePreOrderRecursive(node.right);
		}
		
		/**
		 * @param node
		 */
		private void traversePostOrderRecursive(Node node) {
			if(node == null)
				return;
			traversePostOrderRecursive(node.left);
			traversePostOrderRecursive(node.right);
			K parent = (node.parent == null) ? null : node.parent.key;
			System.out.println("Parent = " + parent + " and Node = " + node.key);
		}
		
		/**
		 * Breadth Wise Traversal of a tree.
		 */
		private void traverseBFSFromRootNonRecursive() {		
			Queue<Node> nodes = new LinkedList<BST<K,V>.Node>();		
			nodes.add(root);
			do {
				Node node = nodes.remove();
				K parent = (node.parent == null) ? null : node.parent.key;
				System.out.println("Parent = " + parent + " and Node = " + node.key);
				if(node.left != null)
					nodes.add(node.left);
				if(node.right != null)
					nodes.add(node.right);			
			} while(!nodes.isEmpty());
		}
		
		/**
		 * Invert a tree.
		 */
		private void invertTraversalOfATree() {		
			Queue<Node> nodes = new LinkedList<BST<K,V>.Node>();		
			nodes.add(root);
			do {
				Node node = nodes.remove();
				K parent = (node.parent == null) ? null : node.parent.key;
				System.out.println("Parent = " + parent + " and Node = " + node.key);			
				if(node.right != null)
					nodes.add(node.right);
				if(node.left != null)
					nodes.add(node.left);
			} while(!nodes.isEmpty());
		}
		
		/**
		 * Right diagonal traversal of a tree.
		 * 	       		       11
		 *   		  5                15
		 *   	 3        8         14    16
		 *     2   4    7   9     13         19
		 *  1         6		    12	     17      20
		 *					               18       21 
		 *     								        						  
		 */	
		private void traverseRightDiagonalFromRootNonRecursive() {
			Queue<Node> nodes = new LinkedList<BST<K,V>.Node>();
			Node node = root;
			int treeSize = size();
			do {
				if(node != null) {
					nodes.add(node);
					node = node.right;									
				}
				else {				
					treeSize -= 1;
					node = nodes.remove();
					/**
					 * Null check isn't required bcoz a 
					 * null can't be added due to null check above. 				 
					 */
					K parent = (node.parent == null) ? null : node.parent.key;
					System.out.println("Parent = " + parent + " and Node = " + node.key);
					node = node.left;
				}			
			} while(treeSize > 0);
		}
		
		/**
		 * Converting a binary tree to Double linked list recursively.
		 * @param node
		 */
		private void convertToDoubleyLLRecursively(Node node) {
			if(node == null)
				return;
			convertToDoubleyLLRecursively(node.left);
			Node prev = tail;
			tail = new Node(node.key, node.value, null);
			if(head == null)
				head = tail;
			else {
				prev.right = tail;
				tail.left = prev;
				prev = tail;
			}
			convertToDoubleyLLRecursively(node.right);
		}
		
		private class QueueEntry {
		
			private Node node;
			private int lowerBound, upperBound;
			
			public QueueEntry(Node node, int lowerBound, int upperBound) {
				this.node = node;
				this.lowerBound = lowerBound;
				this.upperBound = upperBound;				
			}
		}
		
		private boolean isValidateBST(Node node) {
			
			Queue<QueueEntry> bfsQueue = new LinkedList<>();			
			bfsQueue.add(new QueueEntry(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

			QueueEntry headEntry = null;
			while((headEntry = bfsQueue.poll()) != null) {
				if(headEntry.node != null) {				
					if(headEntry.node.data < headEntry.lowerBound ||
							headEntry.node.data > headEntry.upperBound) {
						return false;
					}
					bfsQueue.add(new QueueEntry(headEntry.node.left, headEntry.lowerBound, headEntry.node.data));
					bfsQueue.add(new QueueEntry(headEntry.node.right, headEntry.node.data, headEntry.upperBound));
				}							
			}
			return true;
		}
	}
}