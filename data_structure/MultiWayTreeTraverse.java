package data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiWayTreeTraverse {
	
	static class Node {
		int val;
		List<Node> children;
		
		public Node(int val, List<Node> children) {
			this.val = val;
			this.children = children;
		}
	}
	
	
	public static void DFSTraverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val+" ");
		for(Node n:node.children) {
			DFSTraverse(n);
		}
	}
	
	
	public static void BFSTraverse(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		int depth = 0;
		
		if (node == null) {
			return;
		}
		
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
			System.out.println("depth: "+depth);
			for(int i = 0;i<sz;i++) {
				Node root = queue.poll();
				System.out.print(root.val+" ");
				for(Node n:root.children) {
					if(n != null) {
						queue.offer(n);
					}
				}
			}
			System.out.println();
			depth++;
		}
		
		
	}
	
	public static void main(String[] args) {
		List<Node> rootChild = new ArrayList<Node>();
		List<Node> node2Child = new ArrayList<Node>();
		node2Child.add(new Node(21, new ArrayList<Node>()));
		node2Child.add(new Node(22, new ArrayList<Node>()));
		node2Child.add(new Node(23, new ArrayList<Node>()));
		node2Child.add(new Node(24, new ArrayList<Node>()));
		rootChild.add(new Node(1, new ArrayList<Node>()));
		rootChild.add(new Node(2, node2Child));
		rootChild.add(new Node(3, new ArrayList<Node>()));
		Node root = new Node(100, rootChild);
		
		DFSTraverse(root);
		System.out.println();
		BFSTraverse(root);
	}
	
}
