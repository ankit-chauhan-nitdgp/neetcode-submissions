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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return  helper(preorder, inorder);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;

        if(n == 0){
            return null;
        }
        if(n == 1){
            TreeNode node = new TreeNode(preOrder[0]);
            node.left = null;
            node.right = null;
            return node;
        }

        TreeNode root = new TreeNode(preOrder[0]);

        int idx = 0;
        for(int i = 0; i< n; i++){
            if(inOrder[i] == root.val){
                break;
            }
            idx++;
        }

        int[] lstPre = new int[idx];
        int[] lstIn = new int[idx];
        int rstLen = n - idx -1;
        int[] rstPre = new int[rstLen];
        int[] rstIn =new int[rstLen];

        //lst pre order 
        for(int i = 1; i<= idx; i++){
            lstPre[i-1] = preOrder[i];
        }
        //rst pre order
        int counter = 0;
        for(int i = idx+1; i <n; i++){
            rstPre[counter] = preOrder[i];
            counter++;
        }

        //lst in order 
        for(int i = 0; i< idx; i++){
            lstIn[i] = inOrder[i];
        }
        //rst in order
        counter = 0;
        for(int i = idx+1; i <n; i++){
            rstIn[counter] = inOrder[i];
            counter++;
        }

        root.left = helper(lstPre, lstIn);
        root.right = helper(rstPre, rstIn);

        return root;
    }
}
