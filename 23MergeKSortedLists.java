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

/*
/*
接下来我们来看第二种方法。这种方法用到了堆的数据结构，思路比较难想到，
但是其实原理比较简单。维护一个大小为k的堆，每次去堆顶的最小元素放到
结果中，然后读取该元素的下一个元素放入堆中，重新维护好。因为每个链表
是有序的，每次又是去当前k个元素中最小的，所以当所有链表都读完时结束，
这个时候所有元素按从小到大放在结果链表中。这个算法每个元素要读取一次
，即是k*n次，然后每次读取元素要把新元素插入堆中要logk的复杂度，所以
总时间复杂度是O(nklogk)。空间复杂度是堆的大小，即为O(k)。代码如下： 
*/ 
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