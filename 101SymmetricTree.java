/*
Given a binary tree, check whether it is a mirror of 
itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
if it is a mirror. both leaves = null -> true
recursive call root, left1 with righ2, left2 with right1
*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return (p.val == q.val) && helper(p.left, q.right) && helper(p.right, q.left);
    }
}