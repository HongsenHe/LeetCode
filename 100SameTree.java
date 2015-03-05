/*
Given two binary trees, 
write a function to check if they are equal or not.

Two binary trees are considered equal if they are 
structurally identical and the nodes have the same value.
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
compare the root value, then compare left of p and q
then compare right child of p and q
*/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
            }
        }else{
            return false;
        }

        return false;
    }
}