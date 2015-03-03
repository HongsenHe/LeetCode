/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
two pointer, faster and slow. And one dummy node. let faster goes to nth position
then move them together, once faster hits the end, slower is on target.prev, remove
*/
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		ListNode d = new ListNode(0);
		d.next = head;
		ListNode f = d;
		ListNode s = d;
		
		for(int i = 0; i < n; i++){
			f = f.next;
		}
		
		while(f.next != null){
			f = f.next;
			s = s.next;
		}
		if(s.next != null){
			s.next = s.next.next;
		}
		
		return d.next;
	}
}