package data_structure;

public class LinkedListNode<E> {
	E val;
	LinkedListNode<E> next;
	
	public LinkedListNode(E val) {
		this.val = val;
	}
	
	public static <E> LinkedListNode<E> convert2LinkedListNode(E[] arr){
		if (arr == null || arr.length == 0) {
			return null;
		}
		LinkedListNode<E> head = new LinkedListNode(arr[0]);
		LinkedListNode<E> cur = head;
		
		for(int i = 1;i < arr.length;i++) {
			cur.next = new LinkedListNode(arr[i]);
			cur = cur.next;
		}
		
		return head;
	}
	
	public void addLast(E val) {
		LinkedListNode<E> cur = this;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new LinkedListNode<E>(val);
	}
	
	
	public void add(E val, int index) {
		LinkedListNode<E> cur = this;
		for(int i = 1;i < index;i++) {
			cur = cur.next;
		}
		LinkedListNode<E> temp_next = cur.next;
		cur.next = new LinkedListNode<E>(val);
		cur = cur.next;
		cur.next = temp_next;
	}
	
	public void remove(int index) {
		LinkedListNode<E> cur = this;
		for(int i = 1;i < index;i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
	}
	
	public static void main(String[] args) {
        LinkedListNode<Integer> l = convert2LinkedListNode(new Integer[]{1, 2, 3, 4, 5});
        l.addLast(20);
        l.add(505, 2);
        l.remove(0);

        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
	}
}
