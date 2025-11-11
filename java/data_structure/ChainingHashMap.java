package data_structure;

import java.util.LinkedList;

public class ChainingHashMap {

    static class KVNode {
        int key;
        int value;

        public KVNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<KVNode>[] table;
    
    
    public ChainingHashMap(int capacity) {
    	table = new LinkedList[capacity];
    }
    
    
    private int hash(int key) {
    	return key % table.length;
    }
    
    // 查
    public int get(int key) {
    	int index = hash(key);
    	if(table[index] == null) {
    		return -1;
    	}
    	
    	// 找到hash过的位置的链表
    	LinkedList<KVNode> list = table[index];
    	for(KVNode node: list) {
    		if (node.key == key) {
    			return node.value;
    		}
    	}
    	
    	// 链表里也没找到
    	return -1;
    }
    
    // 增/改
    public void put(int key, int value) {
    	int index = hash(key);
    	
    	if (table[index] == null) {
    		table[index] = new LinkedList<KVNode>();
    		table[index].addLast(new KVNode(key, value));
    		return;
    	}
    	
    	LinkedList<KVNode> list = table[index];
    	for(KVNode node: list) {
    		if(node.key == key) {
    			node.value = value;
    			return;
    		}
    	}
    	
    	list.addLast(new KVNode(key, value));
    }
    
    //删
    public void remove(int key) {
    	int index = hash(key);
    	
    	if (table[index] == null) {
    		return;
    	}
    	
    	LinkedList<KVNode> list = table[index];
    	for(int i = 0;i<list.size();i++) {
    		if(list.get(i).key == key) {
    			list.remove(i);
    			return;
    		}
    	}
    	
    }
    
    
	
	public static void main(String[] args) {
		ChainingHashMap hashMap = new ChainingHashMap(10);
		hashMap.put(1, 100);
		hashMap.put(2, 400);
		hashMap.put(3, 900);
		hashMap.put(4, 1600);
		System.out.println(hashMap.get(3));
		hashMap.remove(3);
		hashMap.put(2, 900000);
		System.out.println(hashMap.get(3));
		System.out.println(hashMap.get(2));
	}

}
