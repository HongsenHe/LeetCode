/*
Given a sorted array of integers, find the starting and 
ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        int start, end, mid;
        
        // find start
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            mid = start + (end-start)/2;
            if(A[mid] == target){
                end = mid;
            }else if(A[mid] > target){
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }
        }
        if(A[start] == target){
            ret[0] = start;
        }else if(A[end] == target){
            ret[0] = end;
        }else{
            ret[0] = ret[1] = -1;
            return ret;
        }
        
        // find end
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(A[mid] == target){
                start = mid;
            }else if(A[mid] > target){
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }
        }
        if(A[end] == target){
            ret[1] = end;
        }else if(A[start] == target){
            ret[1] = start;
        }else{
            ret[0] = ret[1] = -1;
            return ret;
        }
        
        return ret;
    }
}