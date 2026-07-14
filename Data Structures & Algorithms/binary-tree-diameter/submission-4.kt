/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var ans = 0;
    fun diameterOfBinaryTree(root: TreeNode?): Int {    
        if(root == null){
            return 0;
        }

        diameterHelper(root)
        return ans
    }

    fun diameterHelper(root: TreeNode?){

        if(root == null){
            return
        }
        
        diameterHelper(root.left)
        diameterHelper(root.right)


        val leftDepth = maxDepthMeasure(root.left)
        val rightDepth =  maxDepthMeasure(root.right);

        ans = max(ans, leftDepth+rightDepth);

    }

    fun maxDepthMeasure(root: TreeNode?): Int{
        if(root == null){
            return 0
        }

        return max(maxDepthMeasure(root.left), maxDepthMeasure(root.right))+1;
    }
}
