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
    public int goodNodes(TreeNode root) {
        preOrder(root, root.val);
        return ans;
    }

    private void preOrder(TreeNode root, int max){
        //root
        if(root == null){
            return;
        }

        if( root.val >= max){
            ans++;
        }
        
        preOrder(root.left, Math.max(max, root.val));
        preOrder(root.right, Math.max(max, root.val));
    }
}
