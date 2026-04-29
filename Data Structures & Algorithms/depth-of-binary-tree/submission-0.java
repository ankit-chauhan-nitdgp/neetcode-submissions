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
    int ans = 0;
    public int maxDepth(TreeNode root) {
        helper(root, 0);

        return ans;
    }

    public void helper(TreeNode root, int i){
        if(root == null){
            ans = Math.max(i, ans);
            return;
        }

        helper(root.left, i+1);
        helper(root.right, i+1);
    }
}
