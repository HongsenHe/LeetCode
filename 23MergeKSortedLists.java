/*
Merge k sorted linked lists and return 
it as one sorted list. Analyze and describe its complexity.
*/

/**
 * code from ninechapter. just practice.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * 1. Comparator method
 * 2. create a Priority Queue
 * 3. compare with each level
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail =  head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        
        return dummy.next;
    }
    
    // anonymous inner class!
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            } 
            
            return left.val - right.val;
        }
    };
}