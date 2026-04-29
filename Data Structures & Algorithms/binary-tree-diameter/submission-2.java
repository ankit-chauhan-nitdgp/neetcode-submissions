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

    int ans;
    int maxDepth;
    public int diameterOfBinaryTree(TreeNode root) {
        
        helper(root);
        return ans;
    }

    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        int temp = 0;

        maxDepth = 0;
        maxDepth(root.left, 0);
        temp =  temp + maxDepth;

        maxDepth = 0;
        maxDepth(root.right,0);
        temp = temp + maxDepth;

        ans = Math.max(ans, temp);

        helper(root.left);
        helper(root.right);

    }

     public void maxDepth(TreeNode root, int i){
        if(root == null){
            maxDepth = Math.max(i, maxDepth);
            return;
        }

        maxDepth(root.left, i+1);
        maxDepth(root.right, i+1);
    }

}
