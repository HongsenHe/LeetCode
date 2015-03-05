/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along 
the longest path from the root node down to the farthest leaf node.
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

// recursion
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// iterative
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }   
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int cur = 1; // number of nodes left in cur level
        int next = 0; // number of nodes in next level
        
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            cur--;
            
            if (n.left != null) {
                queue.add(n.left);
                next++;
            }
            if (n.right != null) {
                queue.add(n.right);
                next++;
            }
            if (cur == 0) {
                cur= next;
                next = 0;
                level++;
            }
        }
        return level;
    }
}