/*
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length 
 * at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

/*
 * Solution 1
 * f[i]: can jump to position i
 * given i, find all possible solution from j to i
 * index + jump length > position i or can[j]
 * TLE n^2, space O(n)
 *
 * Solution 2
 * canStillWalk[i] reach i, then max length 
 * if canStillWalk[i] < 0, cannot reach i
 * canStillWalk[i] = max(canStillWalk[i-1), A[i-1]) - 1
 * wired...
 */
public class Solution {
    public boolean canJump(int[] A) {
        // boolean [] can = new boolean[A.length];
        // can[0] = true;
        
        // for (int i = 1; i < A.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (can[j] && j + A[j] >= i) {
        //             can[j] = true;
        //             break;
        //         }
        //     }
        // }
        
        // return can[A.length - 1];
        
        int n = A.length;
        if (n <= 1) return true;
        if (A[0] >= n-1) return true;
        
        int[] canStillWalk = new int[n];
        canStillWalk[0] = A[0];
        
        for (int i = 1; i < n; i++) {
            canStillWalk[i] = Math.max(canStillWalk[i - 1], A[i - 1]) - 1;
            if (canStillWalk[i] < 0) return false;
        }
        
        return canStillWalk[n - 1] >= 0;
    }
}