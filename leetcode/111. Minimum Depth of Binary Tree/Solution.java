/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int depth = 0;
    private int min_depth = 10000;
    
    private void traverse(TreeNode node){
        if (node == null){
            return;
        }

        depth++;

        if(node.left == null && node.right == null){
            min_depth = Math.min(min_depth, depth);
        }

        traverse(node.left);
        traverse(node.right);

        depth--;
    }

    public int minDepth(TreeNode root) {
        if(root == null){return 0;}
        traverse(root);
        return min_depth;
    }
}