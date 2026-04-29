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
    List<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        int temp = Integer.MIN_VALUE;
        for(Integer i: list){
            if(i <= temp){
                return false;
            }
            temp = i;
        }

        return true;
    }

    private void inOrder(TreeNode root){
        if(root ==null){
            return;
        }
        //left
        inOrder(root.left);
        //root
        list.add(root.val);
        //right
        inOrder(root.right);
    }
}
