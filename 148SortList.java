/*
Sort a linked list in O(n log n) time using constant space complexity.
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
 */

/*
如果只能扫一遍，很容易想到的就是左边存放0和1，右边存放2.两边往中间靠。

设置两个index，left记录第一个1的位置，left左边为0，right记录第一个非2的位置，right右边为2.

然后使用i从头到尾扫一遍，直到与right相遇。

i遇到0就换到左边去，遇到2就换到右边去，遇到1就跳过。

需要注意的是：由于left记录第一个1的位置，因此A[left]与A[i]交换后，A[left]为0,A[i]为1，因此i++；

而right记录第一个非2的位置，可能为0或1，因此A[right]与A[i]交换后，A[right]为2,A[i]为0或1，i不能前进，要后续判断。

由此该数组分为4段：[0,left)-->0; [left,i)-->1; [i,right]-->乱序; (right,n-1]-->2

0  0  0  1  1  1  2  1  0  2  1  2  2  2

           ^         ^             ^

          left         i            right



*/
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    private ListNode merge (ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        
        return dummy.next;
    }
    
    
    private ListNode findMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}