/*
Write an efficient algorithm that searches for 
a value in an m x n matrix. This matrix has the 
following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the 
last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

/*
binary search from row. then search column.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        if(matrix[0].length == 0 || matrix == null){
            return false;
        }
        int start, end, mid;
        start = 0; end = matrix.length -1;
        
        // find the row index
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        int row = start;
        if(matrix[end][0] <= target){
            row = end;
        }else if(matrix[start][0] <= target){
            row = start;
        }else{
            return false;
        }
            
        start = 0;
        end = matrix[0].length -1;
        
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(matrix[row][start] == target){
            return true;
        }else if(matrix[row][end] == target){
            return true;
        }else{
            return false;
        }
    }
}