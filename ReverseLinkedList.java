// a basic method from "reorder a list", leetcode
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
