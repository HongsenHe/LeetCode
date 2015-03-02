/*
Given a binary tree, return the zigzag level order 
traversal of its nodes' values. (ie, from left to right, 
then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
reverse every other level
*/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
  
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        if (root == null) {  
            return res;  
        }  
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        
        queue.offer(root);  
        boolean reverse = false;  
        while (!queue.isEmpty()) {  
            ArrayList<Integer> level = new ArrayList<Integer>();  

            int size = queue.size();  
            for (int i = 0; i < size; i++) {  
                TreeNode node = queue.poll();  
                level.add(node.val);  
                
                if (node.left != null)  
                    queue.offer(node.left);  
                if (node.right != null)  
                    queue.offer(node.right);  
            }  
            
            // key point
            if (reverse) {  
                Collections.reverse(level);  
                reverse = false;  
            }  
            else  
                reverse = true;  
            res.add(level);  
        }  
        
        return res;  
    }
}

