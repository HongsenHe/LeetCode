/*
Sort a linked list using insertion sort.
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
这道题跟Sort List类似，要求在链表上实现一种排序算法，这道题是指定
实现插入排序。插入排序是一种O(n^2)复杂度的算法，基本想法相信大家都
比较了解，就是每次循环找到一个元素在当前排好的结果中相对应的位置，
然后插进去，经过n次迭代之后就得到排好序的结果了。了解了思路之后就
是链表的基本操作了，搜索并进行相应的插入。时间复杂度是排序算法的
O(n^2)，空间复杂度是O(1)。代码如下
*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
    if(head == null)
        return null;
    ListNode helper = new ListNode(0);
    ListNode pre = helper;
    ListNode cur = head;
    while(cur!=null)
    {
        ListNode next = cur.next;
        pre = helper;
        while(pre.next!=null && pre.next.val<=cur.val)
        {
            pre = pre.next;
        }
        cur.next = pre.next;
        pre.next = cur;
        cur = next;
    }
    return helper.next;
}
}

