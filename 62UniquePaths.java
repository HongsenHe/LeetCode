/*
A robot is located at the top-left corner of a m x n
 grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any 
point in time. The robot is trying to reach the bottom-right 
corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

/*
 * robot can only go down or left.
 * so each node comes from up or right (preNode).
 * each node calculate all its preNodes path
 * return the # of the finish node's path
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int [][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }
        
        return sum[m-1][n-1];
    }
}