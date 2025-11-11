package data_structure;

import java.util.LinkedList;

public class LinkedQueue<E> {
	private LinkedList<E> list = new LinkedList<E>();
	
	public void push(E value) {
		list.addLast(value);
	}
	
	public E pop() {
		return list.removeFirst();
	}
	
	public E peek() {
		return list.getFirst();
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
	}
}
