/*

Given n pairs of parentheses, write a function to generate all combinations 
of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

/*
那么我们在什么情况下添加左括号呢？很明显，最多能添加n个左括号，
在递归调用的时候，在能传递到最底层的共用字符串中先添加"("，然
后left-1，递归调用就可以。
那什么时候添加右括号呢？当左括号个数大于右括号的个数时添加右括号。
那我们是先添加右括号还是先添加左括号呢？对于这个问题，认真
想想其实是无所谓的，只会影响在vector中最后字符串的顺序而已。
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        }
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String s, int left, int right) {
        // only if right is larger than left, add
        if (left > right || left < 0 || right < 0) {
            return;
        }
        // if no left and right, then add this valid to res
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        
        // recursion calling
        helper(res, s + "(", left - 1, right);
        helper(res, s + ")", left, right - 1);
    }
}