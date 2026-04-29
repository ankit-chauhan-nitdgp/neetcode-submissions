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

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        int depth = depth(root, 0);
        for(int i = 0; i<=depth; i++){
            ans.add(new ArrayList<Integer>());
        }
        preOrderTraversal(0,root);
        
        for(List<Integer> l: ans){
            int len = l.size();
            list.add(l.get(len-1));
        }

        return list;
        
    }

    private void preOrderTraversal(int i, TreeNode node){

         //root
        if(node == null){
            return;
        }
       
        if(node != null){
            ans.get(i).add(node.val);
        }

        //left
        preOrderTraversal(i+1, node.left);
        //right
        preOrderTraversal(i+1, node.right);
    }


    private int depth(TreeNode node, int i){
        if(node == null){
            return i-1;
        }

        return Math.max(depth(node.left, i+1),depth(node.right, i+1));
    }


}
