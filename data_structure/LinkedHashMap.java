package data_structure;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinkedHashMap<K, V> {

	static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
	
	private Node<K, V> head, tail;
	private HashMap<K, Node<K, V>> map = new HashMap<>();
	
	
	public LinkedHashMap(){
		head = new Node<>(null, null);
		tail = new Node<>(null, null);
		head.next = tail;
		tail.prev = head;
	}
	
	public V get(K key) {
		Node<K, V> node = map.get(key);
		if(node != null) {
			return node.value;
		}
		
		return null;
	}
	
	
	public void put(K key, V value) {
		if(!map.containsKey(key)) {
			Node<K, V> node = new Node<K, V>(key, value);
			addNode(node);
			map.put(key, node);
			return;
		}
		
		map.get(key).value = value;
	}
	
	
	public void remove(K key) {
		if(map.containsKey(key)) {
			removeNode(map.get(key));
			map.remove(key);
		}
	}
	
	public boolean containKey(K key) {
		return map.containsKey(key);
	}
	
	public List<K> keys(){
		List<K> list = new ArrayList<K>();
		for(Node<K, V> node = head.next;node != tail; node = node.next) {
			list.add(node.key);
		}
		return list;
	}
	
	// 改变链表的next和prev
	private void addNode(Node<K, V> node) {
		Node<K, V> temp = tail.prev; // 最后一个node
		
		tail.prev = node;
		
		node.prev = temp;
		node.next = tail;
		
		temp.next = node;
		
	}
	
	private void removeNode(Node<K, V> node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		node.next = null;
		node.prev = null;
	}
	
	
	
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(1, 100);
		map.put(2, 200);
		map.put(3, 300);
		map.put(4, 400);
		System.out.println(map.get(1)); // 100
		System.out.println(map.get(5)); // null
		map.put(2, 900);
		map.remove(3);
		System.out.println(map.containKey(3)); // false
		System.out.println(map.containKey(2)); // true
		System.out.println(map.keys()); // [1, 2, 4]
		

	}

}
