/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1 = head;
        Node curr = temp1;
        
        while (temp1 != null) {
            Node dummy = new Node(temp1.val);
            Node next = temp1.next;
            dummy.next = next;
            temp1.next = dummy;
            temp1 = next;
        }

        Node curr1 = curr;
        
        while (curr != null) {
            if (curr.next != null) {
                if(curr.random != null){
                    curr.next.random = curr.random.next;
                }else{
                    curr.next.random = null;
                }
                
                curr = curr.next.next;
            }
        }
        
        Node ans;
        if(curr1 != null){
            ans = curr1.next;
        }else{
            ans = null;
        } 
         while (curr1 != null) {
            if (curr1.next != null) {
                Node next = curr1.next.next;
                if(next != null){
                    curr1.next.next = next.next;
                }else{
                    curr1.next.next = null;
                }
                curr1.next = next;
                curr1 = next;
            }
        }

        return ans;
    }
}
