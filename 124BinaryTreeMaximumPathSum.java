/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
 * compare only left path with right path
 * Then compare max with path cross root
 * Maybe a negative sum, max = 0;
 */

/*
这道题是求树的路径和的题目，不过和平常不同的是这里的路径不仅可以从根到
某一个结点，而且路径可以从左子树某一个结点，然后到达右子树的结点，就像
题目中所说的可以起始和终结于任何结点。在这里树没有被看成有向图，而是被
当成无向图来寻找路径。因为这个路径的灵活性，我们需要对递归返回值进行一
些调整，而不是通常的返回要求的结果。在这里，函数的返回值定义为以自己为
根的一条从根到子结点的最长路径（这里路径就不是当成无向图了，必须往单方
向走）。这个返回值是为了提供给它的父结点计算自身的最长路径用，而结点自
身的最长路径（也就是可以从左到右那种）则只需计算然后更新即可。这样一来，
一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子
树的返回值（如果大于0的话），再加上自己的值。而返回值则是自己的值加上
左子树返回值，右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为
返回值只取一支的路径和）。在过程中求得当前最长路径时比较一下是不是目前
最长的，如果是则更新。算法的本质还是一次树的遍历，所以复杂度是O(n)。
而空间上仍然是栈大小O(logn)。代码如下：
*/
public class Solution {
    private class ResultType{
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        // may be a negative number
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
        
    }
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
    
    
}