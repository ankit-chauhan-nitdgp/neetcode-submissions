/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null){
            return head;
        }

        ListNode temp = head;
        int n = 0;

        while(temp != null){
            n++;
            temp = temp.next;
        }

        if(n < k){
            return head;
        }

        int groupCount = n/k;

        return reverseHelper(head, groupCount, k);

    }

    private ListNode reverseHelper(ListNode head, int groupCount, int k){
        if(groupCount == 0){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        for(int i = 0; i<k; i++){
            ListNode temp = curr;
            curr.next = prev;
            curr = next;
            prev = temp;
            if(next != null){
                next = next.next;
            }
        }

        head.next = reverseHelper(curr, groupCount-1, k);

        return prev;

    }
}
