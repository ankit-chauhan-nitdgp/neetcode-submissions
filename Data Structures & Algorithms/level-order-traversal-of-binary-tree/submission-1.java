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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int i = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        int depth = depth(root, 0); // returning 'i+1'
        for(int i= 0; i<depth; i++){ // so will take till 'i' 
            ans.add(new ArrayList<Integer>());
        }
        preOrder(root, 0);
        return ans;
    }

    public void preOrder(TreeNode root, int i){
        if(root == null){
            return;
        }
        System.out.println("i: "+i);
        ans.get(i).add(root.val);// root
        preOrder(root.left, i+1);//left
        preOrder(root.right, i+1);//right
    }

    private int depth(TreeNode root, int i){
        if(root == null){
            return i;
        }

        return Math.max(depth(root.left, i+1), depth(root.right, i+1));
    }
}
