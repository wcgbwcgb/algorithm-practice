package data_structure;

import javax.xml.stream.events.EndDocument;

public class CycleArray<T> {
	private T[] arr;
	private int start;
	private int end;
	private int count;
	private int size;
	
	public CycleArray(int size){
		arr = (T[]) new Object[size];
		this.size = size;
		this.start = 0;
		this.end = 0;
		this.count = 0;
	}
	
	public CycleArray() {
		this(1);
	}
	
	public void addFirst(T value) {
		if (count >= size) {
			resize(size*2);
		}
		start = (start - 1 + size) % size;
		arr[start] = value;
		count++;
	}
	
	public void addLast(T value) {
		if (count >= size) {
			resize(size*2);
		}
		arr[end] = value;
		end = (end + 1) % size;
		count++;
	}
	
	public void removeFirst() {
		arr[start] = null;
		start = (start + 1) % size;
		count--;
	}
	
	public void removeLast() {
		end = (end - 1 + size) % size;
		arr[end] = null;
		count--;
	}
	
	public T getFirst() {
		return arr[start];
	}
	
	public T getLast() {
		return arr[(end - 1 + size) % size];
	}
	
	private void resize(int newSize) {
		T[] newArr = (T[]) new Object[newSize];
		for(int i =0;i<count;i++) {
			newArr[i] = arr[(start+i)%size];
		}
		arr = newArr;
		size = newSize;
		start = 0;
		end = count;	
	}
	
	
	
	public static void main(String[] args) {
		CycleArray<Integer> arr1 = new CycleArray<Integer>();
		arr1.addFirst(1);
		arr1.addFirst(2);
		arr1.addFirst(3);
		arr1.addFirst(4);
		System.out.println(arr1.getFirst());
		System.out.println(arr1.getLast());
		arr1.removeLast();
		System.out.println(arr1.getLast());
		arr1.addLast(99);
		System.out.println(arr1.getLast());
		arr1.removeFirst();
		System.out.println(arr1.getFirst());
		
	}
	
}
