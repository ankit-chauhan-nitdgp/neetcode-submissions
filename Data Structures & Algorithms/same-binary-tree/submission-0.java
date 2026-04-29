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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrder(p,q);
    }

    private boolean inOrder(TreeNode p, TreeNode q){
        if(p == null && q== null){
            return true;
        }else if(p != null && q== null){
            return false;
        }else if(p == null && q!= null){
            return false;
        }

        if(!checker(p,q))
            return false;

        return inOrder(p.left, q.left) &&
        inOrder(p.right, q.right);
    }

    private boolean checker(TreeNode p, TreeNode q){
        if(q.val != p.val){
            return false;
        }else{
            return true;
        }
    }

  
}
