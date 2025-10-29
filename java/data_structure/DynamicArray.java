package data_structure;

public class DynamicArray<E> {
	// 用来存储的static array
	private E[] data;
	// 用来记录array的元素
	private int size;
	private static final int INIT_CAPA = 1;
	
	// Constructor
	public DynamicArray() {
		this.data = (E[]) new Object[INIT_CAPA];
		size = 0;
	}
	
	
	// add elements at the end
	public void append(E element) {
		if(size == data.length) {
			resize(2*data.length);
		}
		data[size] = element;
		size++;
	}
	
	// add element at any place
	public void add(E element, int index) {
		indexError(index);
		
		if(size == data.length) {
			resize(2*data.length);
		}
		
		// 给要添加的元素腾位置
		for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

		data[index] = element;
		
		size++;
	}
	
	// get an element
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	// remove
	public void remove(int index) {
		checkIndex(index);
		if(size <= data.length/4) {
			resize(data.length/2);
		}
		for(int i = index; i < size;i++) {
			data[i] = data[i+1];
		}
		data[size - 1] = null;
		size--;
	}
	
	
	// resize the array
	private void resize(int newCap) {
		E[] new_array = (E[]) new Object[newCap];
		
		// move all elements into the new array
		for(int i = 0;i < size;i++) {
			new_array[i] = data[i];
		}
		
		data = new_array;
	}
	
	// check the index
	private boolean checkIndex(int index) {
		return 0 <= index && index < size;
	}

	// throw error if it is out of bound
	private void indexError(int index) {
		if(!checkIndex(index)) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	// print out the dynamic array
	@Override
	public String toString() {
		String description = "[";
		for(int i = 0;i < size; i++) {
			description += data[i]+" ";
		}
		description += "]";
		return description;
	}
	
	
	public static void main(String[] args) {
		DynamicArray<Integer> arr = new DynamicArray<Integer>();
		arr.append(1);
		arr.append(2);
		arr.append(3);
		arr.append(4);
		arr.add(123, 2);
		arr.add(3333, 3);
		arr.append(1);
		arr.append(2);
		arr.append(3);
		arr.append(4);
		arr.remove(1);
		System.out.println(arr.get(0));

		
		System.out.println(arr);
	}
	
}
