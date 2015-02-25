/*
Given an array where elements 
are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
root is mid, left is start and mid-1, right = mid+1 and end
*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(num[(start + end) / 2]);
        root.left = helper(num, start, (start + end) / 2 -1);
        root.right = helper(num, (start + end) / 2 + 1, end);
        return root;
    }
}