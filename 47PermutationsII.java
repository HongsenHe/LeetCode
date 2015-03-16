/*
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        Arrays.sort(num);
        helper(res, list, visited, num);
        return res;
    }
    
    void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] visited, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) {
            // pruning
            // TLE!!!!!!!!
            // if (i > 0 && visited[i - 1] == 1 && num[i] == num[i - 1]) {
            //     continue;
            // }
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
                continue;
            }
            
            visited[i] = 1;
            list.add(num[i]);
            helper(res, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}