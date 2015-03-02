/*
Given a singly linked list where elements are sorted 
in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * find the mid let left child and right child balanced
 * connect root with left and right
 */
public class Solution {
    private ListNode current;
      
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }    
    
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head);
        
        return helper(size);
    }
    public TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }
        
        // divide
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(size - 1 - size / 2);
        
        // conquer
        root.left = left;
        root.right = right;
        
        return root;
    }
}