/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head == null){
            return head
        }

        var fastNode:ListNode? = null
        var slowNode:ListNode? = null

        for(i: Int in 1 .. n){
            if(fastNode != null){
                fastNode = fastNode?.next
            }else{
                fastNode = head
            }
        }

        while(fastNode?.next != null){
            if(slowNode == null){
                slowNode = head
            }else{
                slowNode = slowNode?.next
            }
            fastNode = fastNode?.next
        }

        if(slowNode == null){
            return head?.next
        }else{
            slowNode?.next = slowNode?.next?.next
        }

        return head
    }
}
