/*
Given a sorted linked list, delete all nodes that 
have duplicate numbers, leaving only distinct numbers 
from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
create a dummy node as the head could be changed
go through until n-2 node. if equal keep going. 
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                
                while(head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}