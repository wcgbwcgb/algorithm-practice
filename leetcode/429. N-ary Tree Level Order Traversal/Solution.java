/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node node) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
		
		if (node == null) {
			return new ArrayList<>();
		}
		
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
            List<Integer> levelNode = new ArrayList<>();
			for(int i = 0;i<sz;i++) { 
				Node root = queue.poll();
				levelNode.add(root.val);
				for(Node n:root.children) {
					if(n != null) {
						queue.offer(n);
					}
				}
			}
            ans.add(levelNode);
		}
        return ans;
    }
}