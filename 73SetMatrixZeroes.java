/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

/*
1. check if first row and col are zero or not
2. mark zeros on first row and column
3. use mark to set elements
4. set first col and row by using marks in step1
*/
public class Solution {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean firstRow = false;
		boolean firstCol = false;
		
        // step 1
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstCol = true;
				break;
			}
		}
		
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRow = true;
				break;
			}
		}
		
        // step2
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
        // step3
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
        // step4
		if (firstRow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if (firstCol) {
			for (int j = 0; j < m; j++) {
				matrix[j][0] = 0;
			}
		}
	}
}