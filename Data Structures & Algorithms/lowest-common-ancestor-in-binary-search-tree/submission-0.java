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
    TreeNode parent;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return parent;
        }
        if((p.val >= root.val && q.val <= root.val ) || (p.val <= root.val && q.val >= root.val )){
            parent = root;
        }else if(p.val < root.val && q.val < root.val){
            parent = lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            parent = lowestCommonAncestor(root.right, p, q);
        }

        return parent;
    }
}
