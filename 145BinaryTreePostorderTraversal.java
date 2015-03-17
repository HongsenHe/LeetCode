/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
  * 1）如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），
  * 那么就把当前结点移到右结点继续循环；
  * 2）如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，
  * 应该访问自己继续回溯了。
  */
  
public class Solution {
    // // recursion way
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     helper (root, res);
    //     return res;
    // }
    
    // private void helper (TreeNode root, List<Integer> res) {
    //     if (root == null) return;
    //     helper (root.left, res);
    //     helper (root.right, res);
    //     res.add(root.val);
    // }
    
    // iteratively way
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null) {
            return res;
        } 
        
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != pre) {
                    root = peekNode.right;
                } else {
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        
        return res;
    }
    
}