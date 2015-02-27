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
 * Time O(n) Space O(n)
 *
 * Solution 3
 * Solution 4 
 * 这道题是动态规划的题目，所用到的方法跟是在Maximum Subarray中介绍的套路，
 * 用“局部最优和全局最优解法”。我们维护一个到目前为止能跳到的最远距离，
 * 以及从当前一步出发能跳到的最远距离。局部最优local=A[i]+i，
 * 而全局最优则是global=Math.max(global, local)。递推式出来了，
 * 代码就比较容易实现了。因为只需要一次遍历时间复杂度是O(n)，而空间上是O(1)。代码如下： 
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