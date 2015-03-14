/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int [] [] A = new int [numRows][numRows];
        
        // initial first and last slot to 1
        for (int i = 0; i < numRows; i++) {
            A[i][0] = 1;
            A[i][i] = 1; 
        }
        
        // dp formula: A[i][j] = A[i-1][j-1] + A[i-1][j]
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                A[i][j] = A[i-1][j-1] + A[i-1][j];
            }
            
            ArrayList<Integer> temp = new ArrayList<Integer>();

            for (int k = 0; k <= i; k++) {
                temp.add(A[i][k]);
            }
            res.add(temp);
        }
        
        return res;
    }
}