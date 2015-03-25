/*
Given a sorted integer array where the range of elements are [lower, upper] 
inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return 
["2", "4->49", "51->74", "76->99"].
*/

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (A == null || A.length == 0) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else {
                String empty = String.valueOf(lower) + "->" + String.valueOf(upper);
                res.add(empty);
            }
            return res;
        }
        
        // lower bound
        if (lower < A[0]) {
            String low = "";
            if (lower != A[0] - 1) {
                low = String.valueOf(lower) + "->" + String.valueOf(A[0] - 1);
            } else {
                low = String.valueOf(lower);
            }
            res.add(low);
        }
        
        // in array
        for (int i = 0; i < A.length - 1; i++) {
            int left = A[i];
            int right = A[i + 1];
            String range = "";
            if (right - left > 2) {
                range = String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
                res.add(range);
            } else if (right - left == 2){
                range = String.valueOf(left + 1);
                res.add(range);
            }
        }
        
        // upper bound
        if (upper > A[A.length - 1]) {
            String high = "";
            if (upper != A[A.length - 1] + 1) {
                high = String.valueOf(A[A.length - 1] + 1) + "->" + String.valueOf(upper);
            } else {
                high = String.valueOf(upper);
            }
            res.add(high);
        }
        
        return res;
    }
}