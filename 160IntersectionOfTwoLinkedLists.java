/*
Write a program to find the node at which the intersection of two 
singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lengthA = 0;
        int lengthB = 0;
        ListNode h1 = headA;
        ListNode h2 = headB;
        
        while (h1 != null) {
            lengthA ++;
            h1 = h1.next;
        }
        while (h2 != null) {
            lengthB ++;
            h2 = h2.next;
        }
        
        if (h1 != h2) {
            return null;
        }    
       
        if (lengthA >= lengthB) {
            int diff = lengthA - lengthB;
            h1 = headA; 
            h2 = headB;
            while (diff > 0) {
                h1 = h1.next;
                diff--;
            }
        } else {
            int diff = lengthB - lengthA;
            h1 = headB;
            h2 = headA;
            while (diff > 0) {
                h1 = h1.next;
                diff--;
            }
        }
        
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return h1;
    }
}