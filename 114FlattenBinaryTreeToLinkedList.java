/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, 
each node's right child points to the next node of a pre-order traversal.
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
public class Solution {
   public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
 
        while(p != null || !stack.empty()){
 
            if(p.right != null){
                stack.push(p.right);
            }
 
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                p.right=temp;
            }
 
            p = p.right;
        }
    }
  
    // public void flatten(TreeNode root) {  
    //     while (root != null) {  
    //         if (root.left != null) {  
    //             TreeNode p = root.left;  
    //             while (p.right != null) {  
    //                 p = p.right;  
    //             }  
    //             p.right = root.right;  
    //             root.right = root.left;  
    //             root.left = null;  
    //         }  
    //         root = root.right;  
    //     }  
    // } 
    
    // private TreeNode lastVisit = null;  
  
    // public void flatten(TreeNode root) {  
    //     if (root == null) {  
    //         return;  
    //     }  
    //     TreeNode savedRight = root.right;  
    //     if (lastVisit != null) {  
    //         lastVisit.left = null;  
    //         lastVisit.right = root;  
    //     }  
    //     lastVisit = root;  
    //     flatten(root.left);  
    //     flatten(savedRight);  
    // }  
    

}