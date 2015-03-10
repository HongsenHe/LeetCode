/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res, list, num);
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            // key point
            list.add(num[i]);
            helper(res, list, num);
            list.remove(list.size() - 1);
        }
    }
}