package com.hyend.data.storage.structures;

// Q -> 3 sz = 1;
// DQ -> 3 sz = 0;
public class LinkedListQueue<E> {

	int size = 0;
	private Node rear = null;
	private Node front = null;
	
	class Node {
		
		E item;
		Node next;
		public Node(E item) {
			this.item = item;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(E item) {
		
		Node node = rear;
		Node newNode = new Node(item);
		rear = newNode;		
		if(node == null) {
			front = newNode;
		}
		else
			node.next = newNode;		
				
        size++;
	}
	
	public E dequeue() {
		
		//if(!isEmpty()) return null;
		size-=1;
		E item = front.item;
		front = front.next;
		return item;
	}
}
