package com.hyend.data.storage.structures.trees;

import com.hyend.data.storage.structures.trees.SelfBalancedBSTres.Node;

public class RedBlackBST<Key extends Comparable<Key>, Value>
{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
	   int N;
	   Key key;
	   Value value;
	   boolean color;    // color of link from
	   Node left, right; // subtree parent to this node
	   Node(Key key, Value value, int N, boolean color) {
		  this.N = N;
	      this.key = key;
	      this.value = value;
	      this.color = color;
	   }
	}
	
	public int size()
	{  return size(root);  }
	
	private int size(Node x)
	{
	   if (x == null) return 0;
	   else           return x.N;
	}
	
	private boolean isRed(Node x) {
	   if (x == null) return false;
	   return x.color == RED;
	}
	
	private void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	private Node rotateRight(Node h)
	{
	   Node x = h.left;
	   h.left = x.right;
	   x.right = h;
	   x.color = h.color;
	   h.color = RED;
	   x.N = h.N;
	   h.N = 1 + size(h.left) + size(h.right);
	   return x;
	}
	
	Node rotateLeft(Node h)
	{
	   Node x = h.right;
	   h.right = x.left;
	   x.left = h;
	   x.color = h.color;
	   h.color = RED;
	   x.N = h.N;
	   h.N = 1 + size(h.left) + size(h.right);
	   return x;
	}	
  
   public void put(Key key, Value value)
   {  
	   // Search for key. Update value if found; grow table if new.
      root = put(root, key, value);
      root.color = BLACK;
   }
   
   public void printAllNodesInOrder() {
		traverseInOrder(root);
	}
   
   private Node put(Node h, Key key, Value value)
   {
      if (h == null)  // Do standard insert, with red link to parent.
         return new Node(key, value, 1, RED);
      
      int cmp = key.compareTo(h.key);
      if      (cmp < 0) h.left  = put(h.left,  key, value);
      else if (cmp > 0) h.right = put(h.right, key, value);
	  else h.value = value;
	
      if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
      if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
      if (isRed(h.left) && isRed(h.right))     flipColors(h);
      h.N = size(h.left) + size(h.right) + 1;
      return h; 
   }
   
   private void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.println(" Child = " + 
			node.key + " Color = " + node.color);
			traverseInOrder(node.right);
		}
	}
}
