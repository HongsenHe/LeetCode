/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
 * 1. Find the mid point
 * 2. Reverse n/2 to n
 * 3. Merge 1 to n/2 with n/2 to n
 * 4. Combine three tools
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = findMid(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        
        merge(head,tail);
    }
    
    // 1. Find the mid point, using two pointer
    // when faster is at end, slower is at mid
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    // 2. Reverse n/2 to n
    private ListNode reverse(ListNode head) {
        // like a dummy node, be a new head
        ListNode head1 = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = head1;
            head1 = head;
            head = temp;
        }
        return head1;
    }
    
    // 3. Merge 1 to n/2 with n/2 to n
    private void merge (ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            
            dummy = dummy.next;
            index++;
        }
        
        // add the rest of list
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
}