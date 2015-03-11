/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(res, list, num, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] num, int pos) {
        
        res.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            helper(res, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}