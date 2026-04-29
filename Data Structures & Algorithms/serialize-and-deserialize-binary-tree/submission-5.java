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

public class Codec {

    private String serial = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                serial = serial+node.val+"v";
                q.offer(node.left);
                q.offer(node.right);
            }else{
                serial = serial+"n";
            }
        }

        // System.out.println("serial");
        return serial;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();

        // System.out.println("deserial :"+data);
        if(len == 0){
            return new TreeNode();
        }
        List<TreeNode> nodeList = new ArrayList<TreeNode>();

        String temp = "";
        for(int i = 0; i< len; i++){
            char c = data.charAt(i);
            if(c == 'v'){
                int val = Integer.parseInt(String.valueOf(temp));
                nodeList.add(new TreeNode(val));
                temp = "";
            }else if(c == 'n'){
                TreeNode nullNode = null;
                nodeList.add(nullNode);
                temp = "";
            }else{
                temp = temp+c;
            }
        }

        int nodeListSize = nodeList.size();

        
         
        int idx = 0;
        for(int i = 0; i < nodeListSize; i++){
            TreeNode node = nodeList.get(i);
            // if(node == null){
            //     System.out.println("deserial node: null , idx:" +idx+" i: "+i);
            // }else{
            //     System.out.println("deserial node: "+node.val+", idx:" +idx+" i: "+i);
            // }
            int left = 2*idx + 1;
            int right = 2*idx + 2;
            if(node != null){
                if(left < nodeListSize){
                    node.left = nodeList.get(left);
                }

                if(right < nodeListSize){
                    node.right = nodeList.get(right);
                }
                idx++;
            }
        }

        return nodeList.get(0);

    }
}
