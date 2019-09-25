package com.hyend.data.storage.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A Google Mock up interview question:
 * Create a Queue using Stacks
 *   
 * @author gopi_karmakar
 */
public class CreateAQueueUsingStacks<K> {
	
	Deque<K> enque = new LinkedList<>();
	Deque<K> deque = new LinkedList<>();

	public static void main(String[] args) {
		
		CreateAQueueUsingStacks<String> q = new CreateAQueueUsingStacks<>();
		q.enqueue("One");
		q.enqueue("Two");		
		System.out.println(q.dequeue());
		q.enqueue("Three");		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue("One");
		q.enqueue("Two");
		q.enqueue("Four");
		System.out.println(q.dequeue());
	}
	
	public void enqueue(K k) {
		enque.addFirst(k);
	}
	
	public K dequeue() {
		
		if(deque.isEmpty()) {
			
			while(!enque.isEmpty()) {					
				deque.addFirst(enque.removeFirst());
			}							
		}

		if(!deque.isEmpty())
			return deque.removeFirst();
		
		throw new NoSuchElementException("Queue Is Empty");
	}
}
