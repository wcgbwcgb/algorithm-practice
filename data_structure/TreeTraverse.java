package data_structure;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;

public class TreeTraverse {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	static class State {
		TreeNode node;
		int weight;
		
		public State(TreeNode node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	
	static public void preorderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val+" ");
		preorderTraverse(node.left);
		preorderTraverse(node.right);
	}
	
	static public void postorderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}
		postorderTraverse(node.left);
		postorderTraverse(node.right);
		System.out.print(node.val+" ");
	}
	
	static public void inorderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}
		inorderTraverse(node.left);
		System.out.print(node.val+" ");
		inorderTraverse(node.right);
	}
	
	
	// simplest way
	static public void levelOrderTraverse(TreeNode node) {
		if(node == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			System.out.print(cur.val+" ");
			
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
	}
	
	// level order traverse with depth record
	static public void levelOrderTraverseWithDepth(TreeNode node) {
		if(node == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		int depth = 1;
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0;i<sz;i++) {
				TreeNode cur = queue.poll();
				System.out.println("val: "+cur.val+" depth:"+depth);
				
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			depth++;
		}
	}

	
	// level order traverse by using State class. (可以记录weight)
	static public void levelOrderTraverseWithDepthbyWeight(TreeNode node) {
		if(node == null) {
			return;
		}
		Queue<State> queue = new LinkedList<State>();
		// weight设为1，因为现在只求depth
		queue.offer(new State(node, 1));
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0;i<sz;i++) {
				State cur = queue.poll();
				System.out.println("val: "+cur.node.val+" depth:"+cur.weight);
				
				if (cur.node.left != null) {
					queue.offer(new State(cur.node.left, cur.weight+1));
				}
				if (cur.node.right != null) {
					queue.offer(new State(cur.node.right, cur.weight+1));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(6);
		node1.left.left = new TreeNode(1);
		node1.left.right = new TreeNode(3);
		node1.right.left = new TreeNode(5);
		node1.right.right = new TreeNode(7);
		
		System.out.println("traverse_in_oder: ");
		inorderTraverse(node1);
		System.out.println();
		
		System.out.println("traverse_pre_oder: ");
		preorderTraverse(node1);
		System.out.println();
		
		System.out.println("traverse_post_oder: ");
		postorderTraverse(node1);
		System.out.println();
		
		System.out.println("level_order_traverse: ");
		levelOrderTraverse(node1);
		System.out.println();
		
		System.out.println("level_order_traverse_with_depth: ");
		levelOrderTraverseWithDepth(node1);
		System.out.println();
		
		System.out.println("level_order_traverse_with_depth_by_weight: ");
		levelOrderTraverseWithDepthbyWeight(node1);
		System.out.println();

	}

}
