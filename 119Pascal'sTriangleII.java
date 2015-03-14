/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // dp question, only store previous row
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        // initialize
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = res.size() - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}