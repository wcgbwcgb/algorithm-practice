package data_structure;

public class SimpleMinPQ {
	private int[] pq;
	private int size = 0;
	
	public SimpleMinPQ(int capacity){
		this.pq = new int[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public void push(int val) {
		pq[size] = val;
		swim(size);
		size++;
	}
	
	public int peek() {
		return pq[0];
	}
	
	public int pop() {
		int min = pq[0];
		pq[0] = pq[size-1];
		size--;
		sink(0);
		return min;
	}
	
	private void swim(int index) {
		if(index < 1 || pq[index] >= pq[(index-1)/2]) {
			return;
		}
		swap(index, (index-1)/2);
		swim((index-1)/2);
	}
	
	private void sink(int index) {
		int left = index*2 + 1;
		int right = index*2 + 2;
		int min = index;
		
		while(left < size || right < size) {
			left = index*2 + 1;
			right = index*2 + 2;
			min = index;
			if(left < size && pq[left] < pq[min]) {
				min = left;
			}
			if(right < size && pq[right] < pq[min]) {
				min = right;
			}
			if(min == index) {
				break;
			}
			swap(index, min);
			index = min;
		}
	}
	
	private void swap(int idx1, int idx2) {
		int temp;
		temp = pq[idx2];
		pq[idx2] = pq[idx1];
		pq[idx1] = temp;
	}
	
	
	public static void main(String[] args) {
		SimpleMinPQ heap = new SimpleMinPQ(40);
		heap.push(7);
		heap.push(7);
		heap.push(10);
		heap.push(3);
		heap.push(5);
		heap.push(7);
		heap.push(1);
		heap.push(1);
		heap.push(1);
		//heap.push(8);

		System.out.println("peak: "+heap.peek());
		int sz = heap.size();
		for(int i = 0;i<sz;i++) {
			System.out.print(heap.pop()+" ");
		}
		System.out.println();
		System.out.println("size:"+heap.size());
		
	}
}
