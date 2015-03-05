/*
Given a binary tree containing digits from 0-9 only, 
each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which 
represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
这道题思路还是比较明确的，目标是把从根到叶子节点的所有路径得到的整数都累加起来，
递归条件即是把当前的sum乘以10并且加上当前节点传入下一函数，进行递归，最终把
左右子树的总和相加。结束条件的话就是如果一个节点是叶子，那么我们应该累加到结果
总和中，如果节点到了空节点，则不是叶子节点，不需要加入到结果中，直接返回0即可。
算法的本质是一次先序遍历，所以时间是O(n)，空间是栈大小，O(logn)。
*/
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs (TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}