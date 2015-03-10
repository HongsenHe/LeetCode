/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        helper(res, list, n, k, 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer>list, int n, int k, int start) {
        // end condition
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}