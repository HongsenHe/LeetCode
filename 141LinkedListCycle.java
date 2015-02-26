/*
Given a linked list, determine if it has a cycle in it.

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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        do {
            if (fast.next == null || fast.next.next == null) {
                return false;
            } 
            
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        
        return true;
    }
}