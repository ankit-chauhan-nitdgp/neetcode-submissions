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
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode node){
        if(node == null){
            return true;
        }

        if(Math.abs(depth(node.left) - depth(node.right)) > 1){
            return false;
        }

        return helper(node.left) && helper(node.right);

    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        return 1+ Math.max(leftDepth, rightDepth);
    }
}
