/*
Given a linked list, return the node where the 
cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Set up two pointer, faster = 2 * slower
 * When f meets s. put s to start, faster = slower
 * When f meets s again, that node is the entry
 * of the cycle
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast, slow;
        fast = slow = head;
        
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        
        while (head != slow) {
            // start going from head, when meets slow
            // find the head (entry of the cycle)
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}